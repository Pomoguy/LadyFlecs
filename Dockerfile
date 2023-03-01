FROM openjdk:18.0.2-oraclelinux8
ARG JAR_FILE=*.jar
COPY target/${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
