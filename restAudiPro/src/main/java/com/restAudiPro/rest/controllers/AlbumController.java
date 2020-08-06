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

import com.restAudiPro.rest.models.Album;
import com.restAudiPro.rest.models.Audio;
import com.restAudiPro.rest.repository.albumRepository;
import com.restAudiPro.rest.service.SecuenciaBDService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private albumRepository albumRepository;
	
	@Autowired
	private SecuenciaBDService secuenciaService;
	
	@PostMapping("/addAlbum")
	public Album createAlbum(@Validated @RequestBody Album album) {
		album.setId(secuenciaService.generateSequence(Audio.SEQUENCE_NAME));
		return albumRepository.insert(album);
	}
	
	@GetMapping("/getAlbum")
	public List <Album> getAllAlbum(){
		return albumRepository.findAll();
	}
}
