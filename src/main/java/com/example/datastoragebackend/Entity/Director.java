package com.example.datastoragebackend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "directors")
public class Director {
    @Id
    @Column(name = "director_id")
    private String id;

    @Column(name = "director_name")
    private String name;

}
