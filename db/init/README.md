# Database Initialization

This package contains the SQL scripts used to initialize the PostgreSQL database when the Docker container is created.

The initialization process is executed automatically by Docker in the following order:

1. `schema.sql`
2. `seed.sql`

---

## Files

### schema.sql

Creates the complete database schema, including:

- Tables
- Primary keys
- Foreign keys
- Constraints
- Indexes
- Default values

This script defines the database structure required by the application.

---

### seed.sql

Populates the database with sample data after the schema has been created.

The seeded records are provided as example data to:

- Demonstrate the application's functionality.
- Simplify development and testing.
- Allow the API to be used immediately after deployment without manually inserting records.

---

## Execution

Both scripts are executed automatically during the PostgreSQL container initialization.

The Docker configuration ensures that:

1. The database schema is created first.
2. Sample data is inserted only after the schema has been successfully created.

As a result, a fresh database is fully initialized and ready to use immediately after the Docker containers start.