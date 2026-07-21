# Services

This package contains the service classes that implement the application's business logic.

The service layer acts as the bridge between the controllers and the repositories. It is responsible for processing requests, enforcing business rules, coordinating database operations and returning the appropriate DTOs.

The application follows the layered architecture:

```
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
```

The service layer is responsible for:

- Implementing business logic.
- Coordinating repository operations.
- Managing transactions.
- Converting Entities to DTOs and vice versa.
- Invoking validators when business validation is required.
- Throwing custom exceptions when an operation cannot be completed.

---

## Available Services

### StudentService

Handles all business operations related to students.

Responsibilities:

- Create students
- Retrieve students
- Update student information
- Delete students

---

### ModuleService

Handles business operations related to academic modules.

Responsibilities:

- Create modules
- Retrieve modules
- Update module information
- Delete modules

---

### EnrollmentService

Handles student enrollment operations.

Responsibilities:

- Create enrollments
- Retrieve enrollments
- Delete enrollments

---

### SessionService

Handles module session management.

Responsibilities:

- Create sessions
- Retrieve sessions
- Filter sessions

---

### AbsenceService

Handles student absence management.

Responsibilities:

- Record absences
- Retrieve absence records
- Update absence information
- Delete absence records

---

### InstructorService

Handles instructor management.

Responsibilities:

- Create instructors
- Retrieve instructors
- Update instructor information
- Delete instructors

---

### ModuleInstructorService

Handles instructor assignments to modules.

Responsibilities:

- Assign instructors to modules
- Retrieve instructor assignments
- Remove instructor assignments

---

### ReportService

Generates reports and statistical information.

Responsibilities:

- Generate student attendance summaries
- Generate module statistics
- Generate at-risk student reports

---

## Technologies & Annotations Used

### Spring

```java
@Service
```

Marks a class as a Spring Service component.

---

### Dependency Injection

```java
@RequiredArgsConstructor
```

Used for constructor-based dependency injection.

---

### Transactions

```java
@Transactional
```

Ensures database operations are executed within a transaction.

---

## Service Responsibilities

The service layer should:

- Contain business logic.
- Keep controllers lightweight.
- Interact with repositories only when necessary.
- Use validators for business validation.
- Throw custom exceptions when required.
- Never expose entities directly to the API.