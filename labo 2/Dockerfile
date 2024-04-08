FROM adoptopenjdk/openjdk22

EXPOSE 8080

ARG JAR_FİLE= target//labo/target/demo-0.0.1-SNAPSHOT.jar.original
 
 ADD ${JAR_FILE} labo.jar

ENTRYPOINT  ["java", "-jar", "labo.jar"]
