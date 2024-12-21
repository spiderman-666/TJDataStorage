package com.example.datastoragebackend.DAO.Neo4j;


import com.example.datastoragebackend.Entity.Neo4j.DirectorN;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorDAON extends Neo4jRepository<DirectorN,String> {
    Optional<DirectorN> findByName(String name);
}
