# backend/Dockerfile
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Byg projektet og spring tests over for hurtighed
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# Kopier din json fil med ind, så den eksisterer
COPY users.json .
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
