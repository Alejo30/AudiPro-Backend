package com.restAudiPro.rest.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "artista")
public class Artista implements Serializable {

	@Id
	private int id;
    private String nombre;
    
    
	public Artista() {	}


	public Artista(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + "]";
	}
    
	
}
