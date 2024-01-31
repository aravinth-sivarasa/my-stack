FROM eclipse-temurin:17-jre-jammy
COPY build/libs/**.jar /usr/src/myapp/app.jar
WORKDIR /usr/src/myapp
CMD ["java", "-jar","app.jar","--spring.profiles.active=prod"]