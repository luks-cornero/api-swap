package com.example.demo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.app.model.Personaje;
import com.example.demo.app.service.PersonajeService;

@RestController
@RequestMapping("api")
public class PersonajeController {

	@Autowired
	PersonajeService personajeService;
	
	@GetMapping("personaje/{id}")
	public Personaje seleccionaPersonaje(@PathVariable int id) {		
		return this.personajeService.getPersonaje(id);
	}
	
	
}
