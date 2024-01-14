package com.example.taxetnb.repository;

import com.example.taxetnb.bean.TaxeTNB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeDao extends JpaRepository<TaxeTNB,Long> {
    TaxeTNB findByTerrainNomAndTnbYear(String nom, int tnbYear);
}
