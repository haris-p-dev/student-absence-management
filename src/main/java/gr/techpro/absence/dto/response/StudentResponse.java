package gr.techpro.absence.dto.response;


//Validations are applied in this class

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private  String studentNumber;

    private LocalDate enrollDate;
}
