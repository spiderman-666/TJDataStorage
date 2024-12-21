package com.example.datastoragebackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "actors")
public class Actor {
    @Id
    @Column(name = "actor_id")
    private String id;

    @Column(name = "actor_name")
    private String name;
}
