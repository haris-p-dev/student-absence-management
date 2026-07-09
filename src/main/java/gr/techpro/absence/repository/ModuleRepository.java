package gr.techpro.absence.repository;

import gr.techpro.absence.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModuleRepository extends JpaRepository<ModuleEntity,Long> {

      boolean existsByCode(String code);
//
//    boolean existsByEmailAndIdNot(String email, Long id);
//
//    boolean existsByStudentNumber(String studentNumber);
//
//    boolean existsByStudentNumberAndIdNot(String studentNumber, Long id);

}
