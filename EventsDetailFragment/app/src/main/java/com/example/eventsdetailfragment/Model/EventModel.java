package com.example.eventsdetailfragment.Model;

import java.io.Serializable;

public class EventModel implements Serializable {

    private String title, description, startDate, endDate, startTime, endTime, price;

    public EventModel(String title, String description, String startDate,
                      String endDate, String startTime, String endTime, String price) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPrice() {
        return price;
    }
}
