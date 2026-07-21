package gr.techpro.absence.controller;

import gr.techpro.absence.dto.request.InstructorRequestDTO;
import gr.techpro.absence.dto.response.InstructorResponseDTO;
import gr.techpro.absence.service.InstructorServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InstructorController {


    private final InstructorServices instructorServices;


    @PostMapping("/instructors")
    public InstructorResponseDTO createInstructor(@Valid @RequestBody InstructorRequestDTO request) {
        return instructorServices.createInstructor(request);
    }

    @GetMapping("/instructors/{instructorId}")
    public InstructorResponseDTO getById(@PathVariable Long instructorId) {
        return instructorServices.getInstructorById(instructorId);
    }

    @GetMapping("/instructors")
    public List<InstructorResponseDTO> getAllInstructors() {
        return instructorServices.getAllInstructors();
    }

    @DeleteMapping("/instructors/{instructorId}")
    public void deleteInstructor(@PathVariable Long instructorId) {
        instructorServices.deleteInstructor(instructorId);
    }

    @PutMapping("/instructors/{instructorId}")
    public InstructorResponseDTO updateInstructor(@PathVariable Long instructorId, @Valid @RequestBody InstructorRequestDTO request) {
        return instructorServices.updateInstructor(instructorId, request);
    }


}
