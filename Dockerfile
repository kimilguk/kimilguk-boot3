FROM eclipse-temurin:17-jdk
ARG JAR_FILE=build/libs/kimilguk-boot3.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
