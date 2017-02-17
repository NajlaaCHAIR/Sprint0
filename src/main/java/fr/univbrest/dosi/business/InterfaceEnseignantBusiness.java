package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Enseignant;

public abstract interface InterfaceEnseignantBusiness {
	
	public abstract Enseignant createEnseignant(Enseignant enseignant);
	public abstract Long CountAll();
	public abstract List<Enseignant> FindAll();
	

}

