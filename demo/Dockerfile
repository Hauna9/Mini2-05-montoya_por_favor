FROM openjdk:25-ea-4-jdk-oraclelinux9

WORKDIR /app

COPY ./target/ target/


EXPOSE 8080

# We change the name of the build file into mini2 in pom.xml
# FIXME should i change this to miniapp like the folder name and hierarchy
ENTRYPOINT ["java", "-jar", "target/mini2.jar"]