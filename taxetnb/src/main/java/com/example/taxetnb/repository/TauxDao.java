package com.example.taxetnb.repository;

import com.example.taxetnb.bean.Taux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxDao extends JpaRepository<Taux,Long> {
    Taux findByCategorieLabel(String label);
}
