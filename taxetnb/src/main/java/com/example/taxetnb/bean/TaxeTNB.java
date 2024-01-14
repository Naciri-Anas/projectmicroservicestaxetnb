package com.example.taxetnb.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TaxeTNB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double total;
    private int tnbYear;
    private Double montantBase;
    @ManyToOne
    private Terrain terrain;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private Categorie categorie;
    @ManyToOne
    private Taux taux;
}
