package com.example.demo.app.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.app.model.Personaje;
import com.example.demo.app.service.PersonajeService;
import com.example.demo.app.utils.Constante;

@Service
public class PersonajeServiceImpl implements PersonajeService {

	public final Log log  = LogFactory.getLog(PersonajeServiceImpl.class);
	
	public Personaje getPersonaje(int id) {

		RestTemplate restTemplate = new RestTemplate();
		Personaje personaje = new Personaje();
		
		try {
			personaje = restTemplate.getForObject(Constante.URL_PERSONAJE + (id+1) + "/", Personaje.class);		
		
		} catch (Exception e) {
			this.log.error("ERROR AL CONSULTAR LA API");
			personaje = null;
		}
		
		return personaje;
	}

}
