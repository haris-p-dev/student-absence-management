package gr.techpro.absence.dto.request;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


// Bean Validations are applied in this class

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {


    @Size(max = 100)
    @NotBlank
    private String firstName;

    @Size(max=100)
    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    @Size(max=255)
    private String email;

    @NotBlank
    @Size(max=50)
    private String studentNumber;


}
