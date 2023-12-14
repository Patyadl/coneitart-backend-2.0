FROM eclipse-temurin:17-jdk-alpine

ARG JAR_FILE=target/*.jar

WORKDIR /app
COPY ${JAR_FILE} /app/application.jar

RUN mkdir -p /app \
    && chown -R 1001:1001 /app

EXPOSE 8080

ENTRYPOINT java -jar /app/application.jar
