package gr.techpro.absence.dto.request;

//Validations are applied in this class


import gr.techpro.absence.entity.ModuleEntity;
import gr.techpro.absence.entity.StudentEntity;
import gr.techpro.absence.enums.EnrollmentStatus;
import lombok.*;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequest {


    private StudentEntity student;


    private ModuleEntity module;


    private EnrollmentStatus status;
}
