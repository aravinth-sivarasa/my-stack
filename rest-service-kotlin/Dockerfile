FROM eclipse-temurin:17-jre-jammy
ARG bundle_path="build/libs/**.jar"
COPY $bundle_path /usr/src/myapp/app.jar
WORKDIR /usr/src/myapp
CMD ["java", "-jar","app.jar","--spring.profiles.active=prod"]