package gr.techpro.absence.dto.response;

//Validations are applied in this class


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Getter
@AllArgsConstructor
@Builder
public class SessionResponse {

    private final Long sessionId;
    private final Long moduleId;
    private final LocalDate sessionDate;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String sessionType;

    @JsonInclude(JsonInclude.Include.NON_NULL) //topic can be null
    private final String topic;


}
