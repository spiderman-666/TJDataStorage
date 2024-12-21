package com.example.datastoragebackend.DAO.Neo4j;


import com.example.datastoragebackend.Entity.Neo4j.ActorN;
import com.example.datastoragebackend.Entity.Neo4j.DirectorN;
import com.example.datastoragebackend.Entity.Neo4j.MovieN;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDAON extends Neo4jRepository<MovieN,String> {
    List<MovieN> findAllByTitle(String title);

    List<MovieN> findAllByDirector(DirectorN director);

    List<MovieN> findAllByActor(ActorN actor);

    List<MovieN> findAllByDirectorAndActor(DirectorN director, ActorN actor);
}
