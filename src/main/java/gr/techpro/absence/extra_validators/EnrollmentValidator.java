package gr.techpro.absence.extra_validators;

import gr.techpro.absence.entity.EnrollmentEntity;
import gr.techpro.absence.entity.SessionEntity;
import gr.techpro.absence.repository.EnrollmentRepository;
import gr.techpro.absence.repository.SessionRepository;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EnrollmentValidator {

    private final EnrollmentRepository enrollmentRepo;
    private final SessionRepository sessionRepo;


    //  Validates if the student has any schedule conflicts before enrolling in a new module.

    public void validateNoScheduleConflict(Long studentId, Long newModuleId) {

        List<SessionEntity> newModuleSessions = sessionRepo.findByModuleId(newModuleId);
        List<EnrollmentEntity> existingEnrollments = enrollmentRepo.findByStudentId(studentId);

        // 3. Συγκρίνουμε κάθε νέα συνεδρία με όλες τις υπάρχουσες συνεδρίες των άλλων μαθημάτων
        for (EnrollmentEntity existingEnrollment : existingEnrollments) {
            List<SessionEntity> existingSessions = sessionRepo.findByModuleId(
                    existingEnrollment.getModule().getId()
            );

            for (SessionEntity newSession : newModuleSessions) {
                for (SessionEntity existingSession : existingSessions) {
                    if (hasTimeOverlap(existingSession, newSession)) {
                        throw new ValidationException(
                                "Cannot enroll. Schedule conflict detected between module "
                                        + existingEnrollment.getModule().getCode() + " and the new module."
                        );
                    }
                }
            }
        }
    }

    private boolean hasTimeOverlap(SessionEntity existingSession, SessionEntity newSession) {
        return existingSession.getSessionDate().equals(newSession.getSessionDate())
                &&
                existingSession.getStartTime().isBefore(newSession.getEndTime())
                &&
                existingSession.getEndTime().isAfter(newSession.getStartTime());
    }
}
