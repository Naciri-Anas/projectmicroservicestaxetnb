package com.example.taxetnb.service;

import com.example.taxetnb.bean.Categorie;
import com.example.taxetnb.repository.CategorieDao;
import com.example.taxetnb.service.abs.IService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategorieService implements IService<Categorie> {

    @Autowired
    private CategorieDao categorieDao;


    @Override
    public Page<Categorie> findAll(Pageable page) {
        return categorieDao.findAll(page);
    }


    public Categorie save(Categorie categorie) {
        return categorieDao.save(categorie);
    }

    @Override
    public Categorie update(Categorie categorie) {
        return categorieDao.save(categorie);
    }

    public Optional<Categorie> findById(Long id) {
        return categorieDao.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        categorieDao.deleteById(id);
    }

}
