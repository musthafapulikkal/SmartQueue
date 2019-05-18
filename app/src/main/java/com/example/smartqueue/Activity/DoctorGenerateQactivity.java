package com.example.smartqueue.Activity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
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

import static com.example.smartqueue.Activity.DoctorLoginActivity.MyPREFERENCES;
import static com.example.smartqueue.Activity.DoctorLoginActivity.doc_email;

public class DoctorGenerateQactivity extends AppCompatActivity {
 Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
 Button btn_finish;
    ArrayList<String> seatlist;
    ArrayList<String> booked_list;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_generate_qactivity);
        seatlist=new ArrayList<String>();
        booked_list=new ArrayList<String>();
        b1=(Button)findViewById(R.id.seat1);
        b2=(Button)findViewById(R.id.seat2);
        b3=(Button)findViewById(R.id.seat3);
        b4=(Button)findViewById(R.id.seat4);
        b5=(Button)findViewById(R.id.seat5);
        b6=(Button)findViewById(R.id.seat6);
        b7=(Button)findViewById(R.id.seat7);
        b8=(Button)findViewById(R.id.seat8);
        b9=(Button)findViewById(R.id.seat9);
        b10=(Button)findViewById(R.id.seat10);
        b11=(Button)findViewById(R.id.seat11);
        b12=(Button)findViewById(R.id.seat12);
        b13=(Button)findViewById(R.id.seat13);
        b14=(Button)findViewById(R.id.seat14);
        b15=(Button)findViewById(R.id.seat15);
        b16=(Button)findViewById(R.id.seat16);
        b17=(Button)findViewById(R.id.seat17);
        b18=(Button)findViewById(R.id.seat18);
        b19=(Button)findViewById(R.id.seat19);
        b20=(Button)findViewById(R.id.seat20);

        btn_finish=(Button)findViewById(R.id.finish);
        //btn_a1.setBackgroundColor(getResources().getColor(R.color.red));
        final RequestQueue requestQueue= Volley.newRequestQueue(DoctorGenerateQactivity.this);
        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        final String d_email=prefs.getString(doc_email,null);
        String Url="http://smartq.fabstudioz.com/doc_generate_q.php";
        String Url2="http://smartq.fabstudioz.com/doc_qstatus.php";
        final String Url3="http://smartq.fabstudioz.com/doc_update_qstatus.php";
        final String Url4="http://smartq.fabstudioz.com/view_bookings.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("responsequeue",response);
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
                 Toast.makeText(DoctorGenerateQactivity.this, "failed", Toast.LENGTH_SHORT).show();
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
                params.put("d_email",d_email);
                return params;
            }
        };
        requestQueue.add(stringRequest);

        StringRequest str=new StringRequest(Request.Method.POST, Url4, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for (int i=0;i<=jsonArray.length();i++)
                    {
                        JSONObject jsonObject=(JSONObject)jsonArray.get(i);
                        String bookes_s=jsonObject.optString("bseat");
                        booked_list.add(bookes_s);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (booked_list.contains("1"))
                {
                    b1.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("2"))
                {
                    b2.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("3"))
                {
                    b3.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("4"))
                {
                    b4.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("5"))
                {
                    b5.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("6"))
                {
                    b6.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("7"))
                {
                    b7.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("8"))
                {
                    b8.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("9"))
                {
                    b9.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("10"))
                {
                    b10.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("11"))
                {
                    b11.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("12"))
                {
                    b12.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("13"))
                {
                    b13.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("14"))
                {
                    b14.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("15"))
                {
                    b15.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("16"))
                {
                    b16.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("17"))
                {
                    b17.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("18"))
                {
                    b18.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("19"))
                {
                    b19.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                if (booked_list.contains("20"))
                {
                    b20.setBackgroundColor(getResources().getColor(R.color.orange));
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
                params.put("demail",d_email);
                return params;
            }
        };
        requestQueue.add(str);



        StringRequest stringRequest1=new StringRequest(Request.Method.POST, Url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("qstatus",response);

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
              else
              {
                  b1.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {

                        StringRequest stringRequest2=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.v("qst",response);
                                String i="token1";
                                addNotification(i);
                                finish();
                                startActivity(getIntent());

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String,String> params=new HashMap<>();
                                params.put("qseatno","1");
                                params.put("doc_email",d_email);
                                return params;
                            }
                        };
                        requestQueue.add(stringRequest2);
                      }
                  });
              }

                if (seatlist.contains("2"))
                {
                    b2.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest3=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token2";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","2");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest3);
                        }
                    });
                }

                if (seatlist.contains("3"))
                {
                    b3.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                   b3.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           StringRequest stringRequest4=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                               @Override
                               public void onResponse(String response) {
                                   Log.v("qst",response);
                                   String i="token3";
                                   addNotification(i);
                                   finish();
                                   startActivity(getIntent());
                               }
                           }, new Response.ErrorListener() {
                               @Override
                               public void onErrorResponse(VolleyError error) {

                               }
                           }){
                               @Override
                               protected Map<String, String> getParams() throws AuthFailureError {
                                   Map<String,String> params=new HashMap<>();
                                   params.put("qseatno","3");
                                   params.put("doc_email",d_email);
                                   return params;
                               }
                           };
                           requestQueue.add(stringRequest4);
                       }
                   });
                }
                if (seatlist.contains("4"))
                {
                    b4.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token4";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","4");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }

                if (seatlist.contains("5"))
                {
                    b5.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token5";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","5");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("6"))
                {
                    b6.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token6";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","6");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("7"))
                {
                    b7.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token7";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","7");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("8"))
                {
                    b8.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token8";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","8");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("9"))
                {
                    b9.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token9";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","9");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("10"))
                {
                    b10.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b10.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token10";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","10");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("11"))
                {
                    b11.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b11.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token11";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","11");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("12"))
                {
                    b12.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b12.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token12";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","12");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("13"))
                {
                    b13.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b13.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token13";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","13");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("14"))
                {
                    b14.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b14.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token14";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","14");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("15"))
                {
                    b15.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b15.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token15";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","15");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("16"))
                {
                    b16.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b16.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token16";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","16");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("17"))
                {
                    b17.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b17.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token17";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","17");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("18"))
                {
                    b18.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b18.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token18";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","18");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("19"))
                {
                    b19.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b19.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token19";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","19");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
                }
                if (seatlist.contains("20"))
                {
                    b20.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    b20.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StringRequest stringRequest5=new StringRequest(Request.Method.POST, Url3, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("qst",response);
                                    String i="token20";
                                    addNotification(i);
                                    finish();
                                    startActivity(getIntent());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<>();
                                    params.put("qseatno","20");
                                    params.put("doc_email",d_email);
                                    return params;
                                }
                            };
                            requestQueue.add(stringRequest5);
                        }
                    });
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
                params.put("demail",d_email);
                return params;
            }
        };
        requestQueue.add(stringRequest1);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue re=Volley.newRequestQueue(DoctorGenerateQactivity.this);
                String Url="http://smartq.fabstudioz.com/finishq.php";
                StringRequest sr=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("success"))
                        {
                            Toast.makeText(DoctorGenerateQactivity.this, "finished", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),DoctorHomeActivity.class));
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
                        params.put("demail",d_email);
                        return params;
                    }
                };
                re.add(sr);
            }
        });

    }
    private void addNotification(String i) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this).setSmallIcon(R.drawable.sqicon).setContentTitle("Smart Queue")
                        .setContentText("please come"+i+"to the room within 5 minutes");

        Intent notificationIntent = new Intent(this, DoctorGenerateQactivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);//this intent is outside activity. flag is used bcoz the activity is called outside of the existing activity.

        builder.setContentIntent(contentIntent);//to send intent when clicked

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);//to understand which service is undergoing at the background.
        manager.notify(this.i++, builder.build());//to create as many number of pending notifications.

    }

}
