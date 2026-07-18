package gr.techpro.absence.repository;


import gr.techpro.absence.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface SessionRepository extends JpaRepository<SessionEntity,Long> {

    List<SessionEntity> findByModuleIdAndSessionDateBetween(Long moduleId, LocalDate from, LocalDate to);
    List<SessionEntity> findByModuleId(Long moduleId);
}
