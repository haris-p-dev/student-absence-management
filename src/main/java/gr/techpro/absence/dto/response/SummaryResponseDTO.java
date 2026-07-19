package gr.techpro.absence.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter
@AllArgsConstructor
public class SummaryResponseDTO {

    private final Long studentId;

    private final String studentName;

    private final Long moduleId;

    private final String moduleTitle;

    private final Long totalSessions;

    private final Long attended;

    private final Long absent;

    private final Long justifiedAbsences;
}

