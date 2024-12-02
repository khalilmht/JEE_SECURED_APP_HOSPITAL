package com.apprentissage.POJOs;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Entity
public class Patient implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotEmpty
        @Size(min=4,max=100)
        private String nom;
        @NotEmpty
        @Size(min=4,max=100)
        private String prenom;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Temporal(TemporalType.DATE)
        private Date dateNaissance;
        @NotEmpty
        @Size(min=4,max=100)
        private String adresse;
    @NotEmpty
    @Size(min=4,max=100)
        private String contact;

        @OneToMany(mappedBy="patient")
       private Collection<Consultation> consultations;
        @OneToMany(mappedBy="patients")
        private Collection<AdmissionPatient> admissionPatients;
        @OneToMany(mappedBy="patient")
        private Collection<SortiePatient> sortiePatients;

        @OneToMany(mappedBy="patient")
        private Collection<Traitement> traitements;



        public Patient() {
        }
        @Override
        public String toString()
        {
                return "Patient"
                        + "{"
                        +" ID :" +id+
                        "nom :" +nom+
                        " prenom :" +prenom+
                        " Adresse :" +adresse+
                        " Contact :" +contact+
                        " date :" +dateNaissance+"}";

        }

        public void setNom(String nom) {
                this.nom = nom;
        }

        public void setPrenom(String prenom) {
                this.prenom = prenom;
        }

        public void setDateNaissance(Date dateNaissance) {
                this.dateNaissance = dateNaissance;
        }

        public void setAdresse(String adresse) {
                this.adresse = adresse;
        }

        public void setContact(String contact) {
                this.contact = contact;
        }

        public Patient(String nom, String prenom, Date dateNaissance, String adresse, String contact) {

                this.nom = nom;
                this.prenom = prenom;
                this.dateNaissance = dateNaissance;
                this.adresse = adresse;
                this.contact = contact;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
                return nom;
        }

        public String getPrenom() {
                return prenom;
        }

        public Date getDateNaissance() {
                return dateNaissance;
        }

        public String getAdresse() {
                return adresse;
        }

        public String getContact() {
                return contact;
        }

    public Collection<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(Collection<Consultation> consultations) {
        this.consultations = consultations;
    }

    public Collection<AdmissionPatient> getAdmissionPatients() {
        return admissionPatients;
    }

    public void setAdmissionPatients(Collection<AdmissionPatient> admissionPatients) {
        this.admissionPatients = admissionPatients;
    }

    public Collection<SortiePatient> getSortiePatients() {
        return sortiePatients;
    }

    public void setSortiePatients(Collection<SortiePatient> sortiePatients) {
        this.sortiePatients = sortiePatients;
    }

    public Collection<Traitement> getTraitements() {
        return traitements;
    }

    public void setTraitements(Collection<Traitement> traitements) {
        this.traitements = traitements;
    }
}
