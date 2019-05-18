package com.example.smartqueue.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smartqueue.R;

import java.util.HashMap;
import java.util.Map;

import static com.example.smartqueue.Activity.DoctorLoginActivity.MyPREFERENCES;
import static com.example.smartqueue.Activity.DoctorLoginActivity.doc_email;

public class DocAddSeatActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter_seat;
    String[] seats={"10","11","12","13","14","15","16","17","18","19","20"};
    Button btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_add_seat);
        btn_add=(Button)findViewById(R.id.btn_add_seat);
       final Spinner seat_spinner=(Spinner)findViewById(R.id.spinner_seat);
        adapter_seat=new ArrayAdapter(this,android.R.layout.simple_spinner_item, seats);
        adapter_seat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seat_spinner.setAdapter(adapter_seat);
        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        final String d_email=prefs.getString(doc_email,null);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final String seat=seat_spinner.getSelectedItem().toString().trim();
                RequestQueue requestQueue= Volley.newRequestQueue(DocAddSeatActivity.this);
                String Url="http://smartq.fabstudioz.com/doc_addseat.php";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("responseaddseat",response);
                        if (response.equals("success"))
                        {
                            startActivity(new Intent(getApplicationContext(),DoctorHomeActivity.class));
                            finish();
                        }
                        else if (response.equals("exist"))
                        {
                            Toast.makeText(DocAddSeatActivity.this, "already added", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params=new HashMap<>();
                        params.put("seat",seat);
                        params.put("d_email",d_email);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
    }
}
