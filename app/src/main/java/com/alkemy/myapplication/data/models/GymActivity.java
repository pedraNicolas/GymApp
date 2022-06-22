package com.alkemy.myapplication.data.models;

import com.google.firebase.firestore.PropertyName;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class GymActivity {
    private String name;
    @PropertyName("days")
    private List<String> days;

    public GymActivity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @PropertyName("days")
    public List<String> getDays() {
        return days;
    }
    @PropertyName("days")
    public void setDays(List<String> days) {
        this.days = days;
    }
}
