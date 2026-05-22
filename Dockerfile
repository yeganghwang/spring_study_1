# Builder
FROM eclipse-temurin:21-alpine AS builder
WORKDIR /app
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./
RUN chmod +x ./gradlew
COPY data data
COPY src src
RUN ./gradlew clean build

# Runner
FROM eclipse-temurin:21-alpine AS runner
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]