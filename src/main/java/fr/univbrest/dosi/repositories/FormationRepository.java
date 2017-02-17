package fr.univbrest.dosi.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Formation;

public interface FormationRepository extends CrudRepository<Formation, Long>{
	
	Formation findByCodeFormation (String codeFormation);
	
	Formation findByNomFormation (String nomFormation);
	
	List<Formation> findByDebutAccreditation (Date debutAccreditation);
	
	List<Formation> findByFinAccreditation (Date finAccreditation);
	

}
