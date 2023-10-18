package com.example.calories.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double calories;
    private Date date;

    public Meal() {
    }

    public Meal(String name, Double calories, Date date) {
        this.name = name;
        this.calories = calories;
        this.date = date;
    }
}
