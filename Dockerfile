# Etapa 1: compilar la aplicación Java
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -B clean package

# Etapa 2: ejecutar la aplicación
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/moda-urbana-1.0.0.jar app.jar

CMD ["java", "-jar", "app.jar"]
