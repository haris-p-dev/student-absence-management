package gr.techpro.absence.dto.request;

//Validations are applied in this class

import gr.techpro.absence.enums.SessionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionRequestDTO {


    @NotNull(message="Session date cannot be null")
    private LocalDate sessionDate;

    @NotNull(message="Start time cannot be null")
    private LocalTime startTime;

    @NotNull(message="End time cannot be null")
    private LocalTime endTime;

    @NotNull(message="Session type can be either LECTURE, LAB or SEMINAR")
    private SessionType sessionType;

    @Size(max=255)
    private String topic;

}
