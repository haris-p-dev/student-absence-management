package gr.techpro.absence.service;


import gr.techpro.absence.dto.request.SessionRequestDTO;
import gr.techpro.absence.dto.response.SessionResponseDTO;
import gr.techpro.absence.entity.ModuleEntity;
import gr.techpro.absence.entity.SessionEntity;
import gr.techpro.absence.exception.InvalidRequestException;
import gr.techpro.absence.exception.ResourceNotFoundException;
import gr.techpro.absence.repository.ModuleRepository;
import gr.techpro.absence.repository.SessionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SessionService {

    private final SessionRepository sessionRepo;
    private final ModuleRepository moduleRepo;


    public SessionResponseDTO createSession(Long moduleId, SessionRequestDTO request) {

        ModuleEntity module = moduleRepo.findById(moduleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Module with id '" + moduleId + "' cannot be found."));

        if (request.getStartTime() != null
                && request.getEndTime() != null
                && !request.getEndTime().isAfter(request.getStartTime())) {

            throw new IllegalArgumentException(
                    "End time must be after start time.");
        }

        SessionEntity session = SessionEntity.builder()
                .module(module)
                .sessionDate(request.getSessionDate())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .sessionType(request.getSessionType())
                .topic(request.getTopic())
                .build();

        SessionEntity saved = sessionRepo.save(session);

        return SessionResponseDTO.from(saved);
    }
    public List<SessionResponseDTO> listAllSessions(Long moduleId){

        moduleRepo.findById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Module not found with id: " + moduleId));


        List<SessionEntity> relationships = sessionRepo.findBySessionId(moduleId);


        if (relationships.isEmpty()) {
            throw new ResourceNotFoundException(
                    "There are no listed sessions for this module.");
        }

        return relationships.stream()
                .map(entity -> SessionResponseDTO.from(entity))
                .toList();

    }
    public List<SessionResponseDTO> getSessionsForModuleBetweenDates(Long moduleId,LocalDate from,LocalDate to) {

        if (from.isAfter(to)) {
            throw new InvalidRequestException(
                    "'from' date cannot be after 'to' date.");
        }

        if (!moduleRepo.existsById(moduleId)) {
            throw new ResourceNotFoundException(
                    "Module with id '" + moduleId + "' cannot be found.");
        }

        return sessionRepo
                .findByModuleIdAndSessionDateBetween(moduleId, from, to)
                .stream()
                .map(entity -> SessionResponseDTO.from(entity))
                .toList();
    }


}
