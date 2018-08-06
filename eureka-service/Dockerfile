FROM maven:3.5-jdk-8-alpine AS MAVEN
COPY /src /usr/src
COPY /pom.xml /usr/
COPY /Dockerfile /usr
RUN mvn -f /usr/pom.xml package

FROM openjdk:8-jre-alpine
COPY --from=MAVEN /usr/target/eureka-service-0.0.1.jar //
ENTRYPOINT ["java", "-jar", "/eureka-service-0.0.1.jar", "-Xdebug -Xrunjdwp:server=y,transport=dt_socket,suspend=n"]