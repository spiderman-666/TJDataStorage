package com.example.datastoragebackend.DAO;

import com.example.datastoragebackend.Entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActorDAO extends JpaRepository<Actor, String> {
    Optional<Actor> findByName(String name);//自动生成查询
}
