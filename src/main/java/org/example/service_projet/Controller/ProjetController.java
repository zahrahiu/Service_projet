package org.example.service_projet.Controller;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

import org.example.service_projet.DTO.ProjetRequestDTO;
import org.example.service_projet.DTO.ProjetResponseDTO;
import org.example.service_projet.Service.ProjetService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "Service des projets",
                description = "Ce service permet de gérer les projets des chercheurs.",
                version = "1.0.0"
        ),
        servers = @Server(url = "http://localhost:8082")
)
@RestController
@RequestMapping("/v1/projets")
public class ProjetController {

    private final ProjetService service;

    public ProjetController(ProjetService service) {
        this.service = service;
    }

    @Operation(
            summary = "Ajouter un projet",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProjetRequestDTO.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Projet créé avec succès",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProjetResponseDTO.class))),
                    @ApiResponse(responseCode = "4xx", description = "Erreur client"),
                    @ApiResponse(responseCode = "5xx", description = "Erreur serveur")
            }
    )
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping
    public ResponseEntity<ProjetResponseDTO> createProjet(@RequestBody ProjetRequestDTO dto) {
        return ResponseEntity.ok(service.createProjet(dto));
    }

    @Operation(
            summary = "Modifier un projet",
            parameters = @Parameter(name = "id", required = true),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProjetRequestDTO.class)
                    )
            )
    )
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ProjetResponseDTO> updateProjet(@PathVariable Long id,
                                                          @RequestBody ProjetRequestDTO dto) {
        return ResponseEntity.ok(service.updateProjet(id, dto));
    }

    @Operation(
            summary = "Supprimer un projet",
            parameters = @Parameter(name = "id", required = true)
    )
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        service.deleteProjet(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Récupérer tous les projets",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Liste des projets",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProjetResponseDTO.class))))
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_USER')")
    @GetMapping
    public ResponseEntity<List<ProjetResponseDTO>> getAllProjets() {
        return ResponseEntity.ok(service.getAllProjets());
    }

    @Operation(
            summary = "Récupérer un projet par ID",
            parameters = @Parameter(name = "id", required = true)
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<ProjetResponseDTO> getProjetById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProjetById(id));
    }

    @Operation(
            summary = "Récupérer les projets d'un chercheur",
            parameters = @Parameter(name = "chercheurId", required = true)
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_USER')")
    @GetMapping("/chercheur/{chercheurId}")
    public ResponseEntity<List<ProjetResponseDTO>> getProjetsByChercheur(@PathVariable Long chercheurId) {
        return ResponseEntity.ok(service.getProjetsByChercheur(chercheurId));
    }

    @Operation(
            summary = "Récupérer les projets d'un enseignant",
            parameters = @Parameter(name = "enseignantId", required = true)
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_USER')")
    @GetMapping("/enseignant/{enseignantId}")
    public ResponseEntity<List<ProjetResponseDTO>> getProjetsByEnseignant(@PathVariable Long enseignantId) {
        return ResponseEntity.ok(service.getProjetsByEnseignant(enseignantId));
    }


}
