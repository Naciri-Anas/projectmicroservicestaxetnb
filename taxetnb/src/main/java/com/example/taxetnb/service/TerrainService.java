package com.example.taxetnb.service;

import com.example.taxetnb.bean.Categorie;
import com.example.taxetnb.bean.Redevable;
import com.example.taxetnb.bean.Terrain;
import com.example.taxetnb.repository.CategorieDao;
import com.example.taxetnb.repository.RedevableDao;
import com.example.taxetnb.repository.TerrainDao;
import com.example.taxetnb.service.abs.IService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TerrainService implements IService<Terrain> {

    @Autowired
    private TerrainDao terrainDao;
    @Autowired
    private CategorieDao categorieDao;
    @Autowired
    private RedevableDao redevableDao;


    @Override
    public Page<Terrain> findAll(Pageable page) {
        return terrainDao.findAll(page);
    }

    public Terrain save(Terrain terrain) {
        //check category
        Optional<Categorie> c = categorieDao.findById(terrain.getCategorie().getId());
        if (c.isPresent()) {
            terrain.setCategorie(c.get());
        } else {
            throw new RuntimeException("Category not found.");
        }

        //check Redevable
        Optional<Redevable> r = redevableDao.findById(terrain.getCategorie().getId());
        if (r.isPresent()) {
            terrain.setRedevable(r.get());
        } else {
            throw new RuntimeException("Redevable not found.");
        }

        return terrainDao.save(terrain);
    }

    @Override
    public Terrain update(Terrain terrain) {
        return null;
    }

    public Optional<Terrain> findById(Long id) {
        return terrainDao.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        terrainDao.deleteById(id);
    }

    public Terrain findByNom(String nom) {
        return terrainDao.findByNom(nom);
    }
}