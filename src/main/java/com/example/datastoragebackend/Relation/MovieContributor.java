package com.example.datastoragebackend.Relation;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "MovieContributor")
@IdClass(MovieContributorPk.class)
public class MovieContributor {
    @Id
    @Column(name="contributor_id")
    private String contributorId;

    @Id
    @Column(name="movie_id")
    private String movieId;
}
