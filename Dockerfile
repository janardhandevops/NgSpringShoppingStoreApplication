# Use an official OpenJDK runtime as a parent image
FROM openjdk:8

# Set the working directory to /NgSpringShoppingStoreApplication
WORKDIR /NgSpringShoppingStoreApplication

# Copy the pom.xml file and download the dependencies
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the application code
COPY src ./src

# Build the application skipping the tests
RUN ./mvnw package -DskipTests

# Set the default command to run the application
CMD ["java", "-jar", "./target/NGSpringShoppingStore-0.0.1-SNAPSHOT.jar"]