package com.restAudiPro.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restAudiPro.rest.models.Artista;
import com.restAudiPro.rest.models.Audio;
import com.restAudiPro.rest.repository.artistaRepository;
import com.restAudiPro.rest.service.SecuenciaBDService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/artista")
public class ArtistaController {

	@Autowired
	private artistaRepository artistaRepository;

	@Autowired
	private SecuenciaBDService secuenciaService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/addArtista")
	public Artista createArtista(@Validated @RequestBody Artista artista) {
		artista.setId(secuenciaService.generateSequence(Audio.SEQUENCE_NAME));

		return artistaRepository.insert(artista);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/getArtista")
	public List <Artista> getAllArtistas(){
		return artistaRepository.findAll();
	}
}
