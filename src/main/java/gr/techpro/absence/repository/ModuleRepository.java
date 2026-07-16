package gr.techpro.absence.repository;

import gr.techpro.absence.dto.request.ModuleRequestDTO;
import gr.techpro.absence.entity.ModuleEntity;
import gr.techpro.absence.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ModuleRepository extends JpaRepository<ModuleEntity,Long> {

      boolean existsByCode(String code);
      boolean existsByIdNotAndCode(Long id,String code);

      List<ModuleEntity> findByModuleId(Long sessionId);

      List<SessionEntity> findBySessionId(Long sessionId);

}
