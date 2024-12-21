package com.example.datastoragebackend.Relation;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MovieContributorPk {
    private String contributorId;
    private String movieId;
}
