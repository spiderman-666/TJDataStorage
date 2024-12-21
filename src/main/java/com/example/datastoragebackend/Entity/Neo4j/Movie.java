package com.example.datastoragebackend.Entity.Neo4j;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Date;

@Node("Movie")
@Data
public class Movie {
    @Id
    private String id;

    private String title;

    private String genre;

    private String releaseDate;

    private String score;
}
