package com.apprentissage.POJOs;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;
@Entity

public class Consultation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Date heure;
    private String noteconsultation;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Medecin medecin;

    public Consultation() {
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", date=" + date +
                ", heure=" + heure +
                ", noteconsultation='" + noteconsultation + '\'' +
                ", patient=" + patient.getNom() + " "+ patient.getPrenom()+
                ", medecin=" + medecin.getNom() +" "+medecin.getPrenom()+
                '}';
    }

    public Consultation(Date date, Date heure, String noteconsultation, Patient patient, Medecin medecin) {
        this.date = date;
        this.heure = heure;
        this.noteconsultation = noteconsultation;
        this.patient = patient;
        this.medecin = medecin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public String getNoteconsultation() {
        return noteconsultation;
    }

    public void setNoteconsultation(String noteconsultation) {
        this.noteconsultation = noteconsultation;
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
}
