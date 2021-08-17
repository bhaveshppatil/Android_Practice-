package com.example.recyclerview3_we;

public class Model {

    private String name;
    private int age;
    private String address;

    public Model(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
