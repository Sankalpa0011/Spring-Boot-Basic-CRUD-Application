# Spring Boot Basic CRUD Application

![Java](https://img.shields.io/badge/Java-100%25-blue)

## Overview

This project is a basic CRUD (Create, Read, Update, Delete) application built with Spring Boot. It demonstrates the fundamental concepts of building a RESTful web service using Spring Boot.

## Features

- Create, Read, Update, and Delete operations
- RESTful API design
- Integration with a MySQL database
- Exception handling
- Input validation
- API documentation using OpenAPI (SpringDoc)

## Technologies Used

- **Java**: The primary language for the backend.
- **Spring Boot**: For creating stand-alone, production-grade Spring-based applications.
- **Spring Data JPA**: For ORM (Object Relational Mapping) and database interactions.
- **Hibernate**: For ORM (Object Relational Mapping).
- **MySQL**: The relational database used.
- **SpringDoc OpenAPI**: For API documentation.
- **Lombok**: For reducing boilerplate code.
- **ModelMapper**: For object mapping.
- **MapStruct**: For object mapping.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- MySQL or any other relational database

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/Sankalpa0011/Spring-Boot-Basic-CRUD-Application.git
    cd Spring-Boot-Basic-CRUD-Application
    ```

2. Configure the database in `application.properties`:
    ```properties
    spring.application.name=pos
    server.port=8090

    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    spring.datasource.url=jdbc:mysql://localhost:3306/batch7pos?createDatabaseIfNotExist=true
    spring.datasource.username=root
    spring.datasource.password=root

    # jpa vendor adapter configurations
    spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
    spring.jpa.generate-ddl=true
    spring.jpa.show-sql=true
    ```

3. Build and run the backend:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Usage

1. The application will start running at `http://localhost:8090`.
2. Use a tool like Postman to interact with the API endpoints for CRUD operations.

## Folder Structure

- `src/main/java/com/example/crud/`: Java source files.
    - `controller/`: Contains REST controllers.
    - `model/`: Contains entity classes.
    - `repository/`: Contains repository interfaces.
    - `service/`: Contains service classes.
    - `CrudApplication.java`: Main class to run the Spring Boot application.
- `src/main/resources/`: Configuration files and resources.
    - `application.properties`: Database and application configurations.
- `src/test/java/com/example/crud/`: Test classes.
    - `CrudApplicationTests.java`: Test class for the main application.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push the branch (`git push origin feature-branch`).
5. Open a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or feedback, please contact [Sankalpa0011](https://github.com/Sankalpa0011).
