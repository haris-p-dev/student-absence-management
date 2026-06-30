package gr.techpro.absence.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// Bean Validations are applied in this class

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {


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
