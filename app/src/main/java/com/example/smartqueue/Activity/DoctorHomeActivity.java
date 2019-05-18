package com.example.smartqueue.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartqueue.R;

import static com.example.smartqueue.Activity.DoctorLoginActivity.MyPREFERENCES;

public class DoctorHomeActivity extends AppCompatActivity {
Button btn_add_seat,btn_generate_q,btn_send_notification,btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
        btn_add_seat=(Button)findViewById(R.id.id_doc_home_add_seats);
        btn_generate_q=(Button)findViewById(R.id.doc_hom_generate_q);
        btn_send_notification=(Button)findViewById(R.id.send_notification_doc);
        btn_logout=(Button)findViewById(R.id.logout_doc);
        btn_add_seat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DocAddSeatActivity.class));
            }
        });
        btn_generate_q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DoctorGenerateQactivity.class));
            }
        });
        btn_send_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddNotificationActivity.class));
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences =getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                startActivity(new Intent(getApplicationContext(),IndexActivity.class));
                finish();
            }
        });


    }
}
