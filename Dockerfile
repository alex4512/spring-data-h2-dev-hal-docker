FROM openjdk:8-jdk-alpine
RUN addgroup -S jenkins && adduser -S jenkins -G jenkins
USER jenkins:jenkins
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.demo.DemoApplication"]
