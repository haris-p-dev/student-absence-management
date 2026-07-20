# Request DTOs

This package contains the Data Transfer Objects (DTOs) used for incoming API requests.

Request DTOs define the structure of the data accepted by the application from clients.

They are responsible for:

- Receiving client input.
- Validating incoming data before processing.
- Separating API input models from database entities.
- Preventing direct exposure of entity objects.

The request flow follows:


Client Request
|
v
Request DTO
|
v
Controller
|
v
Service Layer
|
v
Entity


---

## Available Request DTOs

### StudentRequestDTO

Used for creating and updating student information.

Contains the required student input data.

Validation applied:

- Required fields validation
- Email format validation
- String length validation

---

### ModuleRequestDTO

Used for creating and updating module information.

Contains module related input data.


Validation applied:

- Required fields validation
- Enum validation
- String length validation

---

### EnrollmentRequestDTO

Used for creating student enrollments.


Contains enrollment related input data.

Validation applied:

- Required identifiers validation
- Enum validation where required

---

### SessionRequestDTO

Used for creating module sessions.


Contains session information such as date, time and type.

Validation applied:

- Required fields validation
- Date/time validation
- Enum validation

---

### AbsenceRequestDTO

Used for creating and updating absence records.


Contains absence information.

Validation applied:

- Required fields validation
- Enum validation

---

### InstructorRequestDTO

Used for creating and updating instructor information.


Contains instructor related input data.

Validation applied:

- Required fields validation
- Email format validation
- String length validation

---

### ModuleInstructorRequestDTO

Used for assigning instructors to modules.


Contains instructor assignment information.

Validation applied:

- Required identifiers validation
- Enum validation for instructor role

---

## Annotations Used

Request DTOs use:

### Lombok

Used to reduce boilerplate code.

```java
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
Bean Validation

Used for validating incoming request data.

Common annotations:

@NotNull
@NotBlank
@Email
@Size
@Pattern
@Valid
Jackson

Used for JSON serialization/deserialization customization.

@JsonFormat