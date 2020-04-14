FROM openjdk:8
ADD target/Word_Counter_New.jar Word_Counter_New.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Word_Counter_New.jar"]