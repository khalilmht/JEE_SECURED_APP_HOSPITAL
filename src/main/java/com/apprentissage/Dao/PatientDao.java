package com.apprentissage.Dao;

import com.apprentissage.POJOs.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientDao extends JpaRepository<Patient,Long> {

    Page<Patient> findByNomContainsIgnoreCaseOrPrenomContainsIgnoreCase(String mc, String p, Pageable pageable);



    /*L'interface JPARepository a definie toutes les methodes classiques (ajouter ,supprimer,afficher,printAll...)
     */
    /*C'est une interface generique ,si on veut definir une nouvelle methode ,on met la signature de la methode et et le reste sera fait par Sprint Data*/
}
