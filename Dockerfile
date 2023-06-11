# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests

# Stage 2: Create the final container
FROM eclipse-temurin:17-jdk-alpine as runner
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/distributed_systems_todo-app-0.0.1-SNAPSHOT.jar .
EXPOSE 8080

# Set the entrypoint
ENTRYPOINT ["java", "-jar", "distributed_systems_todo-app-0.0.1-SNAPSHOT.jar"]
