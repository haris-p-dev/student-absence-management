package gr.techpro.absence.dto.request;

import gr.techpro.absence.enums.AbsenceStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceRequestDTO {

    @NotNull(message = "Enrollment ID must not be null")
    private Long enrollmentId;

    @NotNull(message = "Session ID must not be null")
    private Long sessionId;

    @NotNull(message = "Status must not be null")
    private AbsenceStatus status;

    private boolean justified;

    private String justification;

}
