package gr.techpro.absence.service;

import gr.techpro.absence.dto.response.EnrollmentResponseDTO;
import gr.techpro.absence.entity.StudentEntity;
import gr.techpro.absence.repository.EnrollmentRepository;
import gr.techpro.absence.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepo;

    public EnrollmentResponseDTO createRelation(Long studentId, Long moduleId){



    }

}
