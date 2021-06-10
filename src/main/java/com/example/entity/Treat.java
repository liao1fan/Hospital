package com.example.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Treat {
    private Integer id;
    private Patient patient;
    private Doctor doctor;
    private java.sql.Timestamp time;
    private String symptom;
    private String diagnose;
    private Map<Drug , Integer > drug_list;

    public Treat(Integer id, Patient patient, Doctor doctor, java.sql.Timestamp time, String symptom, String diagnose, Map<Drug, Integer> drug_list) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
        this.symptom = symptom;
        this.diagnose = diagnose;
        this.drug_list = drug_list;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Map<Drug, Integer> getDrug_list() {
        return drug_list;
    }

    public void setDrug_list(Map<Drug, Integer> drug_list) {
        this.drug_list = drug_list;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
