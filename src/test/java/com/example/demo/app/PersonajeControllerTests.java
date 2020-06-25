package com.example.demo.app;



import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.demo.app.controller.PersonajeController;
import com.example.demo.app.model.Personaje;
import com.example.demo.app.utils.ConstanteTest;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonajeControllerTests {

	@Autowired
	PersonajeController personajeController;
	
	@Test
	@DisplayName("Si busco el personaje 1, debo obtener el nombre de Luke Skywalker")
	public void cuandoBuscoPorID() {
		
		Personaje personajeRecibido = this.personajeController.seleccionaPersonaje(ConstanteTest.ID_LUKE);
		
		assertEquals(ConstanteTest.LUKE, personajeRecibido.getName());
	}
	


}
