FROM eclipse-temurin:19.0.2_7-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=/build/libs/account-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
EXPOSE 5432
ENTRYPOINT ["java", "-jar", "/app.jar"]