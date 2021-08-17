package com.example.articlescrollingwithrecyclerview;

public class Article {
    private int imageArticle;
    private String tvHeading;
    private String tvContent;

    public Article(int imageArticle, String tvHeading, String tvContent) {
        this.imageArticle = imageArticle;
        this.tvHeading = tvHeading;
        this.tvContent = tvContent;
    }

    public int getImageArticle() {
        return imageArticle;
    }

    public String getTvHeading() {
        return tvHeading;
    }

    public String getTvContent() {
        return tvContent;
    }
}
