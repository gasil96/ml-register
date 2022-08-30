FROM openjdk:11
ADD target/*.jar registerapplication
ENTRYPOINT ["java", "-jar","registerapplication"]
EXPOSE 8081