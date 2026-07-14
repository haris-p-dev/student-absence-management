package gr.techpro.absence.repository;

import gr.techpro.absence.entity.ModuleInstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ModuleInstructorRepository extends JpaRepository<ModuleInstructorEntity,Long> {

    boolean existsByModuleIdAndInstructorId(Long module, Long instructor);

    Optional<ModuleInstructorEntity>
            findByInstructorIdAndModuleId(Long instructorId, Long moduleId);

    List<ModuleInstructorEntity> findByInstructorId(Long instructorId);

    List<ModuleInstructorEntity> findByModuleId(Long moduleId);

}
