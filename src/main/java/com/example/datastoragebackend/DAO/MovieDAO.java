package com.example.datastoragebackend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.datastoragebackend.Entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MovieDAO extends JpaRepository<Movie, String> {

    List<Movie> findMoviesByReleaseDateBetween(Date startDate, Date endDate);

    List<Movie> findByTitle(String title);//自动生成查询

    List<Movie> findByGenre(String genre);

    List<Movie> findByScoreBetween(float low, float high);
}
