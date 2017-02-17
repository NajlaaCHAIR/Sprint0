package fr.univbrest.dosi.repositories;

import static org.assertj.core.api.Assertions.assertThat;

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




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class FormationRepositoryTest {
	
	
	@Autowired
	FormationRepository formationRepo;
	
	@Before
	public void init()
	{
		Formation formation1 = new Formation("DOSI" , "DOSI", "Master", "Master2", new Date() , null , new BigDecimal(9));
		formationRepo.save(formation1);
			
	}
	
	@Test
	public void DoitCompterLesFormations()
	{
		long resultat = formationRepo.count();
		
		assertThat(resultat).isEqualTo(1L);
	}
	
	
	/*@Test
	public void DoitSupprimerFormation()
	{
		
	}*/

}
