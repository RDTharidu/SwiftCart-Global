@echo off
set content=FROM maven:3.9.6-eclipse-temurin-21 AS build^
WORKDIR /app^
COPY pom.xml .^
COPY src ./src^
RUN mvn clean package -DskipTests^
^
FROM eclipse-temurin:21-jre-alpine^
WORKDIR /app^
COPY --from=build /app/target/*.jar app.jar^
ENTRYPOINT ["java", "-jar", "app.jar"]

echo Updating Dockerfiles...
echo %content% > api-gateway\Dockerfile
echo %content% > inventory-service\Dockerfile
echo %content% > order-processing-service\Dockerfile
echo %content% > product-catalog-service\Dockerfile
echo %content% > notification-logging-service\Dockerfile
echo All Dockerfiles updated to Java 21!
pause