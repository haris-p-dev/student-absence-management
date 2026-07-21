# Repositories

This package contains the repository interfaces responsible for data access.

All repositories extend `JpaRepository`, allowing Spring Data JPA to automatically provide standard CRUD operations without requiring manual implementations.

Repositories act as the bridge between the service layer and the database.

The data flow follows:

```text
Service
    |
    v
Repository
    |
    v
JPA / Hibernate
    |
    v
Database
```

Repositories should contain only data access logic.  
Business logic is implemented in the service layer.

---

## Available Repositories

### StudentRepository

Provides data access operations for student entities.

---

### ModuleRepository

Provides data access operations for module entities.

---

### EnrollmentRepository

Provides data access operations for enrollment entities.

---

### SessionRepository

Provides data access operations for session entities.

---

### InstructorRepository

Provides data access operations for instructor entities.

---

### ModuleInstructorRepository

Provides data access operations for instructor-module assignments.

---

### AbsenceRepository

Provides data access operations for absence entities.

In addition to the standard CRUD operations, this repository includes custom JPQL queries for retrieving and managing absence-related data.

---

### ReportRepository

Provides custom data retrieval for reporting endpoints.

This repository primarily uses JPQL queries to retrieve aggregated data and map the results directly to response DTOs.

---

## Technologies & Annotations Used

Repositories make use of the following Spring Data JPA features.

### Spring Data JPA

```java
@Repository
JpaRepository<T, ID>
```

Provides CRUD operations, pagination and query generation.

---

### Query Methods

Spring Data JPA derives queries directly from method names.

Examples:

```java
findByEmail(...)
existsById(...)
findAllByModuleId(...)
```

---

### JPQL

The following repositories include custom JPQL queries using the `@Query` annotation:

- `AbsenceRepository`
- `ReportRepository`

These queries are used for more complex data retrieval and reporting operations that cannot be expressed efficiently through derived query methods.