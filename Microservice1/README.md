# Microservice1 - REST Web Service

A simple REST web service built with Java that exposes two greeting endpoints. This microservice demonstrates basic REST API principles and can be used as a template for building more complex REST services.

## Overview

Microservice1 is a lightweight REST web service that provides two simple greeting methods. It accepts a `name` parameter and returns personalized greeting messages. This service is ideal for learning REST API fundamentals and can be easily extended with additional functionality.

## Features

- **Simple REST API** - Easy to understand and use endpoints
- **Two Greeting Endpoints**:
  - `sayHello` - Returns a hello greeting with the provided name
  - `sayGM` - Returns a good morning greeting with the provided name
- **Parameter Validation** - Accepts `name` as input parameter
- **Lightweight** - Minimal dependencies and fast startup time
- **RESTful Design** - Follows REST conventions and best practices

## Technology Stack

- **Language**: Java
- **Architecture**: REST API
- **Framework**: (Specify your framework - e.g., Spring Boot, Jersey, etc.)

## Project Structure

```
Microservice1/
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/microservice1/
│   │   │       ├── controller/
│   │   │       │   └── GreetingController.java
│   │   │       ├── service/
│   │   │       │   └── GreetingService.java
│   │   │       └── Application.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/microservice1/
│               └── GreetingControllerTest.java
├── pom.xml
└── .gitignore
```

## API Endpoints

### 1. Say Hello Endpoint

**Endpoint**: `GET /api/greeting/hello`

**Parameters**:
- `name` (String, Required) - The name to greet

**Request Example**:
```
GET /api/greeting/hello?name=John
```

**Response Example**:
```json
{
  "message": "Hello, John!"
}
```

**Status Code**: `200 OK`

---

### 2. Say Good Morning Endpoint

**Endpoint**: `GET /api/greeting/gm`

**Parameters**:
- `name` (String, Required) - The name to greet

**Request Example**:
```
GET /api/greeting/gm?name=Jane
```

**Response Example**:
```json
{
  "message": "Good Morning, Jane!"
}
```

**Status Code**: `200 OK`

---

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.6.0 or higher (or Gradle, depending on your build tool)
- Git

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/prashantmangate/rest-soap-grpc-graphql-examples.git
   cd rest-soap-grpc-graphql-examples/Microservice1
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```
   
   The service will start on `http://localhost:8080` (default port)

### Configuration

Update `src/main/resources/application.properties` for custom configuration:

```properties
server.port=8080
server.servlet.context-path=/api
spring.application.name=microservice1
```

## Usage Examples

### Using cURL

```bash
# Say Hello
curl "http://localhost:8080/api/greeting/hello?name=Alice"

# Say Good Morning
curl "http://localhost:8080/api/greeting/gm?name=Bob"
```

### Using Postman

1. Import the API endpoints in Postman
2. Create a new GET request
3. Enter the URL: `http://localhost:8080/api/greeting/hello?name=YourName`
4. Click Send

### Using Java HTTP Client

```java
URL url = new URL("http://localhost:8080/api/greeting/hello?name=Charlie");
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
int responseCode = connection.getResponseCode();
// Handle response...
```

## Testing

Run the unit tests using Maven:

```bash
mvn test
```

### Test Coverage

The project includes unit tests for:
- Happy path scenarios for both endpoints
- Parameter validation
- Error handling

## Error Handling

### Missing Parameter

**Request**:
```
GET /api/greeting/hello
```

**Response**:
```json
{
  "error": "Missing required parameter: name"
}
```

**Status Code**: `400 Bad Request`

---

### Invalid Input

**Request**:
```
GET /api/greeting/hello?name=
```

**Response**:
```json
{
  "error": "Parameter 'name' cannot be empty"
}
```

**Status Code**: `400 Bad Request`

## Building & Deployment

### Build JAR

```bash
mvn clean package
```

This creates a JAR file in the `target/` directory.

### Run JAR

```bash
java -jar target/microservice1-1.0.jar
```

### Docker Deployment (Optional)

Create a `Dockerfile`:

```dockerfile
FROM openjdk:11-jre-slim
COPY target/microservice1-1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

Build and run:

```bash
docker build -t microservice1:latest .
docker run -p 8080:8080 microservice1:latest
```

## API Documentation

For detailed API documentation, you can use Swagger/SpringFox (if integrated):

```
http://localhost:8080/swagger-ui.html
```

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m 'Add YourFeature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a Pull Request

## Future Enhancements

- [ ] Add request/response logging
- [ ] Implement caching for frequently used names
- [ ] Add rate limiting
- [ ] Integrate with database for persistent greeting history
- [ ] Add more greeting methods (sayGoodbye, sayGoodEvening, etc.)
- [ ] Implement authentication and authorization
- [ ] Add comprehensive Swagger/OpenAPI documentation
- [ ] Performance monitoring and metrics

## Troubleshooting

### Port Already in Use

If port 8080 is already in use, change it in `application.properties`:

```properties
server.port=8081
```

### Build Failures

Ensure Java and Maven are properly installed:

```bash
java -version
mvn -version
```

### Connection Refused

Make sure the application is running before making API requests.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact & Support

For questions or issues, please open an issue on GitHub or contact the maintainer at [your-email@example.com].

---

**Last Updated**: May 2026

**Version**: 1.0.0

**Status**: Active Development
