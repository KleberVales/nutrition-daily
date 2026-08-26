package com.nutritiondayli.nutrition.adapter.out.persistence;

import com.nutritiondayli.nutrition.application.port.out.DailyNutritionRepository;
import com.nutritiondayli.nutrition.domain.DailyNutrition;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class DailyNutritionPersistenceAdapter
        implements DailyNutritionRepository {

    private final SpringDataDailyNutritionRepository repository;

    public DailyNutritionPersistenceAdapter(
            SpringDataDailyNutritionRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public Optional<DailyNutrition> findByUserIdAndDate(
            Long userId,
            LocalDate date
    ) {

        return repository.findByUserIdAndDate(userId, date)
                .map(this::toDomain);
    }

    @Override
    public DailyNutrition save(
            DailyNutrition nutrition,
            LocalDate date
    ) {

        DailyNutritionJpaEntity entity =
                new DailyNutritionJpaEntity(
                        nutrition.getId(),
                        nutrition.getUserId(),
                        date,
                        nutrition.getCalorieGoal(),
                        nutrition.getCaloriesConsumed()
                );

        DailyNutritionJpaEntity saved =
                repository.save(entity);

        return toDomain(saved);
    }

    private DailyNutrition toDomain(
            DailyNutritionJpaEntity entity
    ) {

        return new DailyNutrition(
                entity.getId(),
                entity.getUserId(),
                entity.getCalorieGoal(),
                entity.getCaloriesConsumed()
        );
    }
}