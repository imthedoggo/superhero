FROM openjdk:11-jre-slim

MAINTAINER Avgustina Shevchuk <avgu92@gmail.com>

RUN mkdir /app
COPY ./build/libs/superhero-0.0.1-SNAPSHOT.jar /app
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "superhero-0.0.1-SNAPSHOT.jar"]