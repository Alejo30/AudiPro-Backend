/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restAudiPro.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restAudiPro.rest.models.Audio;
import com.restAudiPro.rest.repository.audioRepository;
import com.restAudiPro.rest.service.SecuenciaBDService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AudioController {
    
	@Autowired
	private audioRepository audioRepository;
	
	@Autowired
	private SecuenciaBDService secuenciaService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/getAudios")
	public List <Audio> getAllAudios(){
		return audioRepository.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/getAudio/{id}") 
	public String getAudioById(@PathVariable int id){
	  if (audioRepository.existsById(id)) {
		  return audioRepository.findById(id).toString();
	  }else {
		  return "Registro inexistente";
	  }
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/addAudio")
	public Audio createAudio(@Validated @RequestBody Audio audio) {
		audio.setId(secuenciaService.generateSequence(Audio.SEQUENCE_NAME));
		return audioRepository.insert(audio);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/updateAudio/{id}")
	public String updateAudio(@PathVariable int id, @Validated @RequestBody Audio audio) {
		if (audioRepository.existsById(id)) {
			audio.setId(id);
			return "Actualizado: "+audioRepository.save(audio).toString();	
		}else {
			return "No existe ese registro";
		}
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/deleteAudio/{id}")
	public String deleteAudio(@PathVariable int id) {
		if (audioRepository.existsById(id)) {
			audioRepository.deleteById(id);
			return "Eliminado: " + id;
		}else {
			return "No existe ese registro";
		}
		
	}
}
