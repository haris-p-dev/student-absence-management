package gr.techpro.absence.service;


import gr.techpro.absence.dto.request.SessionRequestDTO;
import gr.techpro.absence.dto.response.ModuleInstructorResponseDTO;
import gr.techpro.absence.dto.response.SessionResponseDTO;
import gr.techpro.absence.entity.ModuleEntity;
import gr.techpro.absence.entity.SessionEntity;
import gr.techpro.absence.exception.ResourceNotFoundException;
import gr.techpro.absence.repository.ModuleRepository;
import gr.techpro.absence.repository.SessionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SessionService {

    private final SessionRepository sessionRepo;
    private final ModuleRepository moduleRepo;

    public SessionResponseDTO addModuleToSession(Long moduleId,SessionRequestDTO request){

        ModuleEntity moduleEntity = moduleRepo.findById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Module not found with id: " + moduleId));


        var start = request.getStartTime();
        var end = request.getEndTime();

        if (start != null && end != null && !end.isAfter(start) ) {
            throw new IllegalArgumentException("End time must be after start time");
        }


        SessionEntity sessionEntity = SessionEntity.builder()
                .sessionDate(request.getSessionDate())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .sessionType(request.getSessionType())
                .topic(request.getTopic())
                .build();


        SessionEntity updated = sessionRepo.save(sessionEntity);

        return SessionResponseDTO.from(updated);

    }


    public List<SessionResponseDTO> listAllSessions(Long moduleId) {

        moduleRepo.findById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no listed sessions for this module "));

        List<SessionEntity> relationships = sessionRepo.findBySessionId(moduleId);

        if (relationships.isEmpty()) {
            throw new ResourceNotFoundException(
                    "There is no listed sessions for this module.");

            return relationships.stream()
                    .map(entity -> SessionResponseDTO.from(entity))
                    .toList();
        }
    }
    }







}
