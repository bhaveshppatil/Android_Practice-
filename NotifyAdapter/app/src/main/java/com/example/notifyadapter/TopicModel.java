package com.example.notifyadapter;

public class TopicModel {
    private String tvCategory;
    private boolean isItemSelected;

    public TopicModel(String tvCategory, boolean isItemSelected) {
        this.tvCategory = tvCategory;
        this.isItemSelected = isItemSelected;
    }

    public String getTvCategory() {
        return tvCategory;
    }

    public boolean isItemSelected() {
        return isItemSelected;
    }
}
