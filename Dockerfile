FROM openjdk:17-jdk-alpine
COPY target/poc-gcp-rest-get-0.0.1-SNAPSHOT.jar poc-gcp-rest-get-1.0.0.jar
ENTRYPOINT ["java","-jar","/poc-gcp-rest-get-1.0.0.jar"]