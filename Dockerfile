FROM amazoncorretto:21-alpine-jdk

MAINTAINER javiermeza.cazarez@gmail.com

COPY cc-service-server/target/cc-service.jar /app/server.jar

EXPOSE 8080

CMD ["-cp", "/app/server.jar", "com.jtmc.apps.reforma.infrastructure.jetty.Launcher"]
ENTRYPOINT ["java"]
