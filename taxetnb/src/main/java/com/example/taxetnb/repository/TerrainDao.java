package com.example.taxetnb.repository;

import com.example.taxetnb.bean.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainDao extends JpaRepository<Terrain,Long> {
    Terrain findByNom(String nom);

}

