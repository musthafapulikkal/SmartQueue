package com.example.smartqueue.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.smartqueue.Others.Doctors;
import com.example.smartqueue.R;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.MyviewHolder> {
    private Context context;
    private List<Doctors> doctorsList;
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.doctors_list,viewGroup,false);
        return new MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder myviewHolder, int i) {
     final Doctors doctors=doctorsList.get(i);
     myviewHolder.txt_name.setText(doctors.getName());
     myviewHolder.txt_clinick.setText(doctors.getClinick());
     String Url="http://smartq.fabstudioz.com/"+doctors.getImage();
     Glide.with(doctors.getContext()).load(Url).apply(new RequestOptions().circleCropTransform()).into(myviewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return doctorsList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txt_name,txt_clinick;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.img_doctor);
            txt_name=(TextView)itemView.findViewById(R.id.doctor_name);
            txt_clinick=(TextView)itemView.findViewById(R.id.doctor_clinick);
        }
    }
    public DoctorAdapter(List<Doctors> doctorsList){this.doctorsList=doctorsList;}
    public DoctorAdapter(Context context){
        this.context=context;
    }
}
