package gr.techpro.absence.validators;

import gr.techpro.absence.entity.EnrollmentEntity;
import gr.techpro.absence.entity.SessionEntity;
import gr.techpro.absence.enums.EnrollmentStatus;
import gr.techpro.absence.repository.AbsenceRepository;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AbsenceValidator {


    private final AbsenceRepository absenceRepo;

    // Runs all business validations before recording attendance.

    public void validate(EnrollmentEntity enrollment,SessionEntity session ) {

        validateEnrollmentIsActive(enrollment);
        validateEnrollmentBelongsToSessionModule(enrollment,session);
        validateDuplicateAbsence(enrollment,session);
    }

    // Checks if the enrollment is active.

    private void validateEnrollmentIsActive(EnrollmentEntity enrollment) {

        if (enrollment.getStatus() != EnrollmentStatus.ACTIVE) {
            throw new ValidationException(
                    "Attendance can only be recorded for ACTIVE enrollments."
            );
        }
    }


    //  Checks if enrollment and session belong to the same module.

    private void validateEnrollmentBelongsToSessionModule(EnrollmentEntity enrollment,SessionEntity session) {

        if (!enrollment.getModule().getId()
                .equals(session.getModule().getId())) {
            throw new ValidationException(
                    "Enrollment does not belong to the session module.");
        }
    }


     // Ensures an attendance record does not already exist.

    private void validateDuplicateAbsence( EnrollmentEntity enrollment,SessionEntity session) {
        if (absenceRepo.existsByEnrollmentIdAndSessionId(
                enrollment.getId(),session.getId())) {
            throw new ValidationException(
                    "An absence record already exists for this enrollment and session.");
        }
    }
}