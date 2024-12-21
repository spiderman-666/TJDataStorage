package com.example.datastoragebackend.Entity.Neo4j;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Movie")
@Data
public class MovieN {
    @Id
    private String id;

    private String title;

    private String genre;

    private String releaseDate;

    private String score;

    @Relationship(type = "DIRECTED_BY", direction = Relationship.Direction.OUTGOING)
    private DirectorN director;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private ActorN actor;
}
