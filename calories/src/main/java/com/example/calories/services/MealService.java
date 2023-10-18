package com.example.calories.services;

import com.example.calories.models.Meal;
import com.example.calories.repositories.MealRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void addMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public List<Meal> getMeals() {
        return mealRepository.findAll();
    }

    public Optional<Meal> findById(Long id) {
        return mealRepository.findById(id);
    }

    public void update(Meal meal) {
        mealRepository.save(meal);
    }

    public void delete(Meal meal) {
        mealRepository.delete(meal);
    }

    public Integer getCaloriesPerDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date startOfDay = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        Date endOfDay = calendar.getTime();

        List<Meal> meals = mealRepository.findByDateBetween(startOfDay, endOfDay);
        int totalCalories = 0;
        for (Meal meal : meals) {
            totalCalories += meal.getCalories();
        }
        return totalCalories;
    }

}
