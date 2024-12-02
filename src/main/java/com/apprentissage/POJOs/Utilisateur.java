package com.apprentissage.POJOs;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_USER",discriminatorType = DiscriminatorType.STRING,length = 30)
public abstract class  Utilisateur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String login;
    private String pwd;
    private String adresse;

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Utilisateur(String nom, String prenom, String login, String pwd, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.pwd = pwd;
        this.adresse = adresse;
    }

    public Utilisateur(String nom) {
        this.nom = nom;
    }

    public Utilisateur() {
    }
}

