# create container with jdk 17
FROM eclipse-temurin:17-jdk
# next command run in app direction
WORKDIR /app
#copy the jar file that created by Maven from host to container, then container has everything it needs to run Spring boot.
COPY target/tms-0.0.1-SNAPSHOT.jar app.jar
# container automatic run the project
ENTRYPOINT ["java", "-jar", "app.jar"]