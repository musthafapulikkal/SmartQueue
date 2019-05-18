package com.example.smartqueue.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartqueue.Others.Doctors;
import com.example.smartqueue.Others.Notification;
import com.example.smartqueue.R;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyviewHolder> {
    private List<Notification> notificationList;
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notification_list,viewGroup,false);
        return new MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder myviewHolder, int i) {
      final com.example.smartqueue.Others.Notification notification=notificationList.get(i);
      myviewHolder.text.setText(notification.getNotification());
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.txt_notification);
        }
    }
    public NotificationAdapter(List<Notification> notificationList){this.notificationList=notificationList;}
}
