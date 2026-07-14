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


    @NotNull
    private LocalDate sessionDate;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;

    @NotNull
    private SessionType sessionType;

    @Size(max=255)
    private String topic;

}
