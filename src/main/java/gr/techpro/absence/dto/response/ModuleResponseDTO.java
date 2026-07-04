package gr.techpro.absence.dto.response;

//Validations are applied in this class


import gr.techpro.absence.enums.Semester;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class ModuleResponseDTO {

    private final Long id;
    private final String code;
    private final String title;
    private final Integer credits;
    private final Semester semester;
    private final Integer academicYear;
    private final LocalDateTime createdAt;

}
