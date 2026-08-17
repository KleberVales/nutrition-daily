package com.nutritiondayli.nutrition.adapter.out.persistence;

import com.nutritiondayli.nutrition.application.port.out.DailyNutritionRepository;
import com.nutritiondayli.nutrition.domain.model.DailyNutrition;
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

        return repository
                .findByUserIdAndDate(userId, date)
                .map(DailyNutritionJpaEntity::toDomain);
    }

    @Override
    public DailyNutrition save(
            DailyNutrition dailyNutrition
    ) {

        DailyNutritionJpaEntity entity =
                DailyNutritionJpaEntity.fromDomain(dailyNutrition);

        DailyNutritionJpaEntity saved =
                repository.save(entity);

        return saved.toDomain();
    }
}