package com.urunov.mongodb.service;

import com.urunov.mongodb.model.DatabaseSequence;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceService {

    private MongoOperations mongoOperations;

    public SequenceService(MongoOperations mongoOperations){
        this.mongoOperations = mongoOperations;
    }

//    public String generateSequence(String Name){
//
//        DatabaseSequence couter = mongoOperations.findAndModify(Query(query.where("_id").is(Name))),
//        new Update().inc("seq",1), options().returnNew(true).upsert(true),
//                DatabaseSequence.class);
//    }

}
