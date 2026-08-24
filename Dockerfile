FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew :app:bootJar --no-daemon

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app/build/libs/app-0.0.1-SNAPSHOT.jar"]