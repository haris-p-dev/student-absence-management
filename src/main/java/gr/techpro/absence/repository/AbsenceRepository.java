package gr.techpro.absence.repository;

import gr.techpro.absence.entity.AbsenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<AbsenceEntity,Long> {

    boolean existsByEnrollmentIdAndSessionId(Long enrollmentId, Long sessionId);


    @Query("SELECT a FROM AbsenceEntity a " +
            "WHERE (:studentId IS NULL OR a.enrollment.student.id = :studentId) " +
            "AND (:moduleId IS NULL OR a.enrollment.module.id = :moduleId) " +
            "AND (:sessionId IS NULL OR a.session.id = :sessionId)")
    List<AbsenceEntity> findWithFilters(
            @Param("studentId") Long studentId,
            @Param("moduleId") Long moduleId,
            @Param("sessionId") Long sessionId
    );

}
