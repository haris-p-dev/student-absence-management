package gr.techpro.absence.repository;

import gr.techpro.absence.entity.StudentEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);

    boolean existsByStudentNumber(String studentNumber);

    boolean existsByStudentNumberAndIdNot(String studentNumber, Long id);
}