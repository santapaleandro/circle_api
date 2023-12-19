# Circle_API
#### Author: Pawel Santarius

### Components
- Point Entity: Represents a point in a 2D coordinate system.
- Circle Class: Represents a circle defined by a center (Point) and radius.
- is_inside Method: A method in the Circle class to determine if a given point lies within the circle using Pythagorean theorem.
- JUnit Tests: Tests to validate the functionality of the is_inside method.

### Bonus Features
- REST API: An API endpoint to determine if a point lies within a given circle, accepting JSON input defining the circle and the point.
- Swagger Integration: Use Swagger for API documentation and testing.
- Executable JAR: A build that creates an executable and portable JAR file.
- Command Line Execution: Instructions on running the JAR file from the command line.
- API Testing: Steps to call the REST API and receive a boolean response indicating if the point is inside the circle.


### Build
- gradle clean build
#### config 
- application.yaml
- docker-compose.yaml
#### database
- mongoDB
#### swagger
- enter threw localhost:8080/swagger