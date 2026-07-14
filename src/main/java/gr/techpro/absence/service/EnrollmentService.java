package gr.techpro.absence.service;

import gr.techpro.absence.dto.response.EnrollmentResponseDTO;
import gr.techpro.absence.entity.EnrollmentEntity;
import gr.techpro.absence.entity.ModuleEntity;
import gr.techpro.absence.entity.StudentEntity;
import gr.techpro.absence.enums.EnrollmentStatus;
import gr.techpro.absence.exception.DuplicateResourceException;
import gr.techpro.absence.exception.ResourceNotFoundException;
import gr.techpro.absence.repository.EnrollmentRepository;
import gr.techpro.absence.repository.ModuleRepository;
import gr.techpro.absence.repository.StudentRepository;
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

    public EnrollmentResponseDTO createEnrollment(Long studentId, Long moduleId, EnrollmentStatus status){

        StudentEntity student= studentRepo.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student id "+studentId+" does not exist"));

        ModuleEntity module = moduleRepo.findById(moduleId)
                .orElseThrow(()->new ResourceNotFoundException("Module id "+moduleId+"do not exist"));

        if(enrollmentRepo.existsByStudentIdAndModuleId(studentId,moduleId)){
            throw new DuplicateResourceException("Student is already enrolled in this module");
        }

        EnrollmentEntity completedEntry = new EnrollmentEntity();

        completedEntry.setStudent(student);
        completedEntry.setModule(module);
        completedEntry.setStatus(status);

        EnrollmentEntity updated = enrollmentRepo.save(completedEntry);

        return EnrollmentResponseDTO.from(updated);

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
