package com.example.fragment_1;

public class AnimalModel {
    private String tvName;
    private int resID;

    public AnimalModel(String tvName, int resID) {
        this.tvName = tvName;
        this.resID = resID;
    }

    public String getTvName() {
        return tvName;
    }

    public int getResID() {
        return resID;
    }
}

