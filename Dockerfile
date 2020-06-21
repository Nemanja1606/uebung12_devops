FROM openjdk:11-jre-slim-buster

WORKDIR /calculator

COPY target/calc-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

CMD ["java", "-jar", "app.jar"]
