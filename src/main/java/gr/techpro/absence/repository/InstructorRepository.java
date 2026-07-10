package gr.techpro.absence.repository;

import gr.techpro.absence.entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<InstructorEntity,Long> {

    boolean existsByEmailAndIdNot(Long id,String email);
    boolean existsByEmail(String email);
}
