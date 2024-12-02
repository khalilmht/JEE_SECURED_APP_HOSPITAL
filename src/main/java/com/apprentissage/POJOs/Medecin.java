package com.apprentissage.POJOs;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity

public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min=4,max = 100)
    private String nom;
    @NotEmpty
    @Size(min=4,max = 100)
    private String prenom;

  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyyy-MM-dd")
    private Date dateNaissance;
    @NotEmpty
    @Size(min=4,max = 100)
  private String adresse;
    @NotEmpty
    @Size(min=4,max = 100)
    private String contact;
    @NotEmpty
    @Size(min=4,max = 100)
    private String specialite;
    @OneToMany(mappedBy="medecin")
    private Collection<Consultation> consultations;
    @OneToMany(mappedBy="medecin")
    private Collection<AdmissionPatient> admissionPatients;
    @OneToMany(mappedBy="medecin")
    private Collection<Traitement> traitements;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Medecin() {
    }

    public Medecin(String nom, String prenom, Date dateNaissance, String adresse, String contact, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.contact = contact;
        this.specialite = specialite;
    }


}
