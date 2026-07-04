package gr.techpro.absence.dto.request;

//Validations are applied in this class

import gr.techpro.absence.enums.Semester;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModuleRequestDTO {

    @NotBlank
    private String code;

    @NotBlank
    @Size(max = 255)
    private String title;

    @NotNull
    @Size(max = 20)
    private Semester semester;

    @NotNull
    @Positive
    private Integer academicYear;

}
