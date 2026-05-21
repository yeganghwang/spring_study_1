FROM eclipse-temurin:23-jdk-alpine
LABEL authors="ghkdt"

WORKDIR /app
COPY . .
CMD ["./gradlew", "clean", "build"]
CMD ["java", "-jar", "./build/libs/spring-2.jar"]
EXPOSE 8080