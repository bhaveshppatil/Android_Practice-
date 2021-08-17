package com.example.youtubelistapp;

public class YoutubeModel {

    private int resID;
    private String title;
    private String uri;

    public YoutubeModel(int resID, String title, String uri) {
        this.resID = resID;
        this.title = title;
        this.uri = uri;
    }

    public int getResID() {
        return resID;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }
}
