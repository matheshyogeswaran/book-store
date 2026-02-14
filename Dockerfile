# Use OpenJDK 22
FROM openjdk:22-jdk

# Set working directory inside container
WORKDIR /app

# Copy the built jar into the container
COPY target/book-store.jar book-store.jar

# Expose Spring Boot default port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "book-store.jar"]
