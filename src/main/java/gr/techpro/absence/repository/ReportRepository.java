package gr.techpro.absence.repository;

import gr.techpro.absence.dto.response.AttendanceStatisticsDTO;
import gr.techpro.absence.dto.response.ModuleStatsResponseDTO;
import gr.techpro.absence.dto.response.SummaryResponseDTO;
import gr.techpro.absence.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReportRepository extends JpaRepository<EnrollmentEntity, Long> {


     //Returns total report of absences
     // for a specific student who is related to a specific module

    @Query("""
        SELECT new gr.techpro.absence.dto.response.SummaryResponseDTO(
            s.id,
            CONCAT(s.firstName, ' ', s.lastName),
            m.id,
            m.title,
            COUNT(DISTINCT se.id),
            COALESCE(SUM(CASE WHEN a.status = 'PRESENT' THEN 1 ELSE 0 END), 0L),
            COALESCE(SUM(CASE WHEN a.status = 'ABSENT' THEN 1 ELSE 0 END), 0L),
            COALESCE(SUM(CASE WHEN a.status = 'ABSENT' AND a.justified = true THEN 1 ELSE 0 END), 0L)
        )
        FROM EnrollmentEntity e
        JOIN e.student s
        JOIN e.module m
        JOIN SessionEntity se ON se.module.id = m.id
        LEFT JOIN AbsenceEntity a ON a.enrollment.id = e.id AND a.session.id = se.id
        WHERE s.id = :studentId AND m.id = :moduleId
        GROUP BY s.id, s.firstName, s.lastName, m.id, m.title
        """)
    SummaryResponseDTO findStudentModuleSummary(@Param("studentId") Long studentId,@Param("moduleId") Long moduleId);




//   Returns the total sessions and absences per student for a specific module.

    @Query("""
    SELECT new gr.techpro.absence.dto.response.AttendanceStatisticsDTO(
        s.id,
        CONCAT(s.firstName, ' ', s.lastName),
        COUNT(DISTINCT se.id),
        COALESCE(SUM(CASE WHEN a.status = 'ABSENT' THEN 1 ELSE 0 END), 0L)
    )
    FROM EnrollmentEntity e
    JOIN e.student s
    JOIN e.module m
    JOIN SessionEntity se ON se.module.id = m.id
    LEFT JOIN AbsenceEntity a ON a.enrollment.id = e.id AND a.session.id = se.id
    WHERE m.id = :moduleId
    GROUP BY s.id, s.firstName, s.lastName
    """)
    List<AttendanceStatisticsDTO> findAttendanceStatisticsByModule(@Param("moduleId") Long moduleId);



    //Returns total absence statistics for a specific module.

    @Query("""
    SELECT new gr.techpro.absence.dto.response.ModuleStatsResponseDTO(
        m.id,
        m.title,
        COUNT(DISTINCT e.student.id),
        COUNT(DISTINCT se.id),
        COALESCE(SUM(CASE WHEN a.status = 'ABSENT' THEN 1 ELSE 0 END), 0L),
        COALESCE(SUM(CASE WHEN a.status = 'ABSENT' AND a.justified = true THEN 1 ELSE 0 END), 0L),
        0.0
    )
    FROM ModuleEntity m
    LEFT JOIN EnrollmentEntity e ON e.module.id = m.id
    LEFT JOIN SessionEntity se ON se.module.id = m.id
    LEFT JOIN AbsenceEntity a ON a.session.id = se.id
    WHERE m.id = :moduleId
    GROUP BY m.id, m.title
    """)
    ModuleStatsResponseDTO findModuleStats(@Param("moduleId") Long moduleId);
}

