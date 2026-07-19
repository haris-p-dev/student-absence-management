package gr.techpro.absence.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ModuleStatsResponseDTO {

    private final Long moduleId;

    private final String moduleTitle;

    private final Long totalStudents;

    private final Long totalSessions;

    private final Long totalAbsences;

    private final Long totalJustifiedAbsences;

    private final Double absencePercentage;

}