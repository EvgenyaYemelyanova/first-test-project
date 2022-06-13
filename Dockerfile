FROM maven:3.8-jdk-11 AS build
COPY src /usr/src/first-test-project/src
COPY pom.xml /usr/src/first-test-project
RUN mvn -f /usr/src/first-test-project/pom.xml clean package

FROM openjdk:11
COPY --from=build /usr/src/first-test-project/target/first-test-project.jar first-test-project.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "first-test-project.jar"]