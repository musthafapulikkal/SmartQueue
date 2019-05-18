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

public class BookDetailsActivity extends AppCompatActivity {
TextView txt_token;
EditText edt_patient,edt_phone,edt_age;
Button btn_book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        txt_token=(TextView)findViewById(R.id.txt_tk_no);
        edt_patient=(EditText)findViewById(R.id.tk_name);
        edt_age=(EditText)findViewById(R.id.tk_age);
        edt_phone=(EditText)findViewById(R.id.tk_phone);
        btn_book=(Button)findViewById(R.id.tk_book);
        Intent intent=getIntent();
        final String doc_id=intent.getStringExtra("docid");
        final String token=intent.getStringExtra("token");
        txt_token.setText(token);
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name=edt_patient.getText().toString().trim();
                final String age=edt_age.getText().toString().trim();
                final String phone=edt_phone.getText().toString().trim();
                if (TextUtils.isEmpty(name))
                {
                    edt_patient.setError("please fill this field");
                    edt_patient.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(age))
                {
                    edt_age.setError("please fill this field");
                    edt_age.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(phone))
                {
                    edt_phone.setError("please fill this field");
                    edt_phone.requestFocus();
                    return;
                }
                RequestQueue requestQueue= Volley.newRequestQueue(BookDetailsActivity.this);
                String Url="http://smartq.fabstudioz.com/bookseat.php";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("success"))
                        {
                            startActivity(new Intent(getApplicationContext(),UserHomeActivity.class));
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
                        params.put("docid",doc_id);
                        params.put("patient",name);
                        params.put("phone",phone);
                        params.put("age",age);
                        params.put("token",token);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });

    }
}
