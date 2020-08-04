package com.restAudiPro.rest.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.restAudiPro.rest.models.secuenciaBD;

@Service
public class SecuenciaBDService {
	private MongoOperations mongoOperations;
	
	@Autowired
    public SecuenciaBDService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
	
	
	public int generateSequence(String seqName) {

        secuenciaBD counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                secuenciaBD.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }
}
