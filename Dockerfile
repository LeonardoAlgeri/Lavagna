FROM openjdk:8
ADD target/lavagna.jar lavagna.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "lavagna.jar"]