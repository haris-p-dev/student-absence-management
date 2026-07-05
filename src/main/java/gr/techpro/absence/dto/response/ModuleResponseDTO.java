package gr.techpro.absence.dto.response;

//Validations are applied in this class


import gr.techpro.absence.enums.Semester;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModuleResponseDTO {

    private Long id;
    private String code;
    private String title;
    private Integer credits;
    private Semester semester;
    private Integer academicYear;
    private LocalDateTime createdAt;

}
