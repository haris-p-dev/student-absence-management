# Entities

This package contains the JPA entity classes that represent the database tables of the application.

Entities are responsible for:

- Mapping Java objects to database tables.
- Defining relationships between database entities.
- Representing the persistence layer of the application.
- Allowing Hibernate to manage database operations through JPA.

Entities are not exposed directly through the API.  
Data exchange between the client and the application is handled using DTOs.

The application follows the flow:

```
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

Represents the student table.

---

### ModuleEntity

Represents the module table.

---

### EnrollmentEntity

Represents the enrollment table.

---

### SessionEntity

Represents the session table.

---

### AbsenceEntity

Represents the absence table.

---

### InstructorEntity

Represents the instructor table.

---

### ModuleInstructorEntity

Represents the module-instructor assignment table.

---

## JPA Annotations Used

The entities use the following JPA annotations for object-relational mapping.

### Entity Mapping

```java
@Entity
@Table
```

Marks a class as a JPA entity and maps it to a database table.

---

### Primary Key

```java
@Id
@GeneratedValue
```

Defines the primary key and its generation strategy.

---

### Relationships

```java
@OneToMany
@ManyToOne
@ManyToMany
@OneToOne
```

Defines associations between entities.

---

### Relationship Configuration

```java
@JoinColumn
@JoinTable
```

Configures foreign keys and join tables.

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

Configures column properties such as nullability, uniqueness and length.

---

### Lombok

Used to reduce boilerplate code.

```java
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
```

---

### Entity Lifecycle

```java
@PrePersist
@PreUpdate
```

Used to automatically update entity state before persisting or updating records.