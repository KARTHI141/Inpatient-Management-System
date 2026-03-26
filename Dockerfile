# Stage 1: Build Angular frontend
FROM node:18-alpine AS frontend-build
WORKDIR /app
COPY package*.json ./
RUN npm ci
COPY angular.json tsconfig*.json ./
COPY src/app/ src/app/
COPY src/environments/ src/environments/
COPY src/assets/ src/assets/
COPY src/index.html src/main.ts src/styles.css src/favicon.ico src/
RUN npm run build -- --configuration=production

# Stage 2: Build Spring Boot backend
FROM maven:3.9-eclipse-temurin-17 AS backend-build
WORKDIR /app
COPY pom.xml .
# Skip frontend-maven-plugin since we already built Angular
COPY mvnw mvnw.cmd ./
COPY src/main/java/ src/main/java/
COPY src/main/resources/ src/main/resources/
COPY src/main/webapp/ src/main/webapp/
COPY src/test/ src/test/
COPY --from=frontend-build /app/src/main/resources/static/ src/main/resources/static/
RUN mvn package -DskipTests -Dfrontend.skip=true

# Stage 3: Run
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=backend-build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
