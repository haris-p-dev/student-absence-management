package gr.techpro.absence.controller;


import gr.techpro.absence.dto.request.StudentRequestDTO;
import gr.techpro.absence.dto.response.StudentResponseDTO;
import gr.techpro.absence.service.StudentServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServices studentServices;
    private final StudentRequestDTO studentRequestDTO;

    @PostMapping("/students") {
    }

    @GetMapping("/students/{id}"){}

    @GetMapping("/students ")


    }
}
