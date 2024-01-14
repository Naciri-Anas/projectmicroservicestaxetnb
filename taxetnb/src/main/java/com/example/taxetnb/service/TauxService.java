package com.example.taxetnb.service;

import com.example.taxetnb.bean.Categorie;
import com.example.taxetnb.bean.Taux;
import com.example.taxetnb.repository.CategorieDao;
import com.example.taxetnb.repository.TauxDao;
import com.example.taxetnb.service.abs.IService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TauxService implements IService<Taux> {

    @Autowired
    private TauxDao tauxDao;
    @Autowired
    private CategorieDao categorieDao;


    @Override
    public Page<Taux> findAll(Pageable page) {
        return tauxDao.findAll(page);
    }

    public Taux save(Taux taux) {
        Categorie c = categorieDao.findById(taux.getId()).orElseThrow();
        taux.setCategorie(c);
        return tauxDao.save(taux);
    }

    @Override
    public Taux update(Taux taux) {
        return null;
    }

    public Optional<Taux> findById(Long id) {
        return tauxDao.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        tauxDao.deleteById(id);
    }

    public Taux findByCategorieLabel(String label) {
        return tauxDao.findByCategorieLabel(label);
    }
}
