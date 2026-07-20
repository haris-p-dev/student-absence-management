package gr.techpro.absence.controller;

import gr.techpro.absence.dto.response.AtRiskStudentResponseDTO;
import gr.techpro.absence.dto.response.ModuleStatsResponseDTO;
import gr.techpro.absence.dto.response.SummaryResponseDTO;
import gr.techpro.absence.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;


    //  Returns an absence summary for a specific student in a specific module.

    @GetMapping("/students/{id}/modules/{moduleId}")
    public SummaryResponseDTO getStudentModuleSummary(@PathVariable Long id, @PathVariable Long moduleId) {
        return reportService.getStudentModuleSummary(id, moduleId);
    }


    //  Returns all students whose absence percentage exceeds the configured threshold.
    // If no threshold is provided, the default value from application.properties is used.

    @GetMapping("/modules/{id}/at-risk")
    public List<AtRiskStudentResponseDTO> getAtRiskStudents(@PathVariable Long moduleId,
                                                            @RequestParam(required = false) Double threshold) {
        return reportService.getAtRiskStudents(moduleId, threshold);
    }


    // Returns overall absence statistics for a specific module.
    @GetMapping("/modules/{id}/stats")
    public ModuleStatsResponseDTO getModuleStatistics(@PathVariable Long moduleId) {
        return reportService.getModuleStats(moduleId);
    }
}