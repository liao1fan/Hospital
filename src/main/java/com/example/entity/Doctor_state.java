package com.example.entity;

import java.util.Date;

public class Doctor_state {
    private Integer id;
    private Doctor doctor;
    private Date date;
    private Double fee;
    private Integer num;

    public Doctor_state() {
    }

    public Doctor_state(Integer id, Doctor doctor, Date date, Double fee, Integer num) {
        this.id = id;
        this.doctor = doctor;
        this.date = date;
        this.fee = fee;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
