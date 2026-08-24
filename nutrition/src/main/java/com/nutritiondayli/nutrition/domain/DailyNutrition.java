package com.nutritiondayli.nutrition.domain;

public class DailyNutrition {

    private Long id;
    private Long userId;
    private int calorieGoal;
    private int caloriesConsumed;

    public DailyNutrition(
            Long id,
            Long userId,
            int calorieGoal,
            int caloriesConsumed
    ) {
        this.id = id;
        this.userId = userId;
        this.calorieGoal = calorieGoal;
        this.caloriesConsumed = caloriesConsumed;
    }

    public void addCalories(int calories) {
        if (calories <= 0) {
            throw new IllegalArgumentException(
                    "Calories must be greater than zero"
            );
        }

        this.caloriesConsumed += calories;
    }

    public int getRemainingCalories() {
        return calorieGoal - caloriesConsumed;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }

    public int getCaloriesConsumed() {
        return caloriesConsumed;
    }
}