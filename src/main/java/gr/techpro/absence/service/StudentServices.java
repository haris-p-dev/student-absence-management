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

    private final StudentRepository studentRepo;

    //create new student if not already exists
    public StudentResponseDTO createStudent(StudentRequestDTO request) {

        //throws exception if email already exists
        if(studentRepo.existsByEmail(request.getEmail())){
            throw new ResourceNotFoundException("A Student with email '"+request.getEmail()+"' already exists");
        }

        if(studentRepo.existsByStudentNumber(request.getStudentNumber())){
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
        StudentEntity updated= studentRepo.save(student);

        return  StudentResponseDTO.from(updated);

    }

    //answers to endpoint /api/students/{id}
    public StudentResponseDTO getStudentById(Long id) {

        StudentEntity studentEntity = studentRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id " + id + " was not found."));

        return  StudentResponseDTO.from(studentEntity);

    }

    //list all students
    public List<StudentResponseDTO> getAllStudents() {

        return studentRepo.findAll()
                .stream()
                .map(student -> StudentResponseDTO.from(student))
                .toList();
    }

    // update a student's info. answers to students/{id}
    public StudentResponseDTO updateStudent(Long id,StudentRequestDTO request){

        StudentEntity studentEntity = studentRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id " + id + " cannot be found."));

//  id does not exist by mail does exist.
        if(studentRepo.existsByIdNotAndEmail(id,request.getEmail())){
            throw new DuplicateResourceException("This email is belongs to another student");
        }


        if(studentRepo.existsByIdNotAndStudentNumber(id,request.getStudentNumber())){
            throw new DuplicateResourceException("This Student Number belongs to another student");
        }

        studentEntity.setFirstName(request.getFirstName());
        studentEntity.setLastName(request.getLastName());
        studentEntity.setEmail(request.getEmail());
        studentEntity.setStudentNumber(request.getStudentNumber());

        StudentEntity updated = studentRepo.save(studentEntity);

        return  StudentResponseDTO.from(updated);
    }

    //delete a student from db
    public void deleteStudent(Long id){
        StudentEntity studentEntity = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " cannot be found."));
        studentRepo.delete(studentEntity);
    }





}
