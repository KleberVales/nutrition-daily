package com.nutritiondayli.nutrition.domain.model;

import java.time.LocalDate;

public class DailyNutrition {

    private final Long userId;
    private final LocalDate date;
    private final int calorieGoal;
    private int caloriesConsumed;

    public DailyNutrition(
            Long userId,
            LocalDate date,
            int calorieGoal,
            int caloriesConsumed
    ) {
        if (userId == null) {
            throw new IllegalArgumentException("User id cannot be null");
        }

        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        if (calorieGoal <= 0) {
            throw new IllegalArgumentException("Calorie goal must be greater than zero");
        }

        if (caloriesConsumed < 0) {
            throw new IllegalArgumentException("Calories consumed cannot be negative");
        }

        this.userId = userId;
        this.date = date;
        this.calorieGoal = calorieGoal;
        this.caloriesConsumed = caloriesConsumed;
    }

    public void addCalories(int calories) {
        if (calories <= 0) {
            throw new IllegalArgumentException("Calories must be greater than zero");
        }

        this.caloriesConsumed += calories;
    }

    public int getRemainingCalories() {
        return Math.max(calorieGoal - caloriesConsumed, 0);
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }

    public int getCaloriesConsumed() {
        return caloriesConsumed;
    }
}