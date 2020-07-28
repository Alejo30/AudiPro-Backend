/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restAudiPro.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

import com.restAudiPro.rest.models.Audio;
import com.restAudiPro.rest.repository.audioRepository;
import com.restAudiPro.rest.service.SecuenciaBDService;

@RestController
@RequestMapping("/api")
public class AudioController {
    
	@Autowired
	private audioRepository audioRepository;
	
	@Autowired
	private SecuenciaBDService secuenciaService;
	
	@GetMapping("/getAudios")
	public List <Audio> getAllAudios(){
		return audioRepository.findAll();
	}
	
	
  @GetMapping("/getAudio/{id}") 
  public Optional<Audio> getAudioById(@PathVariable int id){
	  return audioRepository.findById(id);
  }
	 
	 
	@PostMapping("/addAudio")
	public Audio createAudio(@Validated @RequestBody Audio audio) {
		audio.setId(secuenciaService.generateSequence(Audio.SEQUENCE_NAME));
		return audioRepository.insert(audio);
	}
	
	@PutMapping("/updateAudio/{id}")
	public Audio updateAudio(@PathVariable int id, @Validated @RequestBody Audio audio) {
		return audioRepository.save(audio);
	}
	
	@DeleteMapping("/deleteAudio/{id}")
	public String deleteAudio(@PathVariable int id) {
		audioRepository.deleteById(id);
		return "Deleted:" + id;
	}
}
