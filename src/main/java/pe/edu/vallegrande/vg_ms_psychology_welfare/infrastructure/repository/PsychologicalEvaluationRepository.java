package pe.edu.vallegrande.vg_ms_psychology_welfare.infrastructure.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.model.PsychologicalEvaluation;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.Status;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface PsychologicalEvaluationRepository extends R2dbcRepository<PsychologicalEvaluation, UUID> {
    
    Flux<PsychologicalEvaluation> findByStudentId(UUID studentId);
    
    Flux<PsychologicalEvaluation> findByClassroomId(UUID classroomId);
    
    Flux<PsychologicalEvaluation> findByInstitutionId(UUID institutionId);
    
    Flux<PsychologicalEvaluation> findByEvaluatedBy(UUID evaluatedBy);
    
    Flux<PsychologicalEvaluation> findByAcademicYear(Integer academicYear);
    
    Flux<PsychologicalEvaluation> findByEvaluationType(String evaluationType);
    
    Flux<PsychologicalEvaluation> findByStatus(Status status);
}