# Controllers

This package contains the REST controllers of the application.

Controllers are responsible for handling HTTP requests, validating input DTOs and delegating operations to the service layer.

The application follows the layered architecture:



![UML Diagram](docs/images/architecture_diagram.png)
Controller
|
v
Service
|
v
Repository
|
v
Database


Controllers should contain only request handling logic.  
Business logic is implemented in the service layer.

---

## Available Controllers

### StudentController

Handles student related operations.

Responsibilities:

- Create student  `POST /api/students`

- Retrieve all students  `GET /api/students`

- Retrieve student by id  `GET /api/students/{id}`

- Update student information  `PUT /api/students/{id}`

- Delete student  `DELETE /api/students/{id}`

---

### ModuleController

Handles academic module operations.

Responsibilities:

- Create module  `POST /api/modules`

- Retrieve all modules  `GET /api/modules`

- Retrieve module by id  `GET /api/modules/{id}`

- Update module information `PUT /api/modules/{id}`

- Delete module   `DELETE /api/modules/{id}`


---

### EnrollmentController

Handles student enrollment operations.

Responsibilities:

- Create enrollment  `POST /api/enrollments`

- Retrieve enrollment by id  `GET /api/enrollments/{id}`

- Delete enrollment `DELETE /api/enrollments/{id}`

---

### SessionController

Handles module session management.

Responsibilities:

- Create session `POST /api/modules/{moduleId}/sessions`

- Retrieve module sessions  `GET /api/modules/{moduleId}/sessions`

- Filter sessions  `GET /api/modules/{moduleId}/sessions?`

---

### AbsenceController

Handles student absence records.

Responsibilities:

- Create absence record   `POST /api/absences`


- Update absence information  `PATCH /absences/{id}/justify`


The endpoint is fully dynamic: if no parameters are passed, it returns all registered absences, while allowing 
filtering based on the student, the course or the specific lecture (session).

- Retrieve absence records  `GET /api/absences/{id}`
- Retrieve absence records  `GET /api/absences`


---

### InstructorController

Handles instructor management.

Responsibilities:

- Create instructor  `POST /api/instructors`

- Retrieve all instructors  `GET /api/instructors`

- Retrieve instructor by id   `GET /api/instructors/{id}`

- Update instructor information  `PUT /api/instructors/{id}`

- Delete instructor  `DELETE /api/instructors/{id}`

---

### ModuleInstructorController

Handles instructor assignments to modules.

Responsibilities:

- Assign instructor to module   `POST /api/modules/{moduleId}/instructors/{instructorId}`

- Retrieve all instructors of a module  `GET api/modules/{moduleId}/instructors`

- Remove instructor from module  `DELETE /api/modules/{moduleId}/instructors/{instructorId}`

- Retrieve all modules an instructor teach  `GET api/modules/{moduleId}/instructors`


---

### ReportController

Handles application reporting endpoints.

Responsibilities:

- Student attendance summary  `GET /api/students/{id}/modules/{moduleId}"`

- Module statistics  `GET /api/modules/{id}/stats`

The user can set a threshold. If he doesn't the default is set through application.properties
- At-risk students report  `GET /api/modules/{id}/at-risk`

---

## Validation & Error Handling

Request validation is performed using Bean Validation annotations.

Example:

```java
@Valid @RequestBody StudentRequestDTO request

Global exception handling is managed using:

@ControllerAdvice

Controllers do not handle exceptions manually.

Exceptions are converted into structured error responses by the global exception handler.