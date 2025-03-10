FROM maven:3.9.9-eclipse-temurin-23 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:23-jdk
COPY --from=build /target/kudos-0.0.1-SNAPSHOT.jar kudos.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "kudos.jar"]
