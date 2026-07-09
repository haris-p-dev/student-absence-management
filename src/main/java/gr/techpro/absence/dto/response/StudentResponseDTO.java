package gr.techpro.absence.dto.response;


//Validations are applied in this class

import gr.techpro.absence.entity.StudentEntity;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String studentNumber;
    private LocalDate enrollDate;
    private LocalDateTime createdDate;

    //static method for mapping.
    public static StudentResponseDTO from(StudentEntity student){
        return StudentResponseDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .studentNumber(student.getStudentNumber())
                .enrollDate(student.getEnrollDate())
                .createdDate(student.getCreatedDate())
                .build();
    }


}
