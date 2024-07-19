FROM maven:3.9.5-amazoncorretto-21 as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:21
COPY --from=build /home/app/target/gestao-servidores-api-0.0.1-SNAPSHOT.jar /home/app/gestao-servidores-api-docker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/app/gestao-servidores-api-docker.jar"]