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

# Opret et start-script, der tjekker om databasen findes
RUN echo '#!/bin/sh' > /entrypoint.sh && \
    echo 'DB_FILE=/app/backend_data/users.json' >> /entrypoint.sh && \
    echo 'if [ ! -f "$DB_FILE" ]; then' >> /entrypoint.sh && \
    echo '  echo "[]" > "$DB_FILE"' >> /entrypoint.sh && \
    echo '  echo "Oprettede ny database-fil: $DB_FILE"' >> /entrypoint.sh && \
    echo 'fi' >> /entrypoint.sh && \
    echo '# Lav et link så Java-appen tror filen ligger lokalt' >> /entrypoint.sh && \
    echo 'ln -sf "$DB_FILE" /app/users.json' >> /entrypoint.sh && \
    echo 'exec java -jar app.jar' >> /entrypoint.sh && \
    chmod +x /entrypoint.sh

EXPOSE 8080
ENTRYPOINT ["/entrypoint.sh"]
