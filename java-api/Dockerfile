# Use the official AdoptOpenJDK base image
FROM adoptopenjdk:21-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container at /app
COPY target/circle-java-api.jar /app/circle-java-api.jar

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "circle-java-api.jar"]
