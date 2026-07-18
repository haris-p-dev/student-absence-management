package gr.techpro.absence.repository;

import gr.techpro.absence.entity.StudentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    boolean existsByEmail(String email);

    boolean existsByStudentNumber(String studentNumber);

    boolean existsByIdNotAndEmail(Long id,String email);

    boolean existsByIdNotAndStudentNumber(Long id,String studentNumber);
}