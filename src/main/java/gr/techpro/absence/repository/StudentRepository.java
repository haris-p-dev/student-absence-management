package gr.techpro.absence.repository;

import gr.techpro.absence.entity.StudentEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(Long id,String email);

    boolean existsByStudentNumber(String studentNumber);

    boolean existsByStudentNumberAndIdNot(Long id,String email);
}