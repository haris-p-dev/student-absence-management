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

    @NotNull(message="Student id cannot be null")
    private Long studentId;

    @NotNull(message="Module id cannot be null")
    private Long moduleId;

    @NotNull(message="Enrollment status must be either ACTIVE, DROPPED or COMPLETED ")
    private EnrollmentStatus status;

}
