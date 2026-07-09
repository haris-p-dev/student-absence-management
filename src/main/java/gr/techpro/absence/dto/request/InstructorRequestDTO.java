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
    @NotBlank
    private String firstName;

    @Size(max=100)
    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    @Size(max=255)
    private String email;


}
