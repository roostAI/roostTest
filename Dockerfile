# Set the base image with JDK installed
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the application files into the container
COPY . /app

# Build the application using Maven
RUN chmod +x mvnw
RUN ./mvnw spring-javaformat:apply -DskipTests package

# Expose the port your Java application listens on
EXPOSE 8080

# Command to run the application when the container starts
CMD ["./mvnw", "spring-boot:run"]
