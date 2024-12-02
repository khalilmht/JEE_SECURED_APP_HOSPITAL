package com.apprentissage.POJOs;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

@Entity

public class AdmissionPatient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateAd;
    private String numeroChambre;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patients;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Medecin medecin;


    @Override
    public String toString() {
        return "AdmissionPatient{" +
                "id=" + id +
                ", dateAd=" + dateAd +
                ", numeroChambre='" + numeroChambre + '\'' +
                ", patients=" + patients.getNom() +
                ", medecin=" + medecin.getNom() +
                '}';
    }

    public AdmissionPatient(Date dateAd, String numeroChambre, Patient patients, Medecin medecin) {
        this.dateAd = dateAd;
        this.numeroChambre = numeroChambre;
        this.patients = patients;
        this.medecin = medecin;
    }

    public AdmissionPatient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAd() {
        return dateAd;
    }

    public void setDateAd(Date dateAd) {
        this.dateAd = dateAd;
    }

    public String getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(String numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public Patient getPatients() {
        return patients;
    }

    public void setPatients(Patient patients) {
        this.patients = patients;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }
}
