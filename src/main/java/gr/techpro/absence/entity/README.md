# Entities

This package contains the JPA entity classes that represent the application's database model.

Entities define how Java objects are mapped to database tables and how those tables are related to each other. They form the persistence layer of the application and are managed by Hibernate through Spring Data JPA.

Entities are not exposed directly to API clients. Instead, they are converted to and from DTOs by the service layer.

The application follows the flow:

```text
Request DTO
     |
     v
Controller
     |
     v
Service
     |
     v
Entity
     |
     v
Repository
     |
     v
Database
```

---

## Available Entities

### StudentEntity

Represents the students table.

---

### ModuleEntity

Represents the modules table.

---

### EnrollmentEntity

Represents the relationship between students and modules.

---

### SessionEntity

Represents the sessions scheduled for each module.

---

### AbsenceEntity

Represents student attendance records for module sessions.

---

### InstructorEntity

Represents instructors within the system.

---

### ModuleInstructorEntity

Represents the relationship between instructors and modules.

---

## Technologies & Annotations Used

### JPA Entity Mapping

```java
@Entity
@Table
```

Defines a class as a JPA entity and maps it to a database table.

---

### Primary Keys

```java
@Id
@GeneratedValue
```

Defines the primary key and its generation strategy.

---

### Relationship Mapping

```java
@OneToMany
@ManyToOne
@ManyToMany
@OneToOne
@JoinColumn
@JoinTable
```

Defines relationships between entities and their corresponding foreign keys.

---

### Enum Mapping

```java
@Enumerated(EnumType.STRING)
```

Stores enum values as readable strings in the database.

---

### Column Mapping

```java
@Column
```

Used to configure database column properties such as nullability, uniqueness and column definitions.

---

### Entity Lifecycle

```java
@PrePersist
@PreUpdate
```

Automatically executes logic before an entity is inserted or updated.

---

### Lombok

```java
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
```

Reduces boilerplate code by generating common methods automatically.