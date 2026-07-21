package gr.techpro.absence.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AbsenceJustificationRequestDTO {

    private boolean justified;

    @NotBlank(message = "Justification text is required")
    private String justification;

}