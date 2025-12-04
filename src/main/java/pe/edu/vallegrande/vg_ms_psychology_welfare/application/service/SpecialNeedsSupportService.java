package pe.edu.vallegrande.vg_ms_psychology_welfare.application.service;

import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.model.SpecialNeedsSupport;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SpecialNeedsSupportService {

    Flux<SpecialNeedsSupport> findAllActive();
    
    Flux<SpecialNeedsSupport> findAll();

    Mono<SpecialNeedsSupport> findById(UUID id);

    Mono<SpecialNeedsSupport> create(SpecialNeedsSupport support);

    Mono<SpecialNeedsSupport> update(UUID id, SpecialNeedsSupport support);

    Mono<Void> deactivate(UUID id);

    Mono<SpecialNeedsSupport> activate(UUID id);
}

