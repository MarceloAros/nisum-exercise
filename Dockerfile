FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8080
RUN mkdir -p /app
WORKDIR /app
ADD build/libs/nisum-exercise-0.0.1-SNAPSHOT.jar /app/nisum-exercise-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "nisum-exercise-0.0.1-SNAPSHOT.jar"]