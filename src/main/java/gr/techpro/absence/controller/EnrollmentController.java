package gr.techpro.absence.controller;


import gr.techpro.absence.dto.request.EnrollmentRequestDTO;
import gr.techpro.absence.dto.response.EnrollmentResponseDTO;
import gr.techpro.absence.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping("/enrollments")
    public EnrollmentResponseDTO createEnrollment( @Valid @RequestBody EnrollmentRequestDTO request) {
        return enrollmentService.createEnrollment(request);
    }


    @GetMapping("/enrollments/{enrollmentId}")
    public EnrollmentResponseDTO getEnrollment(@PathVariable Long enrollmentId){

        return  enrollmentService.getEnrollmentById(enrollmentId);
    }

    @DeleteMapping("/enrollments/{enrollmentId}")
    public void deleteEnrollment(@PathVariable Long enrollmentId){

        enrollmentService.deleteEnrollment(enrollmentId);
    }}
