package com.apprentissage.Dao;

import com.apprentissage.POJOs.AdmissionPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionDao extends JpaRepository<AdmissionPatient,Long> {
/*L'interface JPARepository a definie toutes les methodes classiques (ajouter ,supprimer,afficher,printAll...)
 */
/*C'est une interface generique ,si on veut definir une nouvelle methode ,on met la signature de la methode et et le reste sera fait par Sprint Data*/

    AdmissionPatient findByid(Long id);


}