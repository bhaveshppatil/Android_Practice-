package com.example.recyclerview_we;

public class Student {
    private String name;
    private String rollNo;
    private int age;

    public Student(String name, String rollNo, int age) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public int getAge() {
        return age;
    }
}
