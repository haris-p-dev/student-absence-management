package gr.techpro.absence.dto.response;


//Validations are applied in this class

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
}
