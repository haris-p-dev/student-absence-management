package gr.techpro.absence.dto.request;

//Validations are applied in this class

import gr.techpro.absence.enums.Semester;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModuleRequestDTO {

    @NotBlank(message="Code cannot be blank")
    private String code;

    @NotBlank(message="Title cannot be blank")
    @Size(max = 255)
    private String title;

    @Positive
    @NotNull(message="Credits cannot be null")
    private Integer credits;

    @NotNull(message="Semester must be either FALL, SPRING or SUMMER")
    @Size(max = 20)
    private Semester semester;


    @NotNull(message="Academic year cannot be null")
    @Positive
    private Integer academicYear;

}
