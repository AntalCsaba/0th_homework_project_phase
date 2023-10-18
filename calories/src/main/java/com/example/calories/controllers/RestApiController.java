package com.example.calories.controllers;

import com.example.calories.dtos.MealDTO;
import com.example.calories.errors.AddNotSuccessfullException;
import com.example.calories.errors.ErrorResponse;
import com.example.calories.models.Meal;
import com.example.calories.services.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class RestApiController {

    private final MealService mealService;

    public RestApiController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/add")
    public void addMeal(@RequestBody MealDTO mealDTO) {

        AddNotSuccessfullException addNotSuccessfullException = verifyInput(mealDTO);
        if (addNotSuccessfullException != null) {
            throw addNotSuccessfullException;
        }

        mealService.addMeal(new Meal(mealDTO.getName(), Double.parseDouble(mealDTO.getCalories()), new Date()));

    }

    public AddNotSuccessfullException verifyInput(MealDTO mealDTO) {
        if (mealDTO.getCalories() == null) {
            return new AddNotSuccessfullException("No value for calories found!");
        }
        if (mealDTO.getName() == null) {
            return new AddNotSuccessfullException("No name provided!");
        }
        try {
            double calorie = Double.parseDouble(mealDTO.getCalories());
        } catch (NumberFormatException e) {
            return new AddNotSuccessfullException("Calorie must be a number!");
        }
        return null;
    }

}
