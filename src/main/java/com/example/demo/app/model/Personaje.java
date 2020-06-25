package com.example.demo.app.model;

import java.io.Serializable;

public class Personaje implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String height;
		
	public Personaje() {
	}

	public Personaje(String name, String height) {
		this.name = name;
		this.height = height;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Personaje [name=" + name + ", height=" + height + "]";
	}
	

}
