FROM openjdk:11-jre-slim

COPY ./build/libs/demo-0.0.1-SNAPSHOT.jar spring-base.jar

CMD ["java","-jar","/spring-base.jar"]