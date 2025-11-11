package org.example.service_projet.Mappers;

import org.example.service_projet.DTO.ProjetRequestDTO;
import org.example.service_projet.DTO.ProjetResponseDTO;
import org.example.service_projet.Entity.Projet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProjetMapper {
    public Projet DTO_TO_ENTITY(ProjetRequestDTO projetRequestDTO){
        Projet projet = new Projet();
        BeanUtils.copyProperties(projetRequestDTO,projet);
        return projet;
    }

    public ProjetResponseDTO  ENTITY_TO_DTO(Projet projet){
        ProjetResponseDTO projetResponseDTO = new ProjetResponseDTO();
        BeanUtils.copyProperties(projet,projetResponseDTO);
        return projetResponseDTO;
    }
}


