package com.urunov.mongodb.service;

import com.urunov.mongodb.model.DatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class SequenceGeneratorService {

    private MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations){
        this.mongoOperations = mongoOperations;
    }

    public String generateSequence(String seqName) {
        //
        DatabaseSequence counter = mongoOperations.findAndModify(Query.query(where("id").is(seqName)),
                new Update().inc("seq", 1), options().returnNew(true).upsert(true), DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : "1";
    }
}
