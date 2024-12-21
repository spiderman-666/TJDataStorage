package com.example.datastoragebackend.Relation;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MovieActorPk {
    private String actorId;
    private String movieId;
}
