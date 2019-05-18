package com.example.smartqueue.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smartqueue.Adapter.DoctorAdapter;
import com.example.smartqueue.Others.Doctors;
import com.example.smartqueue.Others.RecyclerTouchListner;
import com.example.smartqueue.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserDoctorListActivity extends AppCompatActivity {
    private List<Doctors> doctorsList=new ArrayList<>();
    private RecyclerView recyclerView;
    private DoctorAdapter mAdapter;
    String response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_doctor_list);
        mAdapter = new DoctorAdapter(doctorsList);
        recyclerView = (RecyclerView) findViewById(R.id.user_doctor_recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListner(getApplicationContext(), recyclerView, new RecyclerTouchListner.ClickListener() {
            @Override
            public void onClick(View view, int position) {
             Intent intent=new Intent(getApplicationContext(),UserViewSingleDoctorActivity.class);
             intent.putExtra("response",response);
             startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        Intent intent=getIntent();
        response=intent.getStringExtra("response");
        try {
            JSONArray jsonArray=new JSONArray(response);
            Context context=getApplicationContext();
            for (int i=0;i<=jsonArray.length();i++)
            {
                JSONObject jsonObject=(JSONObject)jsonArray.get(i);
                String id=jsonObject.optString("id");
                String name=jsonObject.optString("name");
                String clinick=jsonObject.optString("clinick");
                String image=jsonObject.optString("image");
                Doctors doctors=new Doctors(id,name,clinick,image,context);
                doctorsList.add(doctors);
                mAdapter.notifyDataSetChanged();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
