# ---- Build stage ----
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom and src
COPY pom.xml .
COPY src ./src

# Build jar (skip tests if you want faster pipeline)
RUN mvn clean package -DskipTests

# ---- Run stage ----
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/CRUDProject-0.0.1-SNAPSHOT.jar app.jar

# Expose app port
EXPOSE 8080

# Spring Boot entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]
