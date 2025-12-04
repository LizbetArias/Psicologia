package pe.edu.vallegrande.vg_ms_psychology_welfare.domain.model;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.Status;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.SupportType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"progressNotes", "description"})
@Table("special_needs_support")
public class SpecialNeedsSupport {

    @Id
    private UUID id;

    @Column("student_id")
    private UUID studentId;

    @Column("classroom_id")
    private UUID classroomId;

    @Column("institution_id")
    private UUID institutionId;

    @Column("academic_year")
    private Integer academicYear;

    @Column("diagnosis")
    private String diagnosis;

    @Column("diagnosis_date")
    private LocalDate diagnosisDate;

    @Column("diagnosed_by")
    private String diagnosedBy;

    @Column("support_type")
    private SupportType supportType;

    @Column("description")
    private String description;

    @Column("adaptations_required")
    private String[] adaptationsRequired;

    @Column("support_materials")
    private String[] supportMaterials;

    @Column("specialist_involved")
    private String specialistInvolved;

    @Column("progress_notes")
    private String progressNotes;

    @Column("last_review_date")
    private LocalDate lastReviewDate;

    @Column("next_review_date")
    private LocalDate nextReviewDate;

    @Column("status")
    @Builder.Default
    private Status status = Status.ACTIVE;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;

    // Métodos de dominio
    public void activate() {
        this.status = Status.ACTIVE;
    }

    public void deactivate() {
        this.status = Status.INACTIVE;
    }

    public boolean isActive() {
        return this.status == Status.ACTIVE;
    }
}
