package gr.techpro.absence.dto.response;

import lombok.*;

//Validations are applied in this class


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponseDTO {
    private Long id;
    private Long studentId;
    private Long moduleId;
    private String status;

}
