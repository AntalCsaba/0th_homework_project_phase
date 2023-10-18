package com.example.calories.controllers;

import com.example.calories.dtos.DateRequest;
import com.example.calories.dtos.MealDTO;
import com.example.calories.exceptions.AddNotSuccessfullException;
import com.example.calories.exceptions.MealNotFoundException;
import com.example.calories.models.Meal;
import com.example.calories.services.MealService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/meals")
    public List<Meal> getMeals() {
        return mealService.getMeals();
    }

    @PutMapping("/update/{id}")
    public void updateMeal(@PathVariable Long id, @RequestBody MealDTO mealDTO){
        Optional<Meal> meal= mealService.findById(id);
        if (meal.isEmpty()){
            throw new MealNotFoundException("Wrong id!");
        }
        meal.get().setCalories(Double.parseDouble(mealDTO.getCalories()));
        meal.get().setName(mealDTO.getName());
        meal.get().setDate(new Date());
        mealService.update(meal.get());

    }

    @DeleteMapping("/delete/{id}")
    public void deleteMeal(@PathVariable Long id){
        Optional<Meal> meal= mealService.findById(id);
        if (meal.isEmpty()){
            throw new MealNotFoundException("Wrong id!");
        }
        mealService.delete(meal.get());
    }

    @GetMapping("/meal/{id}")
    public Meal getMeal(@PathVariable Long id){
        Optional<Meal> meal= mealService.findById(id);
        if (meal.isEmpty()){
            throw new MealNotFoundException("Wrong id!");
        }
        return meal.get();
    }

    @GetMapping("/calories")
    public Integer getCaloriesPerDay(@RequestBody DateRequest dateRequest){
        return mealService.getCaloriesPerDay(dateRequest.getDate());
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
