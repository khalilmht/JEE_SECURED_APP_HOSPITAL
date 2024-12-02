package com.apprentissage.POJOs;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Administrateur")
public class AdminUser extends Utilisateur{
    public AdminUser(String nom, String prenom, String login, String pwd, String adresse) {
        super(nom, prenom, login, pwd, adresse);
    }

    public AdminUser() {
    }
}
