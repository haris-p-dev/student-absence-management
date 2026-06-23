package gr.techpro.absence.repository;

import gr.techpro.absence.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModuleRepository extends JpaRepository<ModuleEntity,Long> {

}
