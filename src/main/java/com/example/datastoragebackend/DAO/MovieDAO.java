package com.example.datastoragebackend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.datastoragebackend.Entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieDAO extends JpaRepository<Movie, String> {

    @Query("SELECT m FROM Movie m WHERE m.releaseDate BETWEEN :startDate AND :endDate")
    List<Movie> findMoviesByReleaseDateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    List<Movie> findByTitle(String title);//自动生成查询

    List<Movie> findByGenre(String genre);

    List<Movie> findByScoreBetween(float low, float high);
}
