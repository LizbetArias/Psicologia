package pe.edu.vallegrande.vg_ms_psychology_welfare.infrastructure.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vg_ms_psychology_welfare.application.service.SpecialNeedsSupportService;
import pe.edu.vallegrande.vg_ms_psychology_welfare.domain.model.SpecialNeedsSupport;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/special-needs-support")
@RequiredArgsConstructor
@Tag(name = "Soporte de Necesidades Especiales", description = "Endpoints para gestionar los apoyos de necesidades especiales")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SpecialNeedsSupportRest {

    private final SpecialNeedsSupportService service;

    // ------------------ LISTAR TODOS ------------------
    @Operation(summary = "Listar todos los soportes activos")
    @GetMapping
    public Flux<SpecialNeedsSupport> getAllActiveSupports() {
        return service.findAllActive();
    }

    // ------------------ LISTAR TODOS (incluyendo inactivos) ------------------
    @Operation(summary = "Listar todos los soportes (activos e inactivos)")
    @GetMapping("/all")
    public Flux<SpecialNeedsSupport> getAllSupports() {
        return service.findAll();
    }

    // ------------------ OBTENER POR ID ------------------
    @Operation(summary = "Obtener soporte por ID")
    @GetMapping("/{id}")
    public Mono<SpecialNeedsSupport> getById(@PathVariable UUID id) {
        return service.findById(id);
    }

    // ------------------ CREAR ------------------
    @Operation(summary = "Crear nuevo soporte")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<SpecialNeedsSupport> create(@RequestBody SpecialNeedsSupport support) {
        return service.create(support);
    }

    // ------------------ ACTUALIZAR ------------------
    @Operation(summary = "Actualizar soporte existente")
    @PutMapping("/{id}")
    public Mono<SpecialNeedsSupport> update(@PathVariable UUID id, @RequestBody SpecialNeedsSupport support) {
        return service.update(id, support);
    }

    // ------------------ ELIMINACIÓN LÓGICA ------------------
    @Operation(summary = "Desactivar soporte (eliminación lógica)")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deactivate(@PathVariable UUID id) {
        return service.deactivate(id);
    }

    // ------------------ REACTIVAR ------------------
    @Operation(summary = "Reactivar soporte desactivado")
    @PutMapping("/{id}/activate")
    public Mono<SpecialNeedsSupport> activate(@PathVariable UUID id) {
        return service.activate(id);
    }
}
