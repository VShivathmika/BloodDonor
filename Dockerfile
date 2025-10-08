# Use OpenJDK 17 slim image
FROM openjdk:17-slim

# Install Maven inside Docker
RUN apt-get update && apt-get install -y maven

# Set working directory
WORKDIR /app

# Copy pom.xml first (for caching)
COPY pom.xml .

# Copy source code
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Copy the built jar
COPY target/*.jar app.jar

# Expose the port (Render assigns dynamic PORT)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
