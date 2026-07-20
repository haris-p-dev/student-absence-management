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


---

## Available Entities

### StudentEntity

Represents the student table in the database.

---

### ModuleEntity

Represents the module table in the database.

---

### EnrollmentEntity

Represents the relationship between students and modules.

---

### SessionEntity

Represents module sessions.

---

### AbsenceEntity

Represents student absence records.

---

### InstructorEntity

Represents instructor data.

---

### ModuleInstructorEntity

Represents the relationship between instructors and modules.

---

## JPA Annotations Used

The entities use JPA annotations for object-relational mapping.

### Entity Mapping

```java
@Entity
@Table

Used to define a class as a database entity and map it to a database table.

Primary Key
@Id
@GeneratedValue

Used for defining entity identifiers and automatic ID generation.

Relationships

Used for defining associations between entities:

@OneToMany
@ManyToOne
@ManyToMany
@OneToOne
Relationship Configuration
@JoinColumn
@JoinTable

Used to configure foreign keys and join tables.

Enum Mapping
@Enumerated(EnumType.STRING)

Used to store enum values as readable strings in the database.

Constraints
@Column

Used for column configuration such as:

nullable constraints
uniqueness
column definitions
Lombok

Used to reduce boilerplate code.

Common annotations:

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor