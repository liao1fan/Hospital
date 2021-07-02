package com.example.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 看病关系实体，医生为患者看病的信息，对应着treat表
 */


public class Treat {
    private Integer id;
    private Patient patient;
    private Doctor doctor;
    private java.sql.Timestamp time;
    private String symptom;
    private String diagnose;


    public Treat(Integer id, Patient patient, Doctor doctor, Timestamp time, String symptom, String diagnose) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
        this.symptom = symptom;
        this.diagnose = diagnose;
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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
}
