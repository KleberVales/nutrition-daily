package com.nutritiondayli.nutrition.application.service;

import com.nutritiondayli.nutrition.application.port.in.RegisterMealUseCase;
import com.nutritiondayli.nutrition.application.port.out.DailyNutritionRepository;
import com.nutritiondayli.nutrition.domain.model.DailyNutrition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class RegisterMealService implements RegisterMealUseCase {

    private final DailyNutritionRepository dailyNutritionRepository;

    public RegisterMealService(
            DailyNutritionRepository dailyNutritionRepository
    ) {
        this.dailyNutritionRepository = dailyNutritionRepository;
    }

    @Override
    public RegisterMealResult registerMeal(RegisterMealCommand command) {

        LocalDate today = LocalDate.now();

        DailyNutrition dailyNutrition =
                dailyNutritionRepository
                        .findByUserIdAndDate(command.userId(), today)
                        .orElseThrow(() ->
                                new IllegalStateException(
                                        "Daily nutrition not found"
                                )
                        );

        dailyNutrition.addCalories(command.calories());

        DailyNutrition saved =
                dailyNutritionRepository.save(dailyNutrition);

        return new RegisterMealResult(
                saved.getUserId(),
                saved.getCalorieGoal(),
                saved.getCaloriesConsumed(),
                saved.getRemainingCalories()
        );
    }
}