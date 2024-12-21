package com.example.datastoragebackend.DAO.Neo4j;


import com.example.datastoragebackend.Entity.Neo4j.ActorN;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorDAON extends Neo4jRepository<ActorN,String> {
    Optional<ActorN> findByName(String name);
}
