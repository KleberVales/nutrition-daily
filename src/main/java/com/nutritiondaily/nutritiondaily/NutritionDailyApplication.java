package com.nutritiondaily.nutritiondaily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The NutritionDailyApplication class serves as the entry point for the Spring Boot application.
 * It initializes and launches the Spring application context.
 *
 * This class makes use of the {@code @SpringBootApplication} annotation, which signifies
 * a combination of the {@code @Configuration}, {@code @EnableAutoConfiguration}, and
 * {@code @ComponentScan} annotations in Spring Framework.
 *
 * The {@code main} method uses the {@code SpringApplication.run()} method
 * to start the application.
 */
@SpringBootApplication
public class NutritionDailyApplication {

    public static void main(String[] args) {
        SpringApplication.run(NutritionDailyApplication.class, args);
    }

}
