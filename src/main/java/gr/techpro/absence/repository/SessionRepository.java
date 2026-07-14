package gr.techpro.absence.repository;


import gr.techpro.absence.dto.request.ModuleRequestDTO;
import gr.techpro.absence.entity.ModuleInstructorEntity;
import gr.techpro.absence.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SessionRepository extends JpaRepository<SessionEntity,Long> {

    boolean findBySession();

    List<SessionEntity> findBySessionId(Long sessionId);

}
