package org.example.service_projet.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChercheurResponseDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String specialite;
}
