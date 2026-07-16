package gr.techpro.absence.controller;


import gr.techpro.absence.dto.request.SessionRequestDTO;
import gr.techpro.absence.dto.response.SessionResponseDTO;
import gr.techpro.absence.service.SessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;


    @PostMapping("/modules/{moduleId}/sessions")
    public SessionResponseDTO createSession(@PathVariable Long moduleId,  @Valid @RequestBody SessionRequestDTO request ) {
        return sessionService.createSession(moduleId, request);
    }


    @GetMapping("/modules/{moduleId}/sessions")
    public List<SessionResponseDTO> getSessions(
            @PathVariable Long moduleId,
            @RequestParam(required = false) LocalDate from,
            @RequestParam(required = false) LocalDate to) {

        if (from != null && to != null) {
            return sessionService.getSessionsForModuleBetweenDates(moduleId, from, to);
        }

        return sessionService.listAllSessions(moduleId);
    }

}
