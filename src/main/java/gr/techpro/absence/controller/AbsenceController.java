package gr.techpro.absence.controller;

import gr.techpro.absence.dto.request.AbsenceRequestDTO;
import gr.techpro.absence.dto.response.AbsenceResponseDTO;
import gr.techpro.absence.service.AbsenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AbsenceController {

    private final AbsenceService absenceService;

    @PostMapping("/absences")
    public AbsenceResponseDTO recordAttendance(AbsenceRequestDTO request){
        return absenceService.recordAttendance(request);
    }


    @PatchMapping("/absences/{id}/justify")
    public AbsenceResponseDTO justifyAbsence(@PathVariable Long id, @Valid @RequestParam AbsenceRequestDTO request){
        return absenceService.justifyAbsence(id, request);
    }


    //Retrieves absences from the system.
    @GetMapping("/absences/{id}")
    public AbsenceResponseDTO getAbsence(@PathVariable Long id){
        return   absenceService.getAbsences(id);
    }


    //Supports dynamic filtering by student, module, and/or session via query parameters.
     // If no parameters are provided, it returns all records.

    @GetMapping("/absences")
    public ResponseEntity<List<AbsenceResponseDTO>> getAbsences(  @RequestParam(required = false) Long studentId,
                                                                  @RequestParam(required = false) Long moduleId,
                                                                  @RequestParam(required = false) Long sessionId) {
        List<AbsenceResponseDTO> absences = absenceService.getAbsences(studentId, moduleId, sessionId);
        return ResponseEntity.ok(absences);
    }
}
