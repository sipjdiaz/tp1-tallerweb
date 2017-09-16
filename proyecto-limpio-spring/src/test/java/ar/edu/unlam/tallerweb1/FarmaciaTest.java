package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

import static org.assertj.core.api.Assertions.assertThat;

public class FarmaciaTest extends SpringTest {
	
	@Test
	@Transactional
	@Rollback(false)
	public void testCreate()
	{
		Direccion dir = new Direccion();
		Barrio bar = new Barrio();
		Farmacia farm = new Farmacia();
		
		dir.setCalle("General Hornos");
		dir.setNumero("1234");
		bar.setNombre("Villa Bosch");
		dir.setBarrio(bar);
		
		getSession().save(bar);
		getSession().save(dir);
	
		farm.setDiaDeTurno("Martes");
		farm.setNombre("Los picapiedra");
		farm.setTelefono("4444-9999");
		farm.setDireccion(dir);
		
		getSession().save(farm);
		
		Direccion dir2 = new Direccion();
		Barrio bar2 = new Barrio();
		Farmacia farm2 = new Farmacia();
		
		dir2.setCalle("General Hornos");
		dir2.setCalle("1100");
		bar2.setNombre("Caseros");
		dir2.setBarrio(bar2);
		
		getSession().save(bar2);
		getSession().save(dir2);
		
		farm2.setDiaDeTurno("Jueves");
		farm2.setNombre("Los Martinez");
		farm2.setTelefono("4242-2312");
		farm2.setDireccion(dir2);
		
		getSession().save(farm2);
		
		Direccion dir3 = new Direccion();
		Barrio bar3 = new Barrio();
		Farmacia farm3 = new Farmacia();
		
		dir3.setCalle("Beiro");
		dir3.setCalle("1200");
		bar3.setNombre("Devoto");
		dir3.setBarrio(bar3);
		
		getSession().save(bar3);
		getSession().save(dir3);
			
		farm3.setDiaDeTurno("Martes");
		farm3.setNombre("Los Locos Adams");
		farm3.setTelefono("4923-2911");
		farm3.setDireccion(dir3);
		
		getSession().save(farm3);
		
		Direccion dir4 = new Direccion();
		Barrio bar4 = new Barrio();
		Farmacia farm4 = new Farmacia();
		
		dir4.setCalle("Beiro");
		dir4.setCalle("1200");
		bar4.setNombre("Devoto");
		dir4.setBarrio(bar4);
		
		getSession().save(bar4);
		getSession().save(dir4);
		
		farm4.setDiaDeTurno("Martes");
		farm4.setNombre("Farmacity");
		farm4.setTelefono("5123-1100");
		farm4.setDireccion(dir4);
		
		getSession().save(farm4);
		
		assertThat(getSession().get(Farmacia.class, farm.getId())).isNotNull();
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testBuscarFarmaciasTurnoMartes()
	{
		List<Farmacia> farmacia;
		farmacia = getSession().createCriteria(Farmacia.class)
								.add(Restrictions.eq("diaDeTurno", "Martes"))
								.list();
		
		assertThat(farmacia).hasSize(3);
		
	}

}
