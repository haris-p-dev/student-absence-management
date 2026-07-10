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

    @NotNull
    private Long moduleId;

    @NotNull
    private Long instructorId;

    @NotNull
    private InstructorRole role;
}
