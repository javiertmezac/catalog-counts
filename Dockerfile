#syntax=docker/dockerfile:1
FROM openjdk:8-jre-alpine
#openjdk:16-alpine3.13
MAINTAINER javiermeza.cazarez@gmail.com

ARG JDBC_URL
ARG JDBC_USERNAME
ARG JDBC_PASSWORD

ENV JDBC.url=$JDBC_URL
ENV JDBC.username=$JDBC_USERNAME
ENV JDBC.password=$JDBC_PASSWORD

COPY cc-service-server/target/cc-service.jar /app/server.jar

EXPOSE 8080

CMD ["-cp", "/app/server.jar", "com.jtmc.apps.reforma.infrastructure.jetty.Launcher"]
ENTRYPOINT ["java"]
