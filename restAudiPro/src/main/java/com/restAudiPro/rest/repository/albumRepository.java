package com.restAudiPro.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.restAudiPro.rest.models.Album;

@Repository
public interface albumRepository extends MongoRepository <Album, Integer> {

}
