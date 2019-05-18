package com.example.smartqueue.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartqueue.R;

public class UserViewSingleDoctorActivity extends AppCompatActivity {
Button btn_view_token,btn_q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_single_doctor);
        btn_view_token=(Button)findViewById(R.id.user_single_btn_viewseat);
        btn_q=(Button)findViewById(R.id.user_single_btn_view_q);
        Intent i=getIntent();
        final String response=i.getStringExtra("response");
        btn_view_token.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),UserViewSeatActivity.class);
                intent.putExtra("response",response);
                startActivity(intent);
            }
        });
        btn_q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),UserViewQueue.class);
                intent.putExtra("response",response);
                startActivity(intent);
            }
        });
    }
}
