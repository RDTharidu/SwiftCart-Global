@echo off
echo ===================================================
echo     Starting SwiftCart Microservices...
echo ===================================================

echo Starting API Gateway (Port 8080)...
start "API Gateway" cmd /k "cd api-gateway && .\mvnw.cmd spring-boot:run"

echo Starting Product Catalog Service (Port 8082)...
start "Product Catalog" cmd /k "cd product-catalog-service && .\mvnw.cmd spring-boot:run"

echo Starting Order Processing Service (Port 8083)...
start "Order Processing" cmd /k "cd order-processing-service && .\mvnw.cmd spring-boot:run"

echo Starting Inventory Service (Port 8084)...
start "Inventory Service" cmd /k "cd inventory-service && .\mvnw.cmd spring-boot:run"

echo Starting Notification Service (Port 8085)...
start "Notification Service" cmd /k "cd notification-logging-service && .\mvnw.cmd spring-boot:run"

echo.
echo All services are starting up in separate windows!
echo Please wait about 30 seconds for all of them to fully load.
echo ===================================================
pause