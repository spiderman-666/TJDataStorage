package com.example.datastoragebackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "actors")
public class Actor {
    @Id
    @Column(name = "actor_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String actor_id;

    @Column(name = "actor_name")
    private String actor_name;

}
