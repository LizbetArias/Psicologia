package pe.edu.vallegrande.vg_ms_psychology_welfare.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.DevelopmentLevel;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.EvaluationType;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("psychological_evaluations")
public class PsychologicalEvaluation {

    @Id
    @Column("id")
    private UUID id;

    @Column("student_id")
    private UUID studentId;

    @Column("classroom_id")
    private UUID classroomId;

    @Column("institution_id")
    private UUID institutionId;

    @Column("evaluation_date")
    private LocalDate evaluationDate;

    @Column("academic_year")
    private Integer academicYear;

    @Column("evaluation_type")
    private EvaluationType evaluationType;

    @Column("evaluation_reason")
    private String evaluationReason;

    @Column("emotional_development")
    private DevelopmentLevel emotionalDevelopment;

    @Column("social_development")
    private DevelopmentLevel socialDevelopment;

    @Column("cognitive_development")
    private DevelopmentLevel cognitiveDevelopment;

    @Column("motor_development")
    private DevelopmentLevel motorDevelopment;

    private String observations;
    private String recommendations;

    @Column("requires_follow_up")
    private Boolean requiresFollowUp;

    @Column("follow_up_frequency")
    private String followUpFrequency;

    @Column("evaluated_by")
    private UUID evaluatedBy;

    @Column("evaluated_at")
    private LocalDateTime evaluatedAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;

    @Column("status")
    private Status status;
}