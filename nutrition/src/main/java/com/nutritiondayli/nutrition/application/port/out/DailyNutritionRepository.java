package com.nutritiondayli.nutrition.application.port.out;

import com.nutritiondayli.nutrition.domain.model.DailyNutrition;

import java.time.LocalDate;
import java.util.Optional;

public interface DailyNutritionRepository {

    Optional<DailyNutrition> findByUserIdAndDate(
            Long userId,
            LocalDate date
    );

    DailyNutrition save(DailyNutrition dailyNutrition);
}