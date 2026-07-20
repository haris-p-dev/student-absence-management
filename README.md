# Student Absence Management System

## Overview

The Student Absence Management System is a RESTful backend application developed with Spring Boot for managing student attendance and absences in an academic environment.

The system allows administrators and instructors to manage students, academic modules, enrollments, teaching sessions and attendance records while providing reporting capabilities for monitoring student participation.

This project was developed as part of the TechPro Academy Back-End Development Bootcamp.

---

## Technologies

- Java 17
- Spring Boot 3
- Spring Data JPA
- Hibernate
- PostgreSQL 15
- Maven
- Docker & Docker Compose
- OpenAPI / Swagger

---

## Features

The application provides APIs for:

- Student management
- Module management
- Instructor assignment to modules
- Student enrollments
- Teaching session management
- Attendance and absence tracking
- Reporting and statistics

---

## Project Structure

The project follows the standard Spring Boot layered architecture.

Each major package contains its own README with implementation details.

```
src/main/java
├── config
├── controller
├── dto
├── entity
├── enums
├── exception
├── repository
├── service
└── ...
```

---

## Requirements

Before running the application make sure the following software is installed:

- Docker Desktop
- Docker Compose

No local PostgreSQL or Java installation is required.

---

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/haris-p-dev/student-absence-management
cd Student-Absence-Management-System
```

### 2. Create the environment configuration

Create a `.env` file based on the provided example.

```bash
cp .env.example .env
```

If you are using Windows PowerShell:

```powershell
Copy-Item .env.example .env
```

---

### 3. Start the application

Run:

```bash
docker compose up
```

Docker Compose will:

- Build the Spring Boot application
- Start the PostgreSQL database
- Connect both containers
- Expose the REST API

---

## API Documentation

Once the application has started successfully, Swagger UI is available at:


http://localhost:8080/swagger-ui.html


---

## Configuration

Application configuration is externalized using environment variables.

The default values can be found in:

```
.env.example
```

---

## Documentation

Additional documentation is available inside the project's packages.

Each layer contains its own README explaining its responsibilities and implementation.

---

## License

This project was developed for educational purposes.