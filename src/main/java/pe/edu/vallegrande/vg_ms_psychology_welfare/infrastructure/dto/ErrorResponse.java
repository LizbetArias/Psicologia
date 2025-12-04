package pe.edu.vallegrande.vg_ms_psychology_welfare.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    
    private boolean success;
    private String message;
    private String error;
    private int status;
    private String path;
    private LocalDateTime timestamp;
    private List<String> details;
    
    public static ErrorResponse of(String message, String error, int status, String path) {
        return ErrorResponse.builder()
                .success(false)
                .message(message)
                .error(error)
                .status(status)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();
    }
    
    public static ErrorResponse of(String message, String error, int status, String path, List<String> details) {
        return ErrorResponse.builder()
                .success(false)
                .message(message)
                .error(error)
                .status(status)
                .path(path)
                .timestamp(LocalDateTime.now())
                .details(details)
                .build();
    }
}