package gr.techpro.absence.repository;


import gr.techpro.absence.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnrollmentRepository extends JpaRepository <EnrollmentEntity,Long>{


}
