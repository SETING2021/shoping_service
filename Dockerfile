######## AMBIENTE GITHUB ########
#
#Build stage
#
FROM maven:3.5-jdk-8-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


######## AMBIENTE GITHUB ########
#
# Package stage
#
FROM openjdk:8-jdk-slim
COPY --from=build /home/app/target/shoping_service-0.0.1-SNAPSHOT.jar /usr/local/lib/shoping_service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/shoping_service.jar"]

######## AMBIENTE LOCAL ########
#
# Package stage
#
#FROM openjdk:8-jdk-slim
#COPY "./target/shoping_service-0.0.1-SNAPSHOT.jar" "shoping_service.jar"
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "shoping_service.jar"]