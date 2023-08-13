FROM openjdk:17-jdk-slim-buster

EXPOSE 8080

ADD build/libs/authService-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]