package com.example.smartqueue.Activity;

import android.content.Intent;
import android.graphics.Color;
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

public class UserViewSeatActivity extends AppCompatActivity {
String id,name;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
    ArrayList<String> seatlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_seat);
        seatlist=new ArrayList<String>();
        b1=(Button)findViewById(R.id.useat1);
        b2=(Button)findViewById(R.id.useat2);
        b3=(Button)findViewById(R.id.useat3);
        b4=(Button)findViewById(R.id.useat4);
        b5=(Button)findViewById(R.id.useat5);
        b6=(Button)findViewById(R.id.useat6);
        b7=(Button)findViewById(R.id.useat7);
        b8=(Button)findViewById(R.id.useat8);
        b9=(Button)findViewById(R.id.useat9);
        b10=(Button)findViewById(R.id.useat10);
        b11=(Button)findViewById(R.id.useat11);
        b12=(Button)findViewById(R.id.useat12);
        b13=(Button)findViewById(R.id.useat13);
        b14=(Button)findViewById(R.id.useat14);
        b15=(Button)findViewById(R.id.useat15);
        b16=(Button)findViewById(R.id.useat16);
        b17=(Button)findViewById(R.id.useat17);
        b18=(Button)findViewById(R.id.useat18);
        b19=(Button)findViewById(R.id.useat19);
        b20=(Button)findViewById(R.id.useat20);
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
        RequestQueue requestQueue= Volley.newRequestQueue(UserViewSeatActivity.this);
        String Url="http://smartq.fabstudioz.com/user_view_seat.php";
        String Url2="http://smartq.fabstudioz.com/check_status.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("seatres",response);
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
                    Toast.makeText(UserViewSeatActivity.this, "failed", Toast.LENGTH_SHORT).show();
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
                Log.v("status",response);
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for (int i=0;i<=jsonArray.length();i++)
                    {
                        JSONObject jsonObject=(JSONObject)jsonArray.get(i);
                        String seatno=jsonObject.optString("seatno");
                        seatlist.add(seatno);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.v("array", String.valueOf(seatlist));
               if (seatlist.contains("1"))
               {
                   b1.setBackgroundColor(getResources().getColor(R.color.red));
               }
               else
               {
                   b1.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                           intent1.putExtra("docid",id);
                           intent1.putExtra("token","1");
                           startActivity(intent1);
                       }
                   });
               }
                if (seatlist.contains("2"))
                {
                    b2.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","2");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("3"))
                {
                    b3.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {
                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","3");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("4"))
                {
                    b4.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {

                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","4");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("5"))
                {
                    b5.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {
                    b5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","5");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("6"))
                {
                    b6.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {
                    b6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","6");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("7"))
                {
                    b7.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {
                    b7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","7");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("8"))
                {
                    b8.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {
                    b8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","8");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("9"))
                {
                    b9.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {
                    b9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","9");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("10"))
                {
                    b10.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {
                    b10.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","10");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("11"))
                {
                    b11.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {
                    b11.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","11");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("12"))
                {
                    b12.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {

                    b12.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","12");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("13"))
                {
                    b13.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {

                    b13.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","13");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("14"))
                {
                    b14.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {

                    b14.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","14");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("15"))
                {
                    b15.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {

                    b15.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","15");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("16"))
                {
                    b16.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {

                    b16.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","16");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("17"))
                {
                    b17.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {

                    b17.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","17");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("18"))
                {
                    b18.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {

                    b18.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","18");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("19"))
                {
                    b19.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {

                    b19.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","19");
                            startActivity(intent1);
                        }
                    });
                }
                if (seatlist.contains("20"))
                {
                    b20.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {

                    b20.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1=new Intent(getApplicationContext(),BookDetailsActivity.class);
                            intent1.putExtra("docid",id);
                            intent1.putExtra("token","20");
                            startActivity(intent1);
                        }
                    });
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest1);


    }
}
