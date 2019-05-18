package com.example.smartqueue.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smartqueue.Adapter.NewRequestAdapter;
import com.example.smartqueue.Others.Doctors;
import com.example.smartqueue.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ViewNewRequests extends AppCompatActivity {
    private List<Doctors> doctorsList=new ArrayList<>();
    private RecyclerView recyclerView;
    private NewRequestAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_new_requests);
        mAdapter = new NewRequestAdapter(doctorsList);
        recyclerView = (RecyclerView) findViewById(R.id.admin_newrequest_recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        RequestQueue requestQueue= Volley.newRequestQueue(ViewNewRequests.this);
        String Url="http://smartq.fabstudioz.com/newrequest.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    Context context=getApplicationContext();
                    for (int i=0;i<=jsonArray.length();i++)
                    {
                        JSONObject jsonObject=(JSONObject)jsonArray.get(i);
                        String id=jsonObject.optString("id");
                        String name=jsonObject.optString("name");
                        String clinick=jsonObject.getString("clinick");
                        String image=jsonObject.optString("image");
                        Doctors doctors=new Doctors(id,name,clinick,image,context);
                        doctorsList.add(doctors);
                        mAdapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
}
