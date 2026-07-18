package gr.techpro.absence.repository;


import gr.techpro.absence.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EnrollmentRepository extends JpaRepository <EnrollmentEntity,Long>{

    boolean existsByStudentIdAndModuleId(Long student, Long module);

    List<EnrollmentEntity> findByStudentId(Long studentId);

}
