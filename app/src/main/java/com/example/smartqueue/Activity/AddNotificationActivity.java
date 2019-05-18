package com.example.smartqueue.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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

public class AddNotificationActivity extends AppCompatActivity {
EditText edt_notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notification);
        edt_notification=(EditText)findViewById(R.id.edt_notification);
        findViewById(R.id.btn_send_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String enotification=edt_notification.getText().toString().trim();
                RequestQueue requestQueue= Volley.newRequestQueue(AddNotificationActivity.this);
                String Url="http://smartq.fabstudioz.com/addnotification.php";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("notres",response);
                        if (response.equals("success"))
                        {
                            startActivity(new Intent(getApplicationContext(),DoctorHomeActivity.class));
                            finish();
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
                        params.put("notification",enotification);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
    }
}
