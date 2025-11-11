package org.example.service_projet.Service;

import lombok.RequiredArgsConstructor;
import org.example.service_projet.Client.ChercheurClient;
import org.example.service_projet.DTO.ProjetRequestDTO;
import org.example.service_projet.DTO.ProjetResponseDTO;
import org.example.service_projet.Entity.Projet;
import org.example.service_projet.Mappers.ProjetMapper;
import org.example.service_projet.Repository.ProjetRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjetServiceImpl implements ProjetService {

    private final ProjetRepository repository;
    private final ProjetMapper mapper;
    private final ChercheurClient chercheurClient;

    @Override
    public ProjetResponseDTO createProjet(ProjetRequestDTO dto) {
        chercheurClient.getChercheurById(dto.getChercheurId());

        Projet projet = mapper.DTO_TO_ENTITY(dto);
        Projet saved = repository.save(projet);
        return mapper.ENTITY_TO_DTO(saved);
    }

    @Override
    public ProjetResponseDTO updateProjet(Long id, ProjetRequestDTO dto) {
        Projet projet = repository.findById(id).orElseThrow();
        projet.setTitre(dto.getTitre());
        projet.setDescription(dto.getDescription());
        projet.setChercheurId(dto.getChercheurId());
        projet.setEnseignantId(dto.getEnseignantId());
        Projet saved = repository.save(projet);
        return mapper.ENTITY_TO_DTO(saved);
    }

    @Override
    public void deleteProjet(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ProjetResponseDTO getProjetById(Long id) {
        return repository.findById(id)
                .map(mapper::ENTITY_TO_DTO)
                .orElseThrow();
    }

    @Override
    public List<ProjetResponseDTO> getAllProjets() {
        return repository.findAll()
                .stream()
                .map(mapper::ENTITY_TO_DTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjetResponseDTO> getProjetsByChercheur(Long chercheurId) {
        return repository.findByChercheurId(chercheurId)
                .stream()
                .map(mapper::ENTITY_TO_DTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjetResponseDTO> getProjetsByEnseignant(Long enseignantId) {
        return repository.findByEnseignantId(enseignantId)
                .stream()
                .map(mapper::ENTITY_TO_DTO)
                .collect(Collectors.toList());
    }

}
