package gr.techpro.absence.repository;


import gr.techpro.absence.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SessionRepository extends JpaRepository<SessionEntity,Long> {
}
