package com.example.smartqueue.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smartqueue.R;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class DoctorRegistration extends AppCompatActivity {
EditText edt_name,edt_email,edt_state,edt_dist,edt_place,edt_hos,edt_pass;
ImageView imageView;
Button btn_choose,btn_register;
    private static int RESULT_LOAD_IMAGE = 1;
    private Bitmap bitmap;
    private String imagepath=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_registration);
        edt_name=(EditText)findViewById(R.id.id_doc_name);
        edt_email=(EditText)findViewById(R.id.id_doc_email);
        edt_state=(EditText)findViewById(R.id.id_doc_state);
        edt_dist=(EditText)findViewById(R.id.id_doc_district);
        edt_place=(EditText)findViewById(R.id.id_doc_place);
        edt_hos=(EditText)findViewById(R.id.id_doc_hos_clinick);
        edt_pass=(EditText)findViewById(R.id.id_doc_password);
        imageView=(ImageView)findViewById(R.id.img_doc);
        btn_choose=(Button)findViewById(R.id.id_choose_doc_img);
        btn_register=(Button)findViewById(R.id.id_doc_register);
        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,RESULT_LOAD_IMAGE);
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name=edt_name.getText().toString().trim();
                final String email=edt_email.getText().toString().trim();
                final String state=edt_state.getText().toString().trim();
                final String dist=edt_dist.getText().toString().trim();
                final String place=edt_place.getText().toString().trim();
                final String hos=edt_hos.getText().toString().trim();
                final String pass=edt_pass.getText().toString().trim();
                Bitmap bitmap=((BitmapDrawable)imageView.getDrawable()).getBitmap();
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);
                final byte[] imageInByte=baos.toByteArray();
                final String image= Base64.encodeToString(imageInByte,Base64.DEFAULT);
                RequestQueue requestQueue= Volley.newRequestQueue(DoctorRegistration.this);
                String Url="http://smartq.fabstudioz.com/doc_registration.php";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("responsereg",response);
                        if (response.equals("success"))
                        {
                            startActivity(new Intent(getApplicationContext(),DoctorLoginActivity.class));
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
                        params.put("name",name);
                        params.put("email",email);
                        params.put("state",state);
                        params.put("district",dist);
                        params.put("place",place);
                        params.put("hos",hos);
                        params.put("pass",pass);
                        params.put("image",image);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RESULT_LOAD_IMAGE&&resultCode==RESULT_OK&&null != data){
            Uri selectedImage=data.getData();
            String[] filepathColumn={MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,
                    filepathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex=cursor.getColumnIndex(filepathColumn[0]);
            String picturePath=cursor.getString(columnIndex);
            cursor.close();
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));


        }
    }
}
