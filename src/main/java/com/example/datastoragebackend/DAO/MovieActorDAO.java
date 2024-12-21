package com.example.datastoragebackend.DAO;

import com.example.datastoragebackend.Relation.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieActorDAO extends JpaRepository<MovieActor, String> {
    List<MovieActor> findByActorId(String actorId);//自动生成查询
}
