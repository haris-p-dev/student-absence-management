package gr.techpro.absence.dto.response;

import gr.techpro.absence.entity.AbsenceEntity;
import gr.techpro.absence.enums.AbsenceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceResponseDTO {

    private Long id;

    private Long enrollmentId;

    private Long sessionId;

    private AbsenceStatus status;

    private String justification;

    private boolean justified;

    private LocalDateTime recordedAt;

    private LocalDateTime updatedAt;


public static AbsenceResponseDTO  from(AbsenceEntity absence) {

    return AbsenceResponseDTO.builder()
            .id(absence.getId())
            .enrollmentId(absence.getEnrollment().getId())
            .sessionId(absence.getSession().getId())
            .status(absence.getStatus())
            .justification(absence.getJustification())
            .justified(absence.isJustified())
            .recordedAt(absence.getRecordedAt())
            .updatedAt(absence.getUpdatedAt())
            .build();
}
}
