package gr.techpro.absence.dto.request;

//Validations are applied in this class


import gr.techpro.absence.enums.EnrollmentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequestDTO {

    @NonNull
    private Long studentId;

    @NonNull
    private Long moduleId;

    @NotNull
    private EnrollmentStatus status;

}
