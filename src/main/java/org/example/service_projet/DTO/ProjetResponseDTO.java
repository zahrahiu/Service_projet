package org.example.service_projet.DTO;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjetResponseDTO {
    private Long id;
    private String titre;
    private String description;
    private Long chercheurId;
    private Long enseignantId;
}
