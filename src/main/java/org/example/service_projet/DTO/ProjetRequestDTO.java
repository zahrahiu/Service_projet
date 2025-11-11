package org.example.service_projet.DTO;


import lombok.*;

@Getter

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjetRequestDTO {
    private String titre;
    private String description;
    private Long chercheurId;
    private Long enseignantId;
}

