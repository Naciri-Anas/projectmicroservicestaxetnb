package com.example.taxetnb.service;

import com.example.taxetnb.bean.Redevable;
import com.example.taxetnb.bean.Taux;
import com.example.taxetnb.bean.TaxeTNB;
import com.example.taxetnb.bean.Terrain;
import com.example.taxetnb.repository.RedevableDao;
import com.example.taxetnb.repository.TauxDao;
import com.example.taxetnb.repository.TaxeDao;
import com.example.taxetnb.repository.TerrainDao;
import com.example.taxetnb.service.abs.IService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaxeService implements IService<TaxeTNB> {

    @Autowired
    private TaxeDao taxeDao;
    @Autowired
    private TerrainDao terrainDao;
    @Autowired
    private TauxDao tauxDao;
    @Autowired
    private RedevableDao redevableDao;


    @Override
    public Page<TaxeTNB> findAll(Pageable page) {
        return taxeDao.findAll(page);
    }

    public TaxeTNB save(TaxeTNB taxeTNB) {
        Redevable redevable = redevableDao.findByCin(taxeTNB.getRedevable().getCin());
        Terrain terrain = terrainDao.findByNom(taxeTNB.getTerrain().getNom());
        if (redevable == null) {
            throw new RuntimeException("Redevable not found");
        } else if (terrain == null) {
            throw new RuntimeException("terrain not found");
        } else if (terrain.getCategorie() == null) {
            throw new RuntimeException("Categorie not found");
        } else if (taxeDao.findByTerrainNomAndTnbYear(terrain.getNom(), taxeTNB.getTnbYear()) != null) {
            throw new RuntimeException("Redevable not found");
        } else if (tauxDao.findByCategorieLabel(terrain.getCategorie().getLabel()) == null) {
            throw new RuntimeException("Redevable nout found");
        } else {
            Taux taux = tauxDao.findByCategorieLabel(terrain.getCategorie().getLabel());
            taxeTNB.setRedevable(redevable);
            taxeTNB.setTerrain(terrain);
            taxeTNB.setTaux(taux);
            taxeTNB.setTotal(taxeTNB.getTerrain().getSurface() * taxeTNB.getTaux().getMontant());
            return taxeDao.save(taxeTNB);
        }
    }

    @Override
    public TaxeTNB update(TaxeTNB taxeTNB) {
        return null;
    }


    public Optional<TaxeTNB> findById(Long id) {
        return taxeDao.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        taxeDao.deleteById(id);
    }

    public TaxeTNB findByTerrainNomAndTnbYear(String nom, int tnbYear) {
        return taxeDao.findByTerrainNomAndTnbYear(nom, tnbYear);
    }
}