package gr.techpro.absence.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AttendanceStatisticsDTO {

    private final Long studentId;

    private final String studentName;

    private final Long totalSessions;

    private final Long absences;

}