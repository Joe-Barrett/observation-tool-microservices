FROM maven:3.5-jdk-8-slim AS MAVEN

COPY pom.xml /tmp/
RUN ls -l
COPY /src /tmp/
WORKDIR /tmp/
RUN mvn clean package


FROM java:8
COPY --from=MAVEN /tmp/target/spectral-service-0.0.1.jar //
ENTRYPOINT ["java", "-jar", "/spectral-service-0.0.1.jar", "-Xdebug -Xrunjdwp:server=y,transport=dt_socket,suspend=n"]