package com.restAudiPro.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.restAudiPro.rest.models.Audio;

@Repository
public interface audioRepository extends MongoRepository <Audio, Integer>{
	


}
