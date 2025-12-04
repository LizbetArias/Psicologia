package pe.edu.vallegrande.vg_ms_psychology_welfare.infrastructure.dto.request;

import lombok.*;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.SupportType;

import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO para la creación o actualización de apoyos a estudiantes con necesidades especiales.
 * Contiene los datos que el cliente envía al servidor.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialNeedsSupportRequest {

    private UUID studentId;
    private UUID classroomId;
    private UUID institutionId;
    private Integer academicYear;

    private String diagnosis;
    private LocalDate diagnosisDate;
    private String diagnosedBy;

    private SupportType supportType;
    private String description;

    private String[] adaptationsRequired;
    private String[] supportMaterials;

    private String specialistInvolved;
    private String progressNotes;

    private LocalDate lastReviewDate;
    private LocalDate nextReviewDate;
}
