package com.restAudiPro.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.restAudiPro.rest.models.Artista;

@Repository
public interface artistaRepository extends MongoRepository <Artista, Integer> {

}
