#######Maven build stage########
FROM maven:3.8-jdk-11 as maven_build
WORKDIR /app

COPY src ./src

COPY pom.xml .

#resolve maven dependencies, select settings and profile
RUN mvn clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r target

# build the app (no dependency download here)
RUN mvn clean package  -Dmaven.test.skip


# split the built app into multiple layers to improve layer rebuild
RUN mkdir -p target/docker-packaging && cd target/docker-packaging && jar -xf /app/target/application.jar

FROM openjdk:11.0-jre

WORKDIR /app

COPY --from=maven_build /app/target/application.jar .

CMD [ "java", "-jar","./application.jar" ]

EXPOSE 8080:8080