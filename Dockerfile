FROM openjdk:8
ADD target/docker-spring-book.jar docker-spring-book.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "docker-spring-book.jar"]

#docker build -f Dockerfile -t docker-spring-boot .
#docker run -p 8085:8080 docker-spring-boot