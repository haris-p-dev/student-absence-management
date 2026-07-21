# Exception Handling

This package contains the custom exceptions and the global exception handler used throughout the application.

The exception handling mechanism provides consistent error responses and separates error handling from the business logic.

All exceptions are processed by the global exception handler, which converts them into structured HTTP responses.

---

## Available Exceptions

### ResourceNotFoundException

Thrown when a requested resource cannot be found.

Typical examples include:

- Student not found.
- Module not found.
- Enrollment not found.

---

### DuplicateResourceException

Thrown when attempting to create a resource that already exists or violates uniqueness constraints.

---

### InvalidRequestException

Thrown when a request violates business validation rules or contains invalid data.

---

## Global Exception Handler

### GlobalExceptionHandler

Handles application exceptions using `@ControllerAdvice`.

Responsibilities:

- Intercept application exceptions.
- Return appropriate HTTP status codes.
- Generate consistent error response bodies.
- Prevent exception handling code from being duplicated across controllers.

---

## Error Response

The global exception handler returns a structured response containing information such as:

- Timestamp
- HTTP status
- Error message
- Request path