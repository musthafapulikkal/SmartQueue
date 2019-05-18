package com.example.smartqueue.Others;

import android.content.Context;

public class Doctors {
    private String id;
    private String name;
    private String clinick;
    private String image;
    private Context context;
    public Doctors()
    {

    }
    public Doctors(String id,String name,String clinick,String image,Context context)
    {
        this.id=id;
        this.name=name;
        this.clinick=clinick;
        this.image=image;
        this.context=context;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClinick() {
        return clinick;
    }

    public void setClinick(String clinick) {
        this.clinick = clinick;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
