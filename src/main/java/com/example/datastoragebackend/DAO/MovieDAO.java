package com.example.datastoragebackend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.datastoragebackend.Entity.Movie;

import java.util.List;

public interface MovieDAO extends JpaRepository<Movie, String> {
    List<Movie> findByTitle(String title);//自动生成查询
}
