package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Formation;

public abstract interface InterfaceFormationBusiness {

	
	public abstract Formation createFormation(Formation formation);
	public abstract Long CountAll();
	public abstract List<Formation> FindAll();
}
