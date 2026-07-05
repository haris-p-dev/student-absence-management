package gr.techpro.absence.dto.response;

//Validations are applied in this class


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessionResponseDTO {

    private Long sessionId;
    private Long moduleId;
    private LocalDate sessionDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String sessionType;

    @JsonInclude(JsonInclude.Include.NON_NULL) //topic can be null
    private String topic;


}
