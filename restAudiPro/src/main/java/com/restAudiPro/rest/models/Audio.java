/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restAudiPro.rest.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "audio")
public class Audio implements Serializable{
	
	@Transient
	public static final String SEQUENCE_NAME = "secuenciaBD";
	
	@Id
    private int id;
    private String nombre;
    private String autor;
    private int año;
    private String genero;
    private String album;
    
    public Audio() {}
    
    
    
	public Audio(String nombre, String autor, int año, String genero, String album) {
		this.nombre = nombre;
		this.autor = autor;
		this.año = año;
		this.genero = genero;
		this.album = album;
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}


	@Override
	public String toString() {
		return "Audio [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", año=" + año + ", genero=" + genero
				+ ", album=" + album + "]";
	}
	
	
    
    
}
