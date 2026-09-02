package com.kvales.nutrition.adapter.out.persistence;

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
            Long id,
            Long userId,
            LocalDate date,
            int calorieGoal,
            int caloriesConsumed
    ) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.calorieGoal = calorieGoal;
        this.caloriesConsumed = caloriesConsumed;
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

    public void setCaloriesConsumed(int caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }
}
