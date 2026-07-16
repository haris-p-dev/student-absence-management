package gr.techpro.absence.service;

import gr.techpro.absence.dto.request.AbsenceRequestDTO;
import gr.techpro.absence.dto.response.AbsenceResponseDTO;
import gr.techpro.absence.entity.AbsenceEntity;
import gr.techpro.absence.entity.EnrollmentEntity;
import gr.techpro.absence.entity.SessionEntity;
import gr.techpro.absence.entity.StudentEntity;
import gr.techpro.absence.enums.AbsenceStatus;
import gr.techpro.absence.exception.ResourceNotFoundException;
import gr.techpro.absence.extra_validation.AbsenceValidator;
import gr.techpro.absence.repository.AbsenceRepository;
import gr.techpro.absence.repository.EnrollmentRepository;
import gr.techpro.absence.repository.SessionRepository;
import gr.techpro.absence.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class AbsenceService {

    private final AbsenceRepository absenceRepo;
    private final EnrollmentRepository enrollmentRepo;
    private final SessionRepository sessionRepo;
    private final StudentRepository studentRepo;

    //validator must be init/zed here for proper constructor injection
    private final AbsenceValidator absenceValidator;


    public AbsenceResponseDTO recordAttendance(AbsenceRequestDTO request){


        EnrollmentEntity enrollment = enrollmentRepo.findById(request.getEnrollmentId())
                .orElseThrow(()->new ResourceNotFoundException("This id does NOT match an enrollment"));

        SessionEntity session = sessionRepo.findById(request.getSessionId())
                .orElseThrow(()->new ResourceNotFoundException("This id does NOT match a session"));



        absenceValidator.validate(enrollment,session);

        AbsenceEntity entry = AbsenceEntity.builder()
                .enrollment(enrollment)
                .session(session)
                .status(request.getStatus())
                .justified(false)
                .recordedAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        AbsenceEntity updated = absenceRepo.save(entry);

        return AbsenceResponseDTO.from(updated);

    }

    public AbsenceResponseDTO getAbsences(Long id){


        AbsenceEntity absence = absenceRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Absence not found with id: " + id ));

        return AbsenceResponseDTO.from(absence);    }


   //Changes the state of an absence (justify / unjustify)

    public AbsenceResponseDTO justifyAbsence(Long id,AbsenceRequestDTO request) {

        AbsenceEntity absence = absenceRepo.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException(
                        "Absence not found" ));

        absence.setJustified(request.isJustified());
        absence.setJustification(request.getJustification());

        absence.setUpdatedAt(LocalDateTime.now());

        AbsenceEntity updatedAbsence =absenceRepo.save(absence);

        return AbsenceResponseDTO.from(updatedAbsence);
    }


    public List<AbsenceResponseDTO> getAbsences(Long studentId,Long moduleId,Long sessionId) {

        List<AbsenceEntity> absences =absenceRepo.findWithFilters(studentId,moduleId,sessionId);

        return absences.stream()
                .map(entity ->AbsenceResponseDTO.from(entity))
                .toList();
    }



}
