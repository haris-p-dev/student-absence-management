package gr.techpro.absence.dto.request;


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
    @NotBlank(message="First name cannot be blank")
    private String firstName;

    @Size(max=100)
    @NotBlank(message="Last name cannot be blank")
    private String lastName;

    @NotBlank(message="Email cannot be blank")
    @Email
    @Size(max=255)
    private String email;

    @NotBlank(message="Student number cannot be null")
    @Size(max=50)
    private String studentNumber;


}
