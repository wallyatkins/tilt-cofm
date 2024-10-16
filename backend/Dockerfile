# Backend Dockerfile
FROM maven:3.8.4-openjdk-11-slim AS build

WORKDIR /app

# Copy pom.xml separately
# This allows Docker to cache the maven dependency download step
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the code
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:11-jre-slim

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
