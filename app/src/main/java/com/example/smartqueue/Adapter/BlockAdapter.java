package com.example.smartqueue.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.smartqueue.Others.Doctors;
import com.example.smartqueue.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockAdapter extends RecyclerView.Adapter<BlockAdapter.MyViewHolder> {
    private Context context;
    private List<Doctors> doctorsList;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.block_list,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Doctors doctors=doctorsList.get(i);
        myViewHolder.name.setText(doctors.getName());
        String Url="http://smartq.fabstudioz.com/"+doctors.getImage();
        Glide.with(doctors.getContext()).load(Url).into(myViewHolder.image);

    }

    @Override
    public int getItemCount() {
        return doctorsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView place;
        Button block;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.imageview_activehos);
            name=(TextView)itemView.findViewById(R.id.txt_activehos_name);
//            place=(TextView)itemView.findViewById(R.id.txt_activehos_place);
            block=(Button)itemView.findViewById(R.id.btn_block);
            block.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    blockHospital(getAdapterPosition());
                }
            });
        }

        private void blockHospital(int adapterPosition) {
            if (doctorsList.size()==0)
            {

            }
            else
            {
                final Doctors doctors=doctorsList.get(adapterPosition);
                Toast.makeText(doctors.getContext(), "Blocked", Toast.LENGTH_SHORT).show();
                doctorsList.remove(adapterPosition);
                notifyItemRemoved(adapterPosition);
                notifyItemRangeChanged(adapterPosition,doctorsList.size());
                RequestQueue requestQueue= Volley.newRequestQueue(doctors.getContext());
                String Url="http://smartq.fabstudioz.com/block.php";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("block res",response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params=new HashMap<>();
                        params.put("id",doctors.getId());
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
        }
    }
    public BlockAdapter(List<Doctors> doctorsList){this.doctorsList=doctorsList;}
    public BlockAdapter(Context context){
        this.context=context;
    }
}
