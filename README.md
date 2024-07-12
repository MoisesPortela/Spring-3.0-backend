# Backend Consultation System

This project is a medical consultation system developed with Spring Boot 3.0, utilizing various modern technologies to facilitate development and integration.

## Main Features

- User management (doctors, patients, administrators)
- Appointment scheduling
- Consultation history and medical records
- Authentication and authorization using JWT

## Technologies Used

- **Spring Boot 3.0**: Java framework for creating RESTful APIs and web applications.
- **Swagger**: Tool for automatic documentation of REST APIs.
- **JPA (Java Persistence API)**: Java specification for object-relational mapping.
- **JWT (JSON Web Token)**: Method for securely transmitting information between parties as a compact and signed JSON object.
- **Lombok**: Java library that helps reduce boilerplate code.
- **Spring Boot DevTools**: Set of tools for rapid development and automatic server restarts.

## Prerequisites

- JDK 11 or higher
- Maven 3.x
- Configured MySQL/PostgreSQL database

## Environment Setup

1. **Clone the repository:**

- git clone https://github.com/your-username/consultation-system-backend.git


2. **Configure database properties:**

- Rename `application.example.properties` to `application.properties`.
- Edit database settings (url, username, password) as needed.

3. **Compile and run the project:**

- mvn spring-boot


4. **Access the API documentation:**

Once the server is running, access the Swagger API documentation at: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Contribution

Contributions are welcome! Feel free to fork the project and submit your suggestions via pull requests.

---

© 2024 Moisés Portela
