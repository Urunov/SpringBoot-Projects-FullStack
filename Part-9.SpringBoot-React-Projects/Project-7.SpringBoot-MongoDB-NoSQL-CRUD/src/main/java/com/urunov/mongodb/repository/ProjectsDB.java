package com.urunov.mongodb.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsDB extends MongoRepository<ProjectsDB, String> {

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase database = mongoClient.getDatabase("crud2employee");
    MongoCollection<Document> coll = database.getCollection("projects");
}
