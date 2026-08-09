package gr.techpro.absence.dto.request;

import gr.techpro.absence.enums.InstructorRole;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleInstructorRequestDTO {

    @NotNull(message="Module id cannot be null")
    private Long moduleId;

    @NotNull(message="Instructor id cannot be null")
    private Long instructorId;

    @NotNull(message="Role must be either LEAD or ASSISTANT")
    private InstructorRole role;
}
