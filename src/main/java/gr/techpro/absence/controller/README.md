# Controllers Package

This package contains all REST controllers responsible for handling HTTP requests and responses.

The controllers act as the entry point of the application and follow the standard Spring Boot layered architecture:

Client
|
v
Controller Layer
|
v
Service Layer
|
v
Repository Layer
|
v
Database


Controllers are responsible for:

- Receiving HTTP requests.
- Validating incoming DTOs using Bean Validation.
- Mapping request data to service calls.
- Returning appropriate HTTP responses.
- Delegating business logic to the service layer.

Business rules and database operations are not handled inside controllers. These responsibilities belong to the Service and Repository layers respectively.

---

## Available Controllers

### StudentController

Handles all operations related to students.

Responsibilities:

- Create a new student.
- Retrieve student information.
- Update student data.
- Delete students.

Main resource:
/api/students


---

### ModuleController

Handles operations related to academic modules.

Responsibilities:

- Create modules.
- Retrieve module information.
- Update module details.
- Delete modules.
- Manage module sessions.

Main resource:

/api/modules

---

### EnrollmentController

Handles student enrollment operations.

Responsibilities:

- Enroll students into modules.
- Retrieve enrollments.
- Delete enrollments.

Business validations handled by the service layer include:

- Preventing duplicate active enrollments.
- Managing enrollment status.

Main resource:


/api/enrollments


---

### SessionController

Handles module session management.

Responsibilities:

- Create sessions for modules.
- Retrieve sessions.
- Filter sessions based on requested criteria.

A session always belongs to exactly one module.

Main resource:


/api/modules/{moduleId}/sessions


---

### AbsenceController

Handles student absence records.

Responsibilities:

- Record absences.
- Retrieve absence information.
- Update absence status.
- Delete absence records.

Business validations handled by the service layer include:

- Student must be actively enrolled in the module.
- Duplicate absence records are not allowed.
- Enrollment and session must belong to the same module.

Main resource:


/api/absences


---

### InstructorController

Handles instructor management.

Responsibilities:

- Create instructors.
- Retrieve instructor information.
- Update instructor data.
- Delete instructors.

Main resource:


/api/instructors


---

### ModuleInstructorController

Handles instructor assignments to modules.

Responsibilities:

- Assign instructors to modules.
- Manage instructor roles.

Supported roles:


LEAD
ASSISTANT


Main resource:


/api/modules/{moduleId}/instructors


---

### ReportController

Handles reporting and statistics endpoints.

Responsibilities:

- Generate student attendance reports.
- Retrieve module statistics.
- Identify students at risk based on absence thresholds.

Main resource:


/api/reports


Available reports include:

- Student module attendance summary.
- Module statistics.
- At-risk students.

---

## Validation and Exception Handling

Controllers use:

- `@Valid` for DTO validation.
- `@RequestBody` for incoming request payloads.
- `@PathVariable` for resource identifiers.
- `@RequestParam` for optional query parameters.

Example:

` java `
@PostMapping
public ResponseEntity<StudentResponseDTO> createStudent(
        @Valid @RequestBody StudentRequestDTO request
) {
    return ResponseEntity.ok(studentService.createStudent(request));
}

Exceptions are handled globally through:

@ControllerAdvice

The controllers do not catch business exceptions manually.

The global exception handler converts exceptions into structured error responses containing:

Timestamp
HTTP status
Error message
Request path
Design Principles

The controller layer follows these principles:

Keep controllers lightweight.
Avoid business logic inside controllers.
Use DTOs instead of exposing entities directly.
Delegate operations to services.
Return meaningful HTTP status codes.
Controller = HTTP communication
Service    = Business logic
Repository = Data access
Entity     = Database representation
DTO        = API data transfer