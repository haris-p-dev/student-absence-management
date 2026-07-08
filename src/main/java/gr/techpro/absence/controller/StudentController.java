package gr.techpro.absence.controller;


import gr.techpro.absence.dto.request.StudentRequestDTO;
import gr.techpro.absence.dto.response.StudentResponseDTO;
import gr.techpro.absence.service.StudentServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServices studentServices;


    @PostMapping("/students")
    public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO requestDTO){
        return studentServices.createStudent(requestDTO);
    }

    @GetMapping("/students/{id}")
    public StudentResponseDTO getById(@PathVariable Long id){
        return studentServices.getStudentById(id);
    }

    @GetMapping("/students")
    public List<StudentResponseDTO> getAllStudents(){
        return studentServices.getAllStudents();
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentServices.deleteStudent(id);
    }


}
