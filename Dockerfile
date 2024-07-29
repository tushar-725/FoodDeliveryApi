FROM openjdk:17-oracle
COPY target/*.jar foodApi.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "foodApi.jar"]