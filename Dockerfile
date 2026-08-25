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