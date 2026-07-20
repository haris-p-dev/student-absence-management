package gr.techpro.absence.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponseDTO {

    private final LocalDateTime timestamp;
    private final int status;
    private final String message;
    private final String path;
}