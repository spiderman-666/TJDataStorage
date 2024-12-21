package com.example.datastoragebackend.Relation;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "MovieDirector")
@IdClass(MovieDirectorPk.class)
public class MovieDirector {
    @Id
    @Column(name="director_id")
    private String directorId;

    @Id
    @Column(name="movie_id")
    private String movieId;
}
