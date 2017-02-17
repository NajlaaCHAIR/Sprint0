package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

import static org.assertj.core.api.Assertions.assertThat;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class FormationBusinessTest {
	
	
	private InterfaceFormationBusiness Interface;
	
	public FormationBusinessTest() {	
		//Classe qui implemente la FormationRepository et qui contient des données
		
		Interface = new FormationBusiness();		
	}
	
	
	public void init(){	
			
	}

	
	@Test
	public void DoitConfirmerAjout(){
		
		Formation formation = new Formation("DOSI" , "DOSI", "Master", "Master2", new Date() , null , new BigDecimal(9));
		Formation resultat = this.Interface.createFormation(formation);
		
	    assertThat(resultat.getCodeFormation()).isEqualTo("DOSI");
	}
	
	
	@Test
	public void DoitCompterlesFormations(){
		
		Long resultat = this.Interface.CountAll();
		assertThat(resultat).isEqualTo(1L);
	}
}
