package com.example.datastoragebackend.Relation;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MovieDirectorPk {
    private String directorId;
    private String movieId;
}
