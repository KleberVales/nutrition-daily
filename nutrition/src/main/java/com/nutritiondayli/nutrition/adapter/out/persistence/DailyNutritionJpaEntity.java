package com.nutritiondayli.nutrition.adapter.out.persistence;

import com.nutritiondayli.nutrition.domain.model.DailyNutrition;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "daily_nutrition",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_daily_nutrition_user_date",
                        columnNames = {"user_id", "date"}
                )
        }
)
public class DailyNutritionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "calorie_goal", nullable = false)
    private int calorieGoal;

    @Column(name = "calories_consumed", nullable = false)
    private int caloriesConsumed;

    protected DailyNutritionJpaEntity() {
    }

    public DailyNutritionJpaEntity(
            Long userId,
            LocalDate date,
            int calorieGoal,
            int caloriesConsumed
    ) {
        this.userId = userId;
        this.date = date;
        this.calorieGoal = calorieGoal;
        this.caloriesConsumed = caloriesConsumed;
    }

    public static DailyNutritionJpaEntity fromDomain(
            DailyNutrition dailyNutrition
    ) {
        return new DailyNutritionJpaEntity(
                dailyNutrition.getUserId(),
                dailyNutrition.getDate(),
                dailyNutrition.getCalorieGoal(),
                dailyNutrition.getCaloriesConsumed()
        );
    }

    public DailyNutrition toDomain() {
        return new DailyNutrition(
                userId,
                date,
                calorieGoal,
                caloriesConsumed
        );
    }

    public Long getId() {
        return id;
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