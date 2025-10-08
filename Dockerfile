# Use OpenJDK 17 slim image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first
COPY mvnw .
COPY pom.xml .

# Copy the source code
COPY src ./src

# Package the application
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Copy the built jar
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
