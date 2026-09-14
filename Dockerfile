FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY target/campuscare-0.1.0.jar app.jar
RUN addgroup -S campuscare && adduser -S campuscare -G campuscare
USER campuscare
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
