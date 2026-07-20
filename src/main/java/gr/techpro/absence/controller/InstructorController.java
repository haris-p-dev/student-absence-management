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

    @GetMapping("/instructors/{id}")
    public InstructorResponseDTO getById(@PathVariable Long id) {
        return instructorServices.getInstructorById(id);
    }

    @GetMapping("/instructors")
    public List<InstructorResponseDTO> getAllInstructors() {
        return instructorServices.getAllInstructors();
    }

    @DeleteMapping("/instructors/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorServices.deleteInstructor(id);
    }

    @PutMapping("/instructors/{id}")
    public InstructorResponseDTO updateInstructor(@PathVariable Long id, @Valid @RequestBody InstructorRequestDTO request) {
        return instructorServices.updateInstructor(id, request);
    }


}
