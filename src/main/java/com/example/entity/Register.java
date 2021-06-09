package com.example.entity;

import java.util.Date;

public class Register {
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private Double fee;
    private Integer state;

    public Register(Patient patient, Doctor doctor, Date date, Double fee, Integer state) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.fee = fee;
        this.state = state;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
