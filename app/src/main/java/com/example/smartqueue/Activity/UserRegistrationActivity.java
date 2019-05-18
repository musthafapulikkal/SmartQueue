package com.example.smartqueue.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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

public class UserRegistrationActivity extends AppCompatActivity {
    EditText edt_email,edt_name,edt_contact,edt_pass,edt_confirm;
    Button btn_register;
    TextView txt_gotolog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        edt_email=(EditText)findViewById(R.id.id_reg_email);
        edt_name=(EditText)findViewById(R.id.id_reg_name);
        edt_contact=(EditText)findViewById(R.id.id_reg_contact);
        edt_pass=(EditText)findViewById(R.id.id_reg_password);
        edt_confirm=(EditText)findViewById(R.id.id_confirm_pass);
        btn_register=(Button)findViewById(R.id.btn_register);
        txt_gotolog=(TextView)findViewById(R.id.id_reg_gotologin);
        txt_gotolog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email=edt_email.getText().toString().trim();
                final String name=edt_name.getText().toString().trim();
                final String contact=edt_contact.getText().toString().trim();
                final String password=edt_pass.getText().toString().trim();
                final String confirm=edt_confirm.getText().toString().trim();
                if (TextUtils.isEmpty(email))
                {
                    edt_email.setError("please fill this field");
                    edt_email.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(name))
                {
                    edt_name.setError("please fill this field");
                    edt_name.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(contact))
                {
                    edt_contact.setError("please fill this field");
                    edt_contact.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password))
                {
                    edt_pass.setError("please fill this field");
                    edt_pass.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(confirm))
                {
                    edt_confirm.setError("please fill this field");
                    edt_confirm.requestFocus();
                    return;
                }
                if (!password.equals(confirm))
                {
                    edt_pass.getText().clear();
                    edt_confirm.getText().clear();
                    edt_pass.setError("please enter correct password");
                    edt_pass.requestFocus();
                    return;
                }
                else {
                    RequestQueue requestQueue = Volley.newRequestQueue(UserRegistrationActivity.this);
                    String Url = "http://smartq.fabstudioz.com/user_registration.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.v("response ureg",response);
                            if (response.equals("success"))
                            {
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                intent.putExtra("type","user");
                                startActivity(intent);
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("email", email);
                            params.put("name", name);
                            params.put("contact", contact);
                            params.put("password", password);
                            return params;
                        }
                    };
                    requestQueue.add(stringRequest);
                }
            }
        });

    }

}
