package gr.techpro.absence.service;

import gr.techpro.absence.dto.request.EnrollmentRequestDTO;
import gr.techpro.absence.dto.response.EnrollmentResponseDTO;
import gr.techpro.absence.entity.EnrollmentEntity;
import gr.techpro.absence.entity.ModuleEntity;
import gr.techpro.absence.entity.StudentEntity;
import gr.techpro.absence.exception.DuplicateResourceException;
import gr.techpro.absence.exception.ResourceNotFoundException;
import gr.techpro.absence.repository.EnrollmentRepository;
import gr.techpro.absence.repository.ModuleRepository;
import gr.techpro.absence.repository.StudentRepository;
import gr.techpro.absence.validators.EnrollmentValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Transactional
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepo;
    private final StudentRepository studentRepo;
    private final ModuleRepository moduleRepo;

    private final EnrollmentValidator validator;


    public EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO request){

        StudentEntity student = studentRepo.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student with id '" + request.getStudentId() + "' cannot be found."));

        ModuleEntity module = moduleRepo.findById(request.getModuleId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Module with id '" + request.getModuleId() + "' cannot be found."));

        if (enrollmentRepo.existsByStudentIdAndModuleId(
                request.getStudentId(),
                request.getModuleId())) {

            throw new DuplicateResourceException(
                    "Student is already enrolled in this module.");
        }

        validator.validateNoScheduleConflict(student.getId(),module.getId());

        EnrollmentEntity enrollment = new EnrollmentEntity();

        enrollment.setStudent(student);
        enrollment.setModule(module);
        enrollment.setStatus(request.getStatus());

        EnrollmentEntity saved = enrollmentRepo.save(enrollment);

        return EnrollmentResponseDTO.from(saved);
    }


    public EnrollmentResponseDTO getEnrollmentById(Long id){

        EnrollmentEntity enrollmentEntity= enrollmentRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Enrollment linked with id "+id+" does not exist"));

        return EnrollmentResponseDTO.from(enrollmentEntity);
    }

    public void deleteEnrollment(Long id){

        EnrollmentEntity enrollmentEntity = enrollmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrolment with id " + id + " cannot be found."));
        enrollmentRepo.delete(enrollmentEntity);
    }

}
