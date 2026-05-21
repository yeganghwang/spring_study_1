# Build
FROM eclipse-temurin:23-jdk-alpine AS builder
LABEL authors="ghkdt"

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

RUN chmod +x gradlew

COPY src src
RUN ./gradlew clean build

# Run
FROM eclipse-temurin:23-jdk-alpine AS runner
WORKDIR /app
COPY --from=builder /app/build/libs/spring-2.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]