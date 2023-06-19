FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine as runner
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar .
EXPOSE 8090
CMD ["java", "-jar", "/app/app.jar"]