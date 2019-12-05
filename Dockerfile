FROM openjdk:8-jdk-alpine
ARG DEPENDENCY=target/dependency
ARG JAR_FILE=spring-boot2-jpa-crud-example-master/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]