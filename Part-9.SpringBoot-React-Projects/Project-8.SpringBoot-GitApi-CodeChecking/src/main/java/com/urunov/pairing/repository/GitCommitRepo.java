package com.urunov.pairing.repository;

import com.urunov.pairing.data.GitCommit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitCommitRepo extends MongoRepository<GitCommit, Integer> {
}
