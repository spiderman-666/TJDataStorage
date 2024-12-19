package com.example.datastoragebackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "movies")
public class Movie {
    @Id
    @Column(name = "movie_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;

    @Column(name = "movie_title")
    private String title;

    @Column(name = "movie_score")
    private String score;

    @Column(name = "review_count")
    private int reviewCount;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "duration")
    private String duration ;

    @Column(name = "genre")
    private String genre;

    @Column(name = "source_type")
    private String source_type;
}
