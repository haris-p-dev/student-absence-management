package gr.techpro.absence.service;

import gr.techpro.absence.dto.request.StudentRequestDTO;
import gr.techpro.absence.dto.response.StudentResponseDTO;
import gr.techpro.absence.entity.StudentEntity;
import gr.techpro.absence.exception.ResourceNotFoundException;
import gr.techpro.absence.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServices {

    private final StudentRepository studentRepository;


    public StudentResponseDTO createStudent(StudentRequestDTO request) {

        if(studentRepository.existsByEmail(request.getEmail())){
            throw new ResourceNotFoundException("A Student with email ' "+request.getEmail()+" already exists");
        }

        //map dto to the relevant Entity
        StudentEntity student = StudentEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .studentNumber(request.getStudentNumber())
                .build();

        //saving the new entity via Repository
        StudentEntity savedStudent = studentRepository.save(student);

        return StudentResponseDTO.builder()
                .id(savedStudent.getId())
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .email(savedStudent.getEmail())
                .enrollDate(savedStudent.getEnrollDate())
                .createdDate(savedStudent.getCreatedDate())
                .build();

    }
    public StudentResponseDTO getStudentById(Long id) {

        //exception for duplicates and for non existed student to be implemented.
        StudentEntity studentEntity = studentRepository.findById(id)
    //wrong syntax here
        .orElseThrow(ResourceNotFoundException("There is already a student with id "+id));

        return  StudentResponseDTO.builder()
                .id(studentEntity.getId())
                .firstName(studentEntity.getFirstName())
                .lastName(studentEntity.getLastName())
                .email(studentEntity.getEmail())
                .enrollDate(studentEntity.getEnrollDate())
                .createdDate(studentEntity.getCreatedDate())
                .build();
    }




}
