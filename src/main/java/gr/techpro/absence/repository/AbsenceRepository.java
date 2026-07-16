package gr.techpro.absence.repository;

import gr.techpro.absence.entity.AbsenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<AbsenceEntity,Long> {
    boolean existsByEnrollmentIdAndSessionId(Long enrollmentId, Long sessionId);

    List<AbsenceEntity> findWithFilters(Long studentId, Long moduleId, Long sessionId);
}
