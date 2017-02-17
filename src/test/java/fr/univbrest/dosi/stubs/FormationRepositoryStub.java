package fr.univbrest.dosi.stubs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

@Component
public class FormationRepositoryStub implements FormationRepository{

	private List<Formation> données;

	public FormationRepositoryStub(){
		données = new ArrayList<Formation>();
	}
	
	public FormationRepositoryStub(List<Formation> données) {
		this.données = données;
	}

	

	@Override
	public <S extends Formation> S save(S entity) {
		this.données.add(entity);
		return entity;
	}
	
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return this.données.size();
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Formation arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Formation> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Formation> findAll() {
		    
		return this.données;
	}

	@Override
	public Iterable<Formation> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Formation> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation findByCodeFormation(String codeFormation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation findByNomFormation(String nomFormation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Formation> findByDebutAccreditation(Date debutAccreditation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Formation> findByFinAccreditation(Date finAccreditation) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
