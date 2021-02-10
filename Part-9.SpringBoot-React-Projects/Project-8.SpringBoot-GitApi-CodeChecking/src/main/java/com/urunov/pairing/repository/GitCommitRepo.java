package com.urunov.pairing.repository;

import com.urunov.pairing.data.GitCommit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GitCommitRepo extends MongoRepository<GitCommit, Integer> {
}
