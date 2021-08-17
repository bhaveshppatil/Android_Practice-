package com.example.idenditycard;

public class CardModel {
    private String tvCompany;
    private String tvName;
    private int tvAge;
    private int imgID;
    private String tvProfession;

    public CardModel(String tvCompany, String tvName, int tvAge, int imgID, String tvProfession) {
        this.tvCompany = tvCompany;
        this.tvName = tvName;
        this.tvAge = tvAge;
        this.imgID = imgID;
        this.tvProfession = tvProfession;
    }

    public String getTvCompany() {
        return tvCompany;
    }

    public String getTvName() {
        return tvName;
    }

    public int getTvAge() {
        return tvAge;
    }

    public int getImgID() {
        return imgID;
    }

    public String getTvProfession() {
        return tvProfession;
    }
}
