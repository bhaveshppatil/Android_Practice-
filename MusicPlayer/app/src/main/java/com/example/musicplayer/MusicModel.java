package com.example.musicplayer;

public class MusicModel {

    private String tvSongName;
    private String tvDuration;
    private int resID;
    private int imgID;

    public MusicModel(String tvSongName, String  tvDuration, int resID, int imgID) {
        this.tvSongName = tvSongName;
        this.tvDuration = tvDuration;
        this.resID = resID;
        this.imgID = imgID;
    }

    public String getTvSongName() {
        return tvSongName;
    }

    public String getTvDuration() {
        return tvDuration;
    }

    public int getResID() {
        return resID;
    }

    public int getImgID() {
        return imgID;
    }
}
