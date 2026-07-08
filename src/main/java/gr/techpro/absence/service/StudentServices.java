package gr.techpro.absence.service;

import gr.techpro.absence.dto.request.StudentRequestDTO;
import gr.techpro.absence.dto.response.StudentResponseDTO;
import gr.techpro.absence.entity.StudentEntity;
import gr.techpro.absence.exception.DuplicateResourceException;
import gr.techpro.absence.exception.ResourceNotFoundException;
import gr.techpro.absence.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServices {

    private final StudentRepository stRepository;

    //create new student if not exists
    public StudentResponseDTO createStudent(StudentRequestDTO request) {
        //throws exception if email already exists
        if(stRepository.existsByEmail(request.getEmail())){
            throw new ResourceNotFoundException("A Student with email '"+request.getEmail()+"' already exists");
        }

        if(stRepository.existsByStudentNumber(request.getStudentNumber())){
            throw new DuplicateResourceException("Student number: '"+request.getStudentNumber()+"' belongs to another student");
        }

        //map dto to the relevant Entity
        StudentEntity student = StudentEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .studentNumber(request.getStudentNumber())
                .build();

        //saving the new entity via Repository
        StudentEntity savedStudent = stRepository.save(student);

        return StudentResponseDTO.builder()
                .id(savedStudent.getId())
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .email(savedStudent.getEmail())
                .enrollDate(savedStudent.getEnrollDate())
                .createdDate(savedStudent.getCreatedDate())
                .build();

    }

    //answers to endpoint /api/students/{id}
    public StudentResponseDTO getStudentById(Long id) {

        StudentEntity studentEntity = stRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found"));

        return  StudentResponseDTO.builder()
                .id(studentEntity.getId())
                .firstName(studentEntity.getFirstName())
                .lastName(studentEntity.getLastName())
                .email(studentEntity.getEmail())
                .enrollDate(studentEntity.getEnrollDate())
                .createdDate(studentEntity.getCreatedDate())
                .build();
    }

    //list all students
    public List<StudentResponseDTO> getAllStudents() {

        return stRepository.findAll()
                .stream().map(student->StudentResponseDTO.builder()
                                .id(student.getId())
                                .firstName(student.getFirstName())
                                .lastName(student.getLastName())
                                .studentNumber(student.getStudentNumber())
                                .email(student.getEmail())
                                .build())
                .toList();
    }

    // update a student's info. answers to students/{id}
    public StudentResponseDTO updateInfo(Long id,StudentRequestDTO request){

        StudentEntity studentEntity = stRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id " + id + " was not found."));


        if(stRepository.existByEmail(request.getEmail(), id)){
            throw new DuplicateResourceException("This email is belongs to another student");
        }

        if(stRepository.existByStudentNumber(request.getEmail(), id)){
            throw new DuplicateResourceException("This Student Number is belongs to another student");
        }

        studentEntity.setFirstName(request.getFirstName());
        studentEntity.setLastName(request.getLastName());
        studentEntity.setEmail(request.getEmail());
        studentEntity.setStudentNumber(request.getStudentNumber());

        StudentEntity updated = stRepository.save(studentEntity);

        return StudentResponseDTO.builder()
                .id(updated.getId())
                .firstName(updated.getFirstName())
                .lastName(updated.getLastName())
                .email(updated.getEmail())
                .studentNumber(updated.getStudentNumber())
                .enrollDate(updated.getEnrollDate())
                .createdDate(updated.getCreatedDate())
                .build();
    }

    //delete a student from db
    public void deleteStudent(Long id){
        StudentEntity studentEntity = stRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " was not found."));
        stRepository.delete(studentEntity);
    }





}
