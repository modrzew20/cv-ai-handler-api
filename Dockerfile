# Use OpenJDK 24 as base image
FROM openjdk:24-jdk-slim

# Set working directory
WORKDIR /app

# Copy the Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable
RUN chmod +x mvnw

# Download dependencies (this layer will be cached if pom.xml doesn't change)
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Create a new stage for the runtime
FROM openjdk:24-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=0 /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Set the startup command
ENTRYPOINT ["java", "-jar", "app.jar"] 