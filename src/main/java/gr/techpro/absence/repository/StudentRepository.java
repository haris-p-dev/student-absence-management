package gr.techpro.absence.repository;

import gr.techpro.absence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

}
