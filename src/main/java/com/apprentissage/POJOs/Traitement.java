package com.apprentissage.POJOs;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Traitement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicament;
    private String dose;
    private String duree;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private Medecin medecin;

    @Override
    public String toString() {
        return "Traitement{" +
                "id=" + id +
                ", medicament='" + medicament + '\'' +
                ", dose='" + dose + '\'' +
                ", duree='" + duree + '\'' +
                ", patient=" + patient +
                ", medecin=" + medecin +
                '}';
    }

    public Traitement(String medicament, String dose, String duree, Patient patient, Medecin medecin) {
        this.medicament = medicament;
        this.dose = dose;
        this.duree = duree;
        this.patient = patient;
        this.medecin = medecin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Traitement() {
    }
}
