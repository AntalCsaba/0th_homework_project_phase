package com.example.calories.repositories;

import com.example.calories.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    @NonNull Optional<Meal> findById(@NonNull Long id);

}
