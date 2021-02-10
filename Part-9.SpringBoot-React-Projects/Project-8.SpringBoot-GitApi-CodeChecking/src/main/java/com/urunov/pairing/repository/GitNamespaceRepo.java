package com.urunov.pairing.repository;

import com.urunov.pairing.data.GitNamespace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitNamespaceRepo extends MongoRepository<GitNamespace, Integer> {
}
