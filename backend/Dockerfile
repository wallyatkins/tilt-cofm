# Backend Dockerfile
FROM maven:3.8.4-openjdk-11-slim AS build

WORKDIR /app

# Copy Maven settings first
COPY settings.xml /root/.m2/settings.xml

# Copy pom.xml separately
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copy the rest of the code
COPY src ./src

RUN mvn -B clean package -DskipTests

FROM openjdk:11-jre-slim

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
