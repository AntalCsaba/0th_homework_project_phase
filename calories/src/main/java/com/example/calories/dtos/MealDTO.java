package com.example.calories.dtos;

import java.util.Date;

public class MealDTO {

    private String name;
    private String calories;

    public MealDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

}
