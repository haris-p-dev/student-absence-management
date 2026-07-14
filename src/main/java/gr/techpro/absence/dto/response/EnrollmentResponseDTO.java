package gr.techpro.absence.dto.response;

import gr.techpro.absence.entity.EnrollmentEntity;
import gr.techpro.absence.entity.StudentEntity;
import gr.techpro.absence.enums.EnrollmentStatus;
import lombok.*;

import java.time.LocalDate;

//Validations are applied in this class


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponseDTO {
    private Long id;
    private Long studentId;
    private Long moduleId;
    private LocalDate enrolledAt;
    private EnrollmentStatus status;


    public static EnrollmentResponseDTO from(EnrollmentEntity enrollmentEntity){
        return EnrollmentResponseDTO.builder()
                .id(enrollmentEntity.getId())
                .studentId(enrollmentEntity.getStudent().getId())
                .moduleId(enrollmentEntity.getModule().getId())
                .enrolledAt(enrollmentEntity.getEnrolledAt())
                .status(enrollmentEntity.getStatus())
                .build();
    }

}
