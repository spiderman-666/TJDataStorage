package com.example.datastoragebackend.Relation;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "MovieActor")
@IdClass(MovieActorPk.class)
public class MovieActor {
    @Id
    @Column(name="actor_id")
    private String actorId;

    @Id
    @Column(name="movie_id")
    private String movieId;
}
