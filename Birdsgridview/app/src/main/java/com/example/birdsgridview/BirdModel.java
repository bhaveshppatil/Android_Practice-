package com.example.birdsgridview;

public class BirdModel {
    private int imgID;
    private String birdName;

    public BirdModel(int imgID, String  birdName) {
        this.imgID = imgID;
        this.birdName = birdName;
    }

    public int getImgID() {
        return imgID;
    }

    public String  getBirdName() {
        return birdName;
    }
}
