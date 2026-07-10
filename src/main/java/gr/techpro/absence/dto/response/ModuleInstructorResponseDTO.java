package gr.techpro.absence.dto.response;

import gr.techpro.absence.entity.ModuleInstructorEntity;
import gr.techpro.absence.enums.InstructorRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ModuleInstructorResponseDTO {

    private final Long id;

    private final Long moduleId;

    private final Long instructorId;

    private final String moduleTitle;

    private final String instructorFirstName;

    private final InstructorRole role;

    public static ModuleInstructorResponseDTO from(ModuleInstructorEntity moduleInstructorEntity) {

        return ModuleInstructorResponseDTO.builder()
                .id(moduleInstructorEntity.getId())
                .moduleId(moduleInstructorEntity.getModule().getId())
                .instructorId(moduleInstructorEntity.getInstructor().getId())
                .moduleTitle(moduleInstructorEntity.getModule().getTitle())
                .instructorFirstName(moduleInstructorEntity.getInstructor().getFirstName())
                .role(moduleInstructorEntity.getRole())
                .build();
    }
}
