package gr.techpro.absence.dto.request;

import gr.techpro.absence.enums.AbsenceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceRequestDTO {


    private Long enrollmentId;

    private Long sessionId;

    private AbsenceStatus status;

    private boolean justified;

    private String justification;

}
