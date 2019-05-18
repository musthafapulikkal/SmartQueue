package com.example.smartqueue.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smartqueue.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserViewQueue extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
    String id;
    ArrayList<String> seatlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_queue);
        seatlist=new ArrayList<String>();
        b1=(Button)findViewById(R.id.qseat1);
        b2=(Button)findViewById(R.id.qseat2);
        b3=(Button)findViewById(R.id.qseat3);
        b4=(Button)findViewById(R.id.qseat4);
        b5=(Button)findViewById(R.id.qseat5);
        b6=(Button)findViewById(R.id.qseat6);
        b7=(Button)findViewById(R.id.qseat7);
        b8=(Button)findViewById(R.id.qseat8);
        b9=(Button)findViewById(R.id.qseat9);
        b10=(Button)findViewById(R.id.qseat10);
        b11=(Button)findViewById(R.id.qseat11);
        b12=(Button)findViewById(R.id.qseat12);
        b13=(Button)findViewById(R.id.qseat13);
        b14=(Button)findViewById(R.id.qseat14);
        b15=(Button)findViewById(R.id.qseat15);
        b16=(Button)findViewById(R.id.qseat16);
        b17=(Button)findViewById(R.id.qseat17);
        b18=(Button)findViewById(R.id.qseat18);
        b19=(Button)findViewById(R.id.qseat19);
        b20=(Button)findViewById(R.id.qseat20);
        Intent intent=getIntent();
        String response=intent.getStringExtra("response");
        try {
            JSONArray jsonArray=new JSONArray(response);
            for (int i=0;i<=jsonArray.length();i++)
            {
                JSONObject jsonObject=(JSONObject)jsonArray.get(i);
                id=jsonObject.optString("id");
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestQueue requestQueue= Volley.newRequestQueue(UserViewQueue.this);
        String Url="http://smartq.fabstudioz.com/user_view_seat.php";
        String Url2="http://smartq.fabstudioz.com/q_status.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("uqresopnse",response);
                if (response.equals("10"))
                {
                    b11.setVisibility(View.GONE);
                    b12.setVisibility(View.GONE);
                    b13.setVisibility(View.GONE);
                    b12.setVisibility(View.GONE);
                    b13.setVisibility(View.GONE);
                    b14.setVisibility(View.GONE);
                    b15.setVisibility(View.GONE);
                    b16.setVisibility(View.GONE);
                    b17.setVisibility(View.GONE);
                    b18.setVisibility(View.GONE);
                    b19.setVisibility(View.GONE);
                    b20.setVisibility(View.GONE);

                }
                else if (response.equals("11"))
                {
                    b12.setVisibility(View.GONE);
                    b13.setVisibility(View.GONE);
                    b14.setVisibility(View.GONE);
                    b15.setVisibility(View.GONE);
                    b16.setVisibility(View.GONE);
                    b17.setVisibility(View.GONE);
                    b18.setVisibility(View.GONE);
                    b19.setVisibility(View.GONE);
                    b20.setVisibility(View.GONE);
                }
                else if (response.equals("12"))
                {
                    b13.setVisibility(View.GONE);
                    b14.setVisibility(View.GONE);
                    b15.setVisibility(View.GONE);
                    b16.setVisibility(View.GONE);
                    b17.setVisibility(View.GONE);
                    b18.setVisibility(View.GONE);
                    b19.setVisibility(View.GONE);
                    b20.setVisibility(View.GONE);
                }
                else if (response.equals("13"))
                {
                    b14.setVisibility(View.GONE);
                    b15.setVisibility(View.GONE);
                    b16.setVisibility(View.GONE);
                    b17.setVisibility(View.GONE);
                    b18.setVisibility(View.GONE);
                    b19.setVisibility(View.GONE);
                    b20.setVisibility(View.GONE);
                }
                else if (response.equals("14"))
                {
                    b15.setVisibility(View.GONE);
                    b16.setVisibility(View.GONE);
                    b17.setVisibility(View.GONE);
                    b18.setVisibility(View.GONE);
                    b19.setVisibility(View.GONE);
                    b20.setVisibility(View.GONE);
                }
                else if (response.equals("15"))
                {
                    b16.setVisibility(View.GONE);
                    b17.setVisibility(View.GONE);
                    b18.setVisibility(View.GONE);
                    b19.setVisibility(View.GONE);
                    b20.setVisibility(View.GONE);
                }
                else if (response.equals("16"))
                {
                    b17.setVisibility(View.GONE);
                    b18.setVisibility(View.GONE);
                    b19.setVisibility(View.GONE);
                    b20.setVisibility(View.GONE);
                }
                else if (response.equals("17"))
                {
                    b18.setVisibility(View.GONE);
                    b19.setVisibility(View.GONE);
                    b20.setVisibility(View.GONE);
                }
                else if (response.equals("18"))
                {
                    b19.setVisibility(View.GONE);
                    b20.setVisibility(View.GONE);
                }
                else if (response.equals("19"))
                {
                    b20.setVisibility(View.GONE);
                }
                else if (response.equals("20"))
                {
                }
                else
                {
                    Toast.makeText(UserViewQueue.this, "failed", Toast.LENGTH_SHORT).show();
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
                params.put("did",id);
                return params;
            }
        };
        requestQueue.add(stringRequest);

        StringRequest stringRequest1=new StringRequest(Request.Method.POST, Url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("qqq",response);
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for (int i=0;i<=jsonArray.length();i++)
                    {
                        JSONObject jsonObject=(JSONObject)jsonArray.get(i);
                        String seat=jsonObject.optString("seat");
                        seatlist.add(seat);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (seatlist.contains("1"))
                {
                    b1.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("2"))
                {
                    b2.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("3"))
                {
                    b3.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("4"))
                {
                    b4.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("5"))
                {
                    b5.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("6"))
                {
                    b6.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("7"))
                {
                    b7.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("8"))
                {
                    b8.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("9"))
                {
                    b9.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("10"))
                {
                    b10.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("11"))
                {
                    b11.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("12"))
                {
                    b2.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("13"))
                {
                    b13.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("14"))
                {
                    b14.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("15"))
                {
                    b15.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("16"))
                {
                    b16.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("17"))
                {
                    b17.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("18"))
                {
                    b18.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("19"))
                {
                    b19.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (seatlist.contains("20"))
                {
                    b20.setBackgroundColor(getResources().getColor(R.color.green));
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
                params.put("did",id);
                return params;
            }
        };
        requestQueue.add(stringRequest1);
    }
}
