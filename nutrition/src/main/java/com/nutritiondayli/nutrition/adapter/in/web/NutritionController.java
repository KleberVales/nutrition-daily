package com.nutritiondayli.nutrition.adapter.in.web;

import com.nutritiondayli.nutrition.application.port.in.RegisterMealUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nutrition")
public class NutritionController {

    private final RegisterMealUseCase registerMealUseCase;

    public NutritionController(
            RegisterMealUseCase registerMealUseCase
    ) {
        this.registerMealUseCase = registerMealUseCase;
    }

    @PostMapping("/meals")
    public ResponseEntity<RegisterMealUseCase.RegisterMealResult> registerMeal(
            @RequestBody RegisterMealRequest request
    ) {

        RegisterMealUseCase.RegisterMealCommand command =
                new RegisterMealUseCase.RegisterMealCommand(
                        request.userId(),
                        request.calories()
                );

        RegisterMealUseCase.RegisterMealResult result =
                registerMealUseCase.registerMeal(command);

        return ResponseEntity.ok(result);
    }

    public record RegisterMealRequest(
            Long userId,
            int calories
    ) {
    }
}