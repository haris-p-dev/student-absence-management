package gr.techpro.absence.dto.response;


import gr.techpro.absence.entity.ModuleEntity;
import gr.techpro.absence.enums.Semester;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModuleResponseDTO {

    private Long id;
    private String code;
    private String title;
    private Integer credits;
    private Semester semester;
    private Integer academicYear;
    private LocalDateTime createdAt;


    public static ModuleResponseDTO from(ModuleEntity module) {
        return ModuleResponseDTO.builder()
                .id(module.getId())
                .code(module.getCode())
                .title(module.getTitle())
                .credits(module.getCredits())
                .semester(module.getSemester())
                .academicYear(module.getAcadYear())
                .createdAt(module.getCreatedDate())
                .build();

    }
}