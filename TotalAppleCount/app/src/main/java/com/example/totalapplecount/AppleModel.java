package com.example.totalapplecount;

import java.io.Serializable;

public class AppleModel implements Serializable {
    private int totalApple;

    public AppleModel(int totalApple){
        this.totalApple = totalApple;
    }

    public int getTotalApple() {
        return totalApple;
    }

    public void setTotalApple(int totalApple) {
        this.totalApple = totalApple;
    }
}
