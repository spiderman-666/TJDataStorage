package com.example.datastoragebackend.Entity.Neo4j;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Director")
@Data
public class DirectorN {
    @Id
    private String id;

    private String name;

    @Relationship(type = "DIRECTED_BY", direction = Relationship.Direction.INCOMING)
    private MovieN movie;
}
