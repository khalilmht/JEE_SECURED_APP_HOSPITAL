package com.apprentissage.POJOs;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

@Entity
public class SortiePatient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dose;
    private Time heure;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private Patient patient;

    @Override
    public String toString() {
        return "SortiePatient{" +
                "id=" + id +
                ", dose=" + dose +
                ", heure=" + heure +
                ", patient=" + patient +
                '}';
    }

    public SortiePatient(Date dose, Time heure, Patient patient) {
        this.dose = dose;
        this.heure = heure;
        this.patient = patient;
    }

    public SortiePatient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDose() {
        return dose;
    }

    public void setDose(Date dose) {
        this.dose = dose;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
