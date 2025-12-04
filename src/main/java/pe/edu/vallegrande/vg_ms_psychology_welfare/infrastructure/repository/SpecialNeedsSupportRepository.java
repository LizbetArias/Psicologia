package pe.edu.vallegrande.vg_ms_psychology_welfare.infrastructure.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.Status;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.SupportType;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.model.SpecialNeedsSupport;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface SpecialNeedsSupportRepository extends R2dbcRepository<SpecialNeedsSupport, UUID> {

    // Buscar por estudiante
    Flux<SpecialNeedsSupport> findByStudentId(UUID studentId);

    // Buscar por estudiante y estado
    Flux<SpecialNeedsSupport> findByStudentIdAndStatus(UUID studentId, Status status);

    // Buscar por aula
    Flux<SpecialNeedsSupport> findByClassroomId(UUID classroomId);

    // Buscar por institución
    Flux<SpecialNeedsSupport> findByInstitutionId(UUID institutionId);

    // Buscar por año académico
    Flux<SpecialNeedsSupport> findByAcademicYear(Integer academicYear);

    // Buscar por tipo de apoyo
    Flux<SpecialNeedsSupport> findBySupportType(SupportType supportType);

    // Buscar por estado
    Flux<SpecialNeedsSupport> findByStatus(Status status);

    // Buscar por estudiante y año académico
    Flux<SpecialNeedsSupport> findByStudentIdAndAcademicYear(UUID studentId, Integer academicYear);

    // Buscar activos por estudiante
    @Query("SELECT * FROM special_needs_support WHERE student_id = :studentId AND status = 'ACTIVE'")
    Flux<SpecialNeedsSupport> findActiveByStudentId(@Param("studentId") UUID studentId);

    // Buscar por institución y año académico
    @Query("SELECT * FROM special_needs_support WHERE institution_id = :institutionId AND academic_year = :academicYear")
    Flux<SpecialNeedsSupport> findByInstitutionAndAcademicYear(
            @Param("institutionId") UUID institutionId,
            @Param("academicYear") Integer academicYear
    );

    // Verificar si existe por ID y estado
    Mono<SpecialNeedsSupport> findByIdAndStatus(UUID id, Status status);

    // Contar por tipo de apoyo en una institución
    @Query("SELECT COUNT(*) FROM special_needs_support WHERE institution_id = :institutionId AND support_type = :supportType AND status = 'ACTIVE'")
    Mono<Long> countBySupportTypeAndInstitution(
            @Param("institutionId") UUID institutionId,
            @Param("supportType") String supportType
    );

    // Verificar existencia por ID
    Mono<Boolean> existsById(UUID id);
}