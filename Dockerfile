FROM openjdk:17.0.2

WORKDIR /app

COPY ./target/CrudProduct-0.0.1-SNAPSHOT.jar .

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "CrudProduct-0.0.1-SNAPSHOT.jar"]