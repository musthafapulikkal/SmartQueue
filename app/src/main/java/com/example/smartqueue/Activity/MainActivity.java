package com.example.smartqueue.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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

public class MainActivity extends AppCompatActivity {
   EditText edt_email,edt_password;
   Button btn_login;
   TextView txt_gotoreg;
   TextView txtdisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_email=(EditText)findViewById(R.id.id_email);
        edt_password=(EditText)findViewById(R.id.id_password);
        btn_login=(Button)findViewById(R.id.btn_login);
        txt_gotoreg=(TextView)findViewById(R.id.id_gotoreg);
        txtdisplay=(TextView)findViewById(R.id.textview2);
        Intent intent=getIntent();
        String type=intent.getStringExtra("type");
        if (type.equals("admin"))
        {
            txt_gotoreg.setVisibility(View.GONE);
            txtdisplay.setText("Admin Login Form");
        }
        else if (type.equals("user"))
        {
            txt_gotoreg.setVisibility(View.VISIBLE);
        }
        else
        {

        }
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email=edt_email.getText().toString().trim();
                final String password=edt_password.getText().toString().trim();
                if (TextUtils.isEmpty(email))
                {
                    edt_email.setError("please fill this field");
                    edt_email.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    edt_password.setError("please fill this field");
                    edt_password.requestFocus();
                    return;
                }
                if (email.equals("admin@gmail.com")&&password.equals("admin"))
                {
                    startActivity(new Intent(getApplicationContext(),AdminHomeActivity.class));
                }
                else
                {
                    userLogin(email,password);
                }

            }
        });
        txt_gotoreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UserRegistrationActivity.class));
            }
        });

    }

    private void userLogin(final String email, final String password) {
        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        String Url="http://smartq.fabstudioz.com/userlogin.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            if (response.equals(email)){
                startActivity(new Intent(getApplicationContext(),UserHomeActivity.class));
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
}
