FROM openjdk:8-jdk-alpine
ADD target/spring-book-store.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/app.jar"]
