package com.example.smartqueue.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

public class DoctorLoginActivity extends AppCompatActivity {
TextView txt_gotoreg;
EditText edt_email,edt_pass;
Button btn_login;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String doc_email = "usenamekey";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);
        txt_gotoreg=(TextView)findViewById(R.id.goto_doc_reg);
        edt_email=(EditText)findViewById(R.id.id_log_doc_email);
        edt_pass=(EditText)findViewById(R.id.id_log_doc_password);
        btn_login=(Button)findViewById(R.id.doc_login);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        txt_gotoreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DoctorRegistration.class));
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email=edt_email.getText().toString().trim();
                final String password=edt_pass.getText().toString().trim();
                RequestQueue requestQueue= Volley.newRequestQueue(DoctorLoginActivity.this);
                String Url="http://smartq.fabstudioz.com/doc_login.php";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("responselog",response);
                        if (response.equals(email))
                        {
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString(doc_email,email);
                            editor.apply();
                            startActivity(new Intent(getApplicationContext(),DoctorHomeActivity.class));
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
                        params.put("email",email);
                        params.put("password",password);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });

    }
}
