package org.example.service_projet.Repository;

import org.example.service_projet.Entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
    List<Projet> findByChercheurId(Long chercheurId);
    List<Projet> findByEnseignantId(Long enseignantId);

}