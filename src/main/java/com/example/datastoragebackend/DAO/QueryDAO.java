package com.example.datastoragebackend.DAO;

import com.example.datastoragebackend.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Repository
public interface QueryDAO extends JpaRepository<Movie, Long> {
    /*

    // 按时间范围查询
    @Query("SELECT m FROM Movie m WHERE m.releaseDate BETWEEN :startDate AND :endDate")
    List<Movie> findByReleaseDateBetween(@Param("startDate") LocalDate startDate,
                                         @Param("endDate") LocalDate endDate);

    // 按电影名称查询
    List<Movie> findByNameContaining(String name);

    // 按导演查询
    @Query("SELECT m FROM Movie m JOIN m.director d WHERE d.name = :directorName")
    List<Movie> findByDirectorName(@Param("directorName") String directorName);

    // 按演员查询
    @Query("SELECT m FROM Movie m JOIN m.actors a WHERE a.name = :actorName")
    List<Movie> findByActorName(@Param("actorName") String actorName);

    // 按评分查询
    @Query("SELECT m FROM Movie m WHERE m.rating BETWEEN :minRating AND :maxRating")
    List<Movie> findByRatingBetween(@Param("minRating") Integer minRating,
                                    @Param("maxRating") Integer maxRating);

     */
}
