package com.example.calories.services;

import com.example.calories.models.Meal;
import com.example.calories.repositories.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void addMeal(Meal meal){
        mealRepository.save(meal);
    }

    public List<Meal> getMeals(){
        return mealRepository.findAll();
    }

}
