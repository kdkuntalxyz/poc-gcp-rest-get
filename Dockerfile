FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} poc-gcp-rest-get.jar
ENTRYPOINT ["java","-jar","/poc-gcp-rest-get.jar"]