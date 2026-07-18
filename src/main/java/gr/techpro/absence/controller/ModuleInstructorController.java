package gr.techpro.absence.controller;


import gr.techpro.absence.dto.response.ModuleInstructorResponseDTO;
import gr.techpro.absence.enums.InstructorRole;
import gr.techpro.absence.service.ModuleInstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ModuleInstructorController {

    private final ModuleInstructorService modInsService;

    @PostMapping("/modules/{moduleId}/instructors/{instructorId}")
    public ModuleInstructorResponseDTO assignInstructorToModule( @PathVariable Long moduleId,
                                                                @PathVariable Long instructorId,
                                                                @RequestParam InstructorRole role) {
        return modInsService.assignInstructorToModule(instructorId, moduleId, role);
    }

    @DeleteMapping("/modules/{moduleId}/instructors/{instructorId}")
    public String removeRelationship( @PathVariable Long moduleId, @PathVariable Long instructorId) {

        return modInsService.removeRelationship(instructorId, moduleId);
    }

    @GetMapping("/modules/{moduleId}/instructors")
    public List<ModuleInstructorResponseDTO> getInstructorsOfModule( @PathVariable Long moduleId) {
        return modInsService.getInstructorsOfSameModule(moduleId);
    }

    @GetMapping("/instructors/{instructorId}/modules")
    public List<ModuleInstructorResponseDTO> getModulesOfInstructor( @PathVariable Long instructorId) {
        return modInsService.getModulesOfInstructor(instructorId);
    }



}
