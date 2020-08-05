package com.restAudiPro.rest.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "album")
public class Album implements Serializable{
	@Id
	private int id;
    private String nombre;
    private String artista;
    private int anio;
    
    public Album() {}
    
	public Album(int id, String nombre, String artista, int anio) {
		this.id = id;
		this.nombre = nombre;
		this.artista = artista;
		this.anio = anio;
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

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", nombre=" + nombre + ", artista=" + artista + ", anio=" + anio + "]";
	}
	
	
	

}
