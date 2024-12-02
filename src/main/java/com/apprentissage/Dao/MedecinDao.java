package com.apprentissage.Dao;

import com.apprentissage.POJOs.Medecin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedecinDao extends JpaRepository<Medecin,Long> {
  Page<Medecin> findByNomContainsIgnoreCaseOrPrenomContainsIgnoreCase(String nom,String prenom, Pageable pageable);


}
