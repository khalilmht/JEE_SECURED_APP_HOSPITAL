package com.apprentissage.POJOs;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Standard")
public class StandardUser extends Utilisateur{
    public StandardUser(String nom, String prenom, String login, String pwd, String adresse) {
        super(nom, prenom, login, pwd, adresse);

    }

    public StandardUser() {
    }

}
