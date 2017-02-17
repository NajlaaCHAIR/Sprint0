package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.EnseignantRepository;


//@RequestMapping(value="/Enseignants")
@RestController
public class EnseignantController {
	
	@Autowired
	private EnseignantRepository business;
	
	public EnseignantController(){}
	
	@RequestMapping(value="/nbEnseignants")
	public Long Count()
	{
		return business.count();
	}
	
	
	@RequestMapping(value="/Enseignants")
	public List<Enseignant> Afficher()
	{
	    return Lists.newArrayList(business.findAll());
       
	}
	
	@RequestMapping(value="/newEnseignant", method = RequestMethod.POST)
	public void AddEns(@RequestBody Enseignant enseignant)
	{
	    business.save(enseignant);
       
	}
	
	@RequestMapping(value="/supprimerEns/{nom}-{prenom}")
	public String Delete(@PathVariable String nom,@PathVariable String prenom)
	{
		Enseignant enseignant = business.findByNomAndPrenom(nom, prenom);
		if(enseignant.equals(null))
		    return "Enseignant non existant";
		else {
			//suppression de FKs
			business.delete(enseignant);
			return "Enseignant "+nom+" "+prenom+" supprimée";
		}
		    
       
	}
	
	@RequestMapping(value="enseignant/{nom}-{prenom}")
	public Enseignant FindByNomAndPrenom(@PathVariable String nom,@PathVariable String prenom)
	{
		return business.findByNomAndPrenom(nom, prenom);
	}


}
