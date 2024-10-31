FROM openjdk:8-jre-alpine
MAINTAINER javiermeza.cazarez@gmail.com

COPY cc-service-server/target/cc-service.jar /app/server.jar
RUN mkdir /var/log/cc-service

EXPOSE 8080

CMD ["-cp", "/app/server.jar", "com.jtmc.apps.reforma.infrastructure.jetty.Launcher"]
ENTRYPOINT ["java"]