package com.example.fragmentcommunicationwe;

import java.io.Serializable;

public class StudentModel implements Serializable {
    private String name;
    private int age;
    private String percentage;
    private String grade;

    public StudentModel(String name, int age, String percentage, String grade) {
        this.name = name;
        this.age = age;
        this.percentage = percentage;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPercentage() {
        return percentage;
    }

    public String getGrade() {
        return grade;
    }
}
