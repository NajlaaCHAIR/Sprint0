package fr.univbrest.dosi.repositories;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Enseignant;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnseignantRepository extends CrudRepository<Enseignant, Long> {

    List<Enseignant> findByNom(String nom);
  
    Enseignant findByNomAndPrenom(String nom, String prenom);
    
    Enseignant findByNoEnseignant(Long noEnseignant);

}
