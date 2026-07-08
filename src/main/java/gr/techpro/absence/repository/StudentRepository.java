package gr.techpro.absence.repository;

import gr.techpro.absence.entity.StudentEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    boolean existsByEmail(@NotBlank @Email @Size(max=255) String email);
    boolean existsByStudentNumber(@NotBlank @Size(max=20) String stNumber);

    boolean existByEmail(@NotBlank @Email @Size(max=255) String email, Long id);
    boolean existByStudentNumber(@NotBlank @Size(max=20) String stNumber, Long id);
}
