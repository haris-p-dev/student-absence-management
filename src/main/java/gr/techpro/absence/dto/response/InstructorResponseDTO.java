package gr.techpro.absence.dto.response;

import gr.techpro.absence.entity.InstructorEntity;
import gr.techpro.absence.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InstructorResponseDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdDate;

    //static method for mapping.
    public static InstructorResponseDTO from(InstructorEntity instructor) {
        return InstructorResponseDTO.builder()
                .id(instructor.getId())
                .firstName(instructor.getFirstName())
                .lastName(instructor.getLastName())
                .email(instructor.getEmail())
                .createdDate(instructor.getCreatedDate())
                .build();
    }
    }