# Estágio de build
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copiar apenas o necessário para baixar dependências primeiro (cache)
COPY gradle/ gradle/
COPY gradlew .
COPY build.gradle settings.gradle ./
COPY auth/build.gradle auth/
COPY app/build.gradle app/
COPY user/build.gradle user/

# Dar permissão e baixar dependências (sem build)
RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

# Copiar o código fonte
COPY . .

# Build da aplicação
RUN ./gradlew :app:bootJar --no-daemon

# Estágio de runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar o JAR do estágio de build
COPY --from=build /app/app/build/libs/*.jar app.jar

# Expor a porta da aplicação
EXPOSE 8080

# Configurar variáveis de ambiente para JWT (opcional)
ENV JWT_SECRET=your-very-long-secret-key-that-is-at-least-32-characters
ENV JWT_EXPIRATION=86400000

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]