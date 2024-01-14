package com.example.taxetnb.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double surface;
    private String nom;
    private String description;
    @ManyToOne
    private Categorie categorie;
    @ManyToOne
    private Redevable redevable;
}
