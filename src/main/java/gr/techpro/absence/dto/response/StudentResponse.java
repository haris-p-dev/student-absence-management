package gr.techpro.absence.dto.response;


//Validations are applied in this class

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class StudentResponse {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String studentNumber;
    private final LocalDate enrollDate;
    private final LocalDateTime createdDate;
}
