# heroku  web: java -Dserver.port=$PORT $JAVA_OPTS -jar build/libs/kimilguk-boot2-0.0.1-SNAPSHOT.jar
FROM openjdk:17-jdk
# or info https://adjh54.tistory.com/420
#FROM bellsoft/liberica-openjdk-alpine:17
# FROM openjdk:8-jdk-alpine
# FROM openjdk:11-jdk-alpine

CMD ["./gradlew", "clean", "build"]
# or Maven 
# CMD ["./mvnw", "clean", "package"]

VOLUME /tmp

ARG JAR_FILE=build/libs/*.jar
# or Maven
# ARG JAR_FILE_PATH=target/*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
