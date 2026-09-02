package com.kvales.nutrition.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface SpringDataDailyNutritionRepository
        extends JpaRepository<DailyNutritionJpaEntity, Long> {

    Optional<DailyNutritionJpaEntity> findByUserIdAndDate(
            Long userId,
            LocalDate date
    );
}
