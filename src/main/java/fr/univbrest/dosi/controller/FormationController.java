package fr.univbrest.dosi.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;






import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusiness;
import fr.univbrest.dosi.repositories.FormationRepository;


//@RequestMapping(value="/Formations")
@RestController
public class FormationController {
	
	@Autowired
	private FormationRepository business;
	
	
	public FormationController(){
		
		//Formation formation1 = new Formation("DOSI" , "DOSI", "Master", "Master2", new Date() , null , new BigDecimal(9));
		//business.createFormation(formation1);
	}
	
	@RequestMapping(value="/nbformations")
	public Long CountFor()
	{
		return business.count();
	}
	
	
	@RequestMapping(value="/formations")
	public List<Formation> AfficherTout()
	{
	    return Lists.newArrayList(business.findAll());
       
	}
	
	@RequestMapping(value="/newFormation", method = RequestMethod.POST)
	public void Add(@RequestBody Formation formation)
	{
	    business.save(formation);
       
	}
	
	/*@RequestMapping(value="/UpdateFormation", method = RequestMethod.POST)
	public void UpdateF(@RequestBody Formation formation)
	{
	    business.save(formation);
       
	}*/
	
	
	@RequestMapping(value="supprimer/{code}")
	public String Delete(@PathVariable String code)
	{
		Formation formation = business.findByCodeFormation(code);
		if(formation.equals(null))
		    return "Formation non existante";
		else {
			//suppression FK de PROMOTION
			business.delete(formation);
			return "Formation "+code+" supprimée";
		}
		    
       
	}
	
	@RequestMapping(value="formation/{code}")
	public Formation FindByCode(@PathVariable String code)
	{
		return business.findByCodeFormation(code);
	}

}
