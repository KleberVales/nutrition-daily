package com.nutritiondayli.nutrition.application.port.in;

public interface RegisterMealUseCase {

    RegisterMealResult registerMeal(RegisterMealCommand command);

    record RegisterMealCommand(
            Long userId,
            int calories
    ) {
    }

    record RegisterMealResult(
            Long userId,
            int calorieGoal,
            int caloriesConsumed,
            int remainingCalories
    ) {
    }
}