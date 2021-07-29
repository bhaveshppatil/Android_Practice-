package com.example.callerapp;

public class PersonModel {
    private String tvPName;
    private String tvPNumber;
    private int resID;


    public PersonModel(String tvPName, String tvPNumber, int resID) {
        this.tvPName = tvPName;
        this.tvPNumber = tvPNumber;
        this.resID = resID;
    }

    public String getTvPName() {
        return tvPName;
    }

    public String getTvPNumber() {
        return tvPNumber;
    }

    public int getResID() {
        return resID;
    }


}
