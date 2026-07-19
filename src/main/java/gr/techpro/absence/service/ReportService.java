package gr.techpro.absence.service;

import gr.techpro.absence.dto.response.AtRiskStudentResponseDTO;
import gr.techpro.absence.dto.response.ModuleStatsResponseDTO;
import gr.techpro.absence.dto.response.SummaryResponseDTO;
import gr.techpro.absence.exception.ResourceNotFoundException;
import gr.techpro.absence.extra_validators.ReportValidator;
import gr.techpro.absence.repository.EnrollmentRepository;
import gr.techpro.absence.repository.ModuleRepository;
import gr.techpro.absence.repository.ReportRepository;
import gr.techpro.absence.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class ReportService {

    private final ReportRepository reportRepo;
    private final EnrollmentRepository enrollmentRepo;
    private final ReportValidator validator;

    @Value("${absence.threshold:33}")
    private double defaultThreshold;


    public SummaryResponseDTO getStudentModuleSummary(Long studentId, Long moduleId) {

        validator.validateStudentExists(studentId);
        validator.validateModuleExists(moduleId);

            if (!enrollmentRepo.existsByStudentIdAndModuleId(studentId, moduleId)) {
                throw new ResourceNotFoundException("Student is not enrolled in the specified module.");
            }

            //JSQL does the job here
            return reportRepo.findStudentModuleSummary(studentId,moduleId);
    }



    // Returns all students who exceed the allowed absence percentage threshold.

    public List<AtRiskStudentResponseDTO> getAtRiskStudents(Long moduleId, Double threshold) {
        validator.validateModuleExists(moduleId);

        double limit = threshold != null ? threshold : defaultThreshold;

        return reportRepo.findAttendanceStatisticsByModule(moduleId).stream()
                .map(stat -> {
                    double absencePercentage = stat.getTotalSessions() == 0
                            ? 0 : (stat.getAbsences() * 100.0) / stat.getTotalSessions();

                    return new AtRiskStudentResponseDTO(
                            stat.getStudentId(),
                            stat.getStudentName(),
                            stat.getTotalSessions(),
                            stat.getAbsences(),
                            absencePercentage
                    );
                })
                .filter(student -> student.getAbsencePercentage() >= limit)
                .toList();
    }

    /**
     * Returns total statistics for a specific module.
     */
    public ModuleStatsResponseDTO getModuleStats(Long moduleId) {
        validator.validateModuleExists(moduleId);

        ModuleStatsResponseDTO stats = reportRepo.findModuleStats(moduleId);
        double percentage = 0;

        if (stats.getTotalSessions() > 0) {
            percentage = (stats.getTotalAbsences() * 100.0) / (stats.getTotalSessions() * stats.getTotalStudents());
        }

        return new ModuleStatsResponseDTO(
                stats.getModuleId(),
                stats.getModuleTitle(),
                stats.getTotalStudents(),
                stats.getTotalSessions(),
                stats.getTotalAbsences(),
                stats.getTotalJustifiedAbsences(),
                percentage);
    }


}

