# Use a generic image as a build stage
FROM amazoncorretto:17 as build

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle configuration files and source code into the container
COPY ../../../gradlew /app/
COPY ../../../gradle /app/gradle
COPY ../../../build.gradle /app/
COPY ../../../settings.gradle /app/
COPY ../.. /app/src

# Grant execution permissions to the Gradle wrapper
RUN chmod +x /app/gradlew

# Build the application using the Gradle wrapper
RUN ./gradlew clean build

# Use Amazon Corretto 17 for the application stage
FROM amazoncorretto:17

# Copy the JAR from the build stage to the app directory
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "/app/app.jar"]
