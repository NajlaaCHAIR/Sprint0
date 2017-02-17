package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;


public class FormationBusiness implements InterfaceFormationBusiness {
	
	
	private FormationRepository Formationrep;
	
	
	/**
	 * Test plus facile. Instance de business n'est créée qui si un rep lui est fournie
	 * @param Formationrep
	 */
	//@Autowired
	
	public FormationBusiness(){
	}
	
	public FormationBusiness(FormationRepository Formationrep){
		super();
		this.Formationrep = Formationrep;
	}
	
    @Override
	public Formation createFormation(Formation formation)
	{
		return Formationrep.save(formation);
	}
	
    @Override
	public Long CountAll()
	{
		return Formationrep.count();
	}

	@Override
	public List<Formation> FindAll() {
		  
		return (List<Formation>) Formationrep.findAll();
	}

	public FormationRepository getFormationrep() {
		return Formationrep;
	}
    
	
}
