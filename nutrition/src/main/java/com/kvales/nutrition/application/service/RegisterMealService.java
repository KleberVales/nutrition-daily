package com.kvales.nutrition.application.service;

import com.kvales.nutrition.application.port.in.RegisterMealUseCase;
import com.kvales.nutrition.application.port.out.DailyNutritionRepository;
import com.kvales.nutrition.domain.DailyNutrition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class RegisterMealService implements RegisterMealUseCase {

    private final DailyNutritionRepository repository;

    public RegisterMealService(
            DailyNutritionRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public RegisterMealResult registerMeal(
            RegisterMealCommand command
    ) {

        LocalDate today = LocalDate.now();

        DailyNutrition nutrition =
                repository.findByUserIdAndDate(
                        command.userId(),
                        today
                ).orElseThrow(
                        () -> new IllegalStateException(
                                "Daily nutrition not found"
                        )
                );

        nutrition.addCalories(command.calories());

        DailyNutrition saved =
                repository.save(nutrition, today);

        return new RegisterMealResult(
                saved.getUserId(),
                saved.getCalorieGoal(),
                saved.getCaloriesConsumed(),
                saved.getRemainingCalories()
        );
    }
}
