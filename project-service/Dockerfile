FROM maven:3.5-jdk-8-alpine AS MAVEN
COPY /src /usr/src
COPY /pom.xml /usr/
COPY /Dockerfile /usr
RUN mvn -f /usr/pom.xml package

FROM openjdk:8-jre-alpine
COPY --from=MAVEN /usr/target/project-service-0.0.1.jar //
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5858", "-jar", "/project-service-0.0.1.jar"]