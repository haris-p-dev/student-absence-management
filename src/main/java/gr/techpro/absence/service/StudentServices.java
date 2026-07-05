package gr.techpro.absence.service;

import gr.techpro.absence.dto.request.StudentRequestDTO;
import gr.techpro.absence.dto.response.StudentResponseDTO;
import gr.techpro.absence.entity.StudentEntity;
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


        // missing exception handling

        // 1. Δημιουργία και αντιστοίχιση των δεδομένων στο Entity
        StudentEntity student = new StudentEntity();

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setStudentNumber(request.getStudentNumber());

        // 2. Αποθήκευση στη βάση μέσω του Repository
        StudentEntity savedStudent = studentRepository.save(student);

        return StudentResponseDTO.builder()
                .id(savedStudent.getId())
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .email(savedStudent.getEmail())
                .studentNumber(savedStudent.getStudentNumber())
                .enrollDate(savedStudent.getEnrollDate())
                .createdDate(savedStudent.getCreatedDate())
                .build();
    }

    public StudentResponseDTO getStudentById(Long id) {

        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow();


    }




}
