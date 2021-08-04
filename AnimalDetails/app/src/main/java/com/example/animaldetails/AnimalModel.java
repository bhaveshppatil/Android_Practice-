package com.example.animaldetails;

import androidx.recyclerview.widget.RecyclerView;

public class AnimalModel {
    private String tvName;
    private String tvSound;
    private int imgID;

    public AnimalModel(String tvName, String tvSound, int imgID) {
        this.tvName = tvName;
        this.tvSound = tvSound;
        this.imgID = imgID;
    }

    public String getTvName() {
        return tvName;
    }

    public String getTvSound() {
        return tvSound;
    }

    public int getImgID() {
        return imgID;
    }
}
