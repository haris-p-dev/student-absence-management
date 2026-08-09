package gr.techpro.absence.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorRequestDTO {
    @Size(max = 100)
    @NotBlank (message = "First name cannot be blank")
    private String firstName;

    @Size(max=100)
    @NotBlank (message = "Last name cannot be blank")
    private String lastName;

    @NotBlank (message = "First name cannot be blank")
    @Email
    @Size(max=255)
    private String email;


}
