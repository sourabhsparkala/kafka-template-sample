FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/kafka-template-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# docker buildx build --tag kafka-template:latest .