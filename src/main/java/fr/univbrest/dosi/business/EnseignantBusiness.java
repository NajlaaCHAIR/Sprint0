package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.EnseignantRepository;

public class EnseignantBusiness implements InterfaceEnseignantBusiness {

	private EnseignantRepository EnseignRep;

	
	public EnseignantBusiness(){}
	
	public EnseignantBusiness(EnseignantRepository enseignRep) {
		super();
		EnseignRep = enseignRep;
	}

	@Override
	public Enseignant createEnseignant(Enseignant enseignant) {
		EnseignRep.save(enseignant);
		return enseignant;
	}

	@Override
	public Long CountAll() {
		return EnseignRep.count();
	}

	@Override
	public List<Enseignant> FindAll() {
		return (List<Enseignant>) EnseignRep.findAll();
	}
	
	
	
}
