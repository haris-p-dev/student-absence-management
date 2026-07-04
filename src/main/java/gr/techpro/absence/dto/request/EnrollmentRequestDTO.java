package gr.techpro.absence.dto.request;

//Validations are applied in this class


import lombok.*;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequestDTO {

    @NonNull
    private Long studentId;

    @NonNull
    private Long moduleId;

}
