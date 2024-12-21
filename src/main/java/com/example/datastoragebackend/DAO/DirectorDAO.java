package com.example.datastoragebackend.DAO;

import com.example.datastoragebackend.Entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectorDAO extends JpaRepository<Director, String> {
    Optional<Director> findByName(String name);//自动生成查询
}
