FROM maven:3.5-jdk-8-alpine AS MAVEN
COPY /specrtal-service/src /usr/src
COPY /spectral-service/pom.xml /usr
COPY Dockerfile /usr
RUN mvn -f /usr/pom.xml clean install

FROM openjdk:8-jre-alpine
COPY --from=MAVEN /usr/target/spectral-service-0.0.1.jar //
ENTRYPOINT ["java", "-jar", "/spectral-service-0.0.1.jar", "-Xdebug -Xrunjdwp:server=y,transport=dt_socket,suspend=n"]