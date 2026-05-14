# Use an optimized Java 21 runtime layer
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled jar from your local target folder into the container
COPY target/*.jar app.jar

# Instruct the container to execute your fresh jar on startup
ENTRYPOINT ["java", "-jar", "app.jar"]