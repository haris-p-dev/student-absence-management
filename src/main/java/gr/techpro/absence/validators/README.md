# Validators

This package contains the custom validators used to enforce business validation rules before data is persisted or processed.

Validators centralize validation logic that cannot be expressed using standard Bean Validation annotations, helping keep the service layer clean and reusable.

Validation is performed before executing business operations. If a validation rule is violated, an appropriate exception is thrown and handled by the global exception handler.

---

## Available Validators

### AbsenceValidator

Validates business rules related to absence records.

---

### EnrollmentValidator

Validates business rules related to student enrollments.

---

### ReportValidator

Validates request parameters used by reporting endpoints.

---

## Purpose

The validator layer is responsible for:

- Centralizing business validations.
- Reusing validation logic across services.
- Keeping service classes focused on business operations.
- Throwing meaningful exceptions when validation fails.