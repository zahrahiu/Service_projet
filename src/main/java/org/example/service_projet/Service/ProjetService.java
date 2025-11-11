package org.example.service_projet.Service;

import org.example.service_projet.DTO.ProjetRequestDTO;
import org.example.service_projet.DTO.ProjetResponseDTO;

import java.util.List;

public interface ProjetService {

        ProjetResponseDTO createProjet(ProjetRequestDTO dto);
        ProjetResponseDTO updateProjet(Long id, ProjetRequestDTO dto);
        void deleteProjet(Long id);
        ProjetResponseDTO getProjetById(Long id);
        List<ProjetResponseDTO> getAllProjets();
        List<ProjetResponseDTO> getProjetsByChercheur(Long chercheurId);
    List<ProjetResponseDTO> getProjetsByEnseignant(Long enseignantId);

}
