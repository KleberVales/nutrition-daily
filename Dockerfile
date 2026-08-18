FROM eclipse-temurin:21-jre

WORKDIR /app

COPY build/libs/nutrition-daily.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]