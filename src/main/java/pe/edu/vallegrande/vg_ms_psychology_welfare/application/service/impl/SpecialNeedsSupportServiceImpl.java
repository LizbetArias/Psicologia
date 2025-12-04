package pe.edu.vallegrande.vg_ms_psychology_welfare.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.vg_ms_psychology_welfare.application.service.SpecialNeedsSupportService;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.Status;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.enums.SupportType;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.model.SpecialNeedsSupport;
import pe.edu.vallegrande.vg_ms_psychology_welfare.infrastructure.repository.SpecialNeedsSupportRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SpecialNeedsSupportServiceImpl implements SpecialNeedsSupportService {

    private final SpecialNeedsSupportRepository repository;

    /**
     * 🔹 Listar todos los registros
     */
    @Override
    public Flux<SpecialNeedsSupport> findAll() {
        return repository.findAll();
    }

    /**
     * 🔹 Listar todos los registros activos
     */
    @Override
    public Flux<SpecialNeedsSupport> findAllActive() {
        return repository.findByStatus(Status.ACTIVE);
    }

    /**
     * 🔹 Buscar un registro por su ID
     */
    @Override
    public Mono<SpecialNeedsSupport> findById(UUID id) {
        return repository.findById(id);
    }

    /**
     * 🔹 Crear un nuevo registro de apoyo especial
     */
    @Override
    public Mono<SpecialNeedsSupport> create(SpecialNeedsSupport support) {
        support.setId(null); // Dejar que la BD genere el UUID
        support.setStatus(Status.ACTIVE);
        support.setCreatedAt(LocalDateTime.now());
        support.setUpdatedAt(LocalDateTime.now());
        return repository.save(support);
    }

    /**
     * 🔹 Actualizar un registro existente
     */
    @Override
    public Mono<SpecialNeedsSupport> update(UUID id, SpecialNeedsSupport support) {
        return repository.findById(id)
                .flatMap(existing -> {
                    // Mantener datos creados
                    support.setId(existing.getId());
                    support.setCreatedAt(existing.getCreatedAt());
                    support.setUpdatedAt(LocalDateTime.now());
                    return repository.save(support);
                });
    }

    /**
     * 🔹 Eliminación lógica (cambiar estado a INACTIVE)
     */
    @Override
    public Mono<Void> deactivate(UUID id) {
        return repository.findById(id)
                .flatMap(support -> {
                    support.deactivate();
                    support.setUpdatedAt(LocalDateTime.now());
                    return repository.save(support);
                })
                .then();
    }

    /**
     * 🔹 Reactivar un registro (cambiar estado a ACTIVE)
     */
    @Override
    public Mono<SpecialNeedsSupport> activate(UUID id) {
        return repository.findById(id)
                .flatMap(support -> {
                    support.activate();
                    support.setUpdatedAt(LocalDateTime.now());
                    return repository.save(support);
                });
    }

    /**
     * 🔹 Buscar por estudiante (solo registros activos)
     */
    public Flux<SpecialNeedsSupport> findActiveByStudent(UUID studentId) {
        return repository.findActiveByStudentId(studentId);
    }

    /**
     * 🔹 Buscar por tipo de apoyo
     */
    public Flux<SpecialNeedsSupport> findBySupportType(SupportType type) {
        return repository.findBySupportType(type);
    }

    /**
     * 🔹 Buscar por institución y año académico
     */
    public Flux<SpecialNeedsSupport> findByInstitutionAndAcademicYear(UUID institutionId, Integer academicYear) {
        return repository.findByInstitutionAndAcademicYear(institutionId, academicYear);
    }

    /**
     * 🔹 Contar por tipo de apoyo en una institución
     */
    public Mono<Long> countBySupportTypeAndInstitution(UUID institutionId, String supportType) {
        return repository.countBySupportTypeAndInstitution(institutionId, supportType);
    }
}
