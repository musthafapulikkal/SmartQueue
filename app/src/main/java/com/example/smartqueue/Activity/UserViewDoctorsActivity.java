package com.example.smartqueue.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

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

public class UserViewDoctorsActivity extends AppCompatActivity {
    ArrayAdapter<CharSequence> adapter_state;
    ArrayAdapter<CharSequence> adapter_dist;
    ArrayAdapter<CharSequence> adapter_city;
    String[] state={"--state--","Kerala","Tamilnadu"};
    String[] district={"--District--","Trivandrum","Pathanamthitta","Alappuzha","Kottayam","Idukki","Ernakulam","Thrissur","Malappuram","Palakkad","Vayanad","Kollam","Kozhikkod","Kannur","Kasargod"};
    Button btn_search;
    private ArrayList<String> cities;
    private ArrayList<String> cityid;
    Spinner city_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_doctors);
        btn_search=(Button)findViewById(R.id.id_user_btn_search);
        cityid=new ArrayList<String>();
        cities=new ArrayList<String>();
        city_spinner=(Spinner)findViewById(R.id.id_spinner_city_user);
        final Spinner state_spinner=(Spinner)findViewById(R.id.id_spinner_state_user);
        final Spinner dist_spinner=(Spinner)findViewById(R.id.id_spinner_dist_user);
        adapter_state=new ArrayAdapter(this,android.R.layout.simple_spinner_item,state);
        adapter_state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state_spinner.setAdapter(adapter_state);
        adapter_dist=new ArrayAdapter(this,android.R.layout.simple_spinner_item,district);
        adapter_dist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dist_spinner.setAdapter(adapter_dist);
        RequestQueue requestQueue= Volley.newRequestQueue(UserViewDoctorsActivity.this);
        String Url="http://smartq.fabstudioz.com/user_get_city.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("response uvd",response);
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for (int i=0;i<=jsonArray.length();i++)
                    {
                        JSONObject jsonObject=(JSONObject)jsonArray.get(i);
                        String city_id=jsonObject.optString("id");
                        String city=jsonObject.optString("city");
                        cities.add(city);
                        cityid.add(city_id);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter_city=new ArrayAdapter(UserViewDoctorsActivity.this,android.R.layout.simple_spinner_dropdown_item,cities);
                city_spinner.setAdapter(adapter_city);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final String state=state_spinner.getSelectedItem().toString().trim();
            final String district=dist_spinner.getSelectedItem().toString().trim();
            final String city=city_spinner.getSelectedItem().toString().trim();
            RequestQueue requestQueue1=Volley.newRequestQueue(UserViewDoctorsActivity.this);
            String Url="http://smartq.fabstudioz.com/user_search_doctor.php";
            StringRequest stringRequest1=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Intent intent=new Intent(getApplicationContext(),UserDoctorListActivity.class);
                    intent.putExtra("response",response);
                    startActivity(intent);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params=new HashMap<>();
                    params.put("state",state);
                    params.put("district",district);
                    params.put("city",city);
                    return params;
                }
            };
            requestQueue1.add(stringRequest1);

            }
        });
    }
}
