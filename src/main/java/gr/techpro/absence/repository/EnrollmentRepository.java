package gr.techpro.absence.repository;


import gr.techpro.absence.entity.EnrollmentEntity;
import gr.techpro.absence.entity.ModuleInstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface EnrollmentRepository extends JpaRepository <EnrollmentEntity,Long>{

    boolean existsByStudentIdAndModuleId(Long student, Long module);

}
