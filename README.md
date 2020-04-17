# spring-data-h2-dev-hal-docker


To run in command line
$mvn clean package

then
$mvn spring-boot:run

to run with docker

extract META-INF & WEB-INF from target/*.jar to /target/dependency folder before building Docker Image


$docker build -t springio/gs-spring-boot-docker/starter01 .


$docker run -p 8091:8080 -t springio/gs-spring-boot-docker/starter01
