package pe.edu.vallegrande.vg_ms_psychology_welfare.infrastructure.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.Status;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.SupportType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO para la respuesta de apoyos a estudiantes con necesidades especiales.
 * Representa la información devuelta al cliente tras las operaciones de la API.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Respuesta con la información de estudiante con necesidades especiales.")
public class SpecialNeedsSupportResponse {

    @Schema(description = "ID de registro de apoyo.")
    private UUID id;

    @Schema(description = "ID del estudiante.")
    private UUID studentId;

    @Schema(description = "ID aula del estudiante.")
    private UUID classroomId;

    @Schema(description = "ID de la institución educativa.")
    private UUID institutionId;

    @Schema(description = "Año académico en el que se realiza el seguimiento.")
    private Integer academicYear;

    @Schema(description = "Diagnóstico")
    private String diagnosis;

    @Schema(description = "Fecha en que se realizó el diagnóstico.")
    private LocalDate diagnosisDate;

    @Schema(description = "profesional que realizó el diagnóstico.")
    private String diagnosedBy;

    @Schema(description = "Tipo de apoyo")
    private SupportType supportType;

    @Schema(description = "Descripción general")
    private String description;

    @Schema(description = "Lista de adaptaciones necesarias para el estudiante.")
    private String[] adaptationsRequired;

    @Schema(description = "Materiales de apoyo utilizados durante el proceso.")
    private String[] supportMaterials;

    @Schema(description = "Especialista involucrado en el proceso de apoyo.")
    private String specialistInvolved;

    @Schema(description = "Notas de seguimiento del progreso del estudiante.")
    private String progressNotes;

    @Schema(description = "Fecha de la última revisión del caso.")
    private LocalDate lastReviewDate;

    @Schema(description = "Fecha programada para la próxima revisión.")
    private LocalDate nextReviewDate;

    @Schema(description = "Estado actual del registro de apoyo (ACTIVE o INACTIVE).")
    private Status status;

    @Schema(description = "Fecha y hora de creación del registro.")
    private LocalDateTime createdAt;

    @Schema(description = "Fecha y hora de la última actualización.")
    private LocalDateTime updatedAt;
}
