package com.cc.ander.lapampa;

import android.media.Image;

public class Restaurante {

    private String id;
    private String info;
    private int image;

    public Restaurante(){

    }

    public Restaurante(String id, String info, int image) {
        this.id = id;
        this.info = info;
        this.image = image;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
