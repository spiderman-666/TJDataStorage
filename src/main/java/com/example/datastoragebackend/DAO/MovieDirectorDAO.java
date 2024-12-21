package com.example.datastoragebackend.DAO;

import com.example.datastoragebackend.Relation.MovieDirector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieDirectorDAO extends JpaRepository<MovieDirector, String> {
    List<MovieDirector> findByDirectorId(String directorId);//自动生成查询
}
