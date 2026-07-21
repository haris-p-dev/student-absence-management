# Response DTOs

This package contains the Data Transfer Objects (DTOs) used to return data from the application to API clients.

Unlike the Request DTOs, the number of Response DTOs is greater because the application returns different representations of data depending on the endpoint.

While a Request DTO usually represents the data required for a client request (e.g., create or update operations), a Response DTO is designed around what each endpoint needs to return. As a result, specialized DTOs are used for reports, statistics, summaries and other custom responses.

Response DTOs also prevent database entities from being exposed directly to API consumers.

The application follows the flow:

```text
Database
    |
    v
Entity
    |
    v
Service
    |
    v
Response DTO
    |
    v
Controller
    |
    v
Client
```

---

## Available Response DTOs

### StudentResponseDTO

Represents student information returned by student endpoints.

---

### ModuleResponseDTO

Represents module information returned by module endpoints.

---

### EnrollmentResponseDTO

Represents enrollment information returned by enrollment endpoints.

---

### SessionResponseDTO

Represents session information returned by session endpoints.

---

### AbsenceResponseDTO

Represents absence information returned by absence endpoints.

---

### InstructorResponseDTO

Represents instructor information returned by instructor endpoints.

---

### ModuleInstructorResponseDTO

Represents instructor assignments to modules.

---

### SummaryResponseDTO

Represents attendance summary data used by reporting endpoints.

---

### AttendanceStatisticsDTO

Represents attendance statistics returned by reporting endpoints.

---

### ModuleStatsResponseDTO

Represents module statistics and aggregated information.

---

### AtRiskStudentResponseDTO

Represents students identified as being at risk based on attendance records.

---

### ErrorResponseDTO

Represents the standardized error response returned by the global exception handler.

---

## Mapping

Most Response DTOs provide a static `from()` method.

The `from()` method is responsible for converting an Entity into its corresponding Response DTO. This centralizes the mapping logic inside the DTO itself, keeping the service layer cleaner and ensuring consistent object conversion throughout the application.

Typical mapping flow:

```text
Entity
   |
   v
ResponseDTO.from(entity)
   |
   v
Response DTO
```

Some reporting DTOs (such as statistics and summary DTOs) are populated directly from JPQL query results instead of using the `from()` method, since they represent aggregated data rather than a single entity.

---

## Technologies & Annotations Used

### Lombok

```java
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
```

Generates common boilerplate code automatically.

---

### Jackson

```java
@JsonFormat
```

Used to control the serialization of date and time values in JSON responses.