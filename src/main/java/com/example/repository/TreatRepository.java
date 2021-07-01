package com.example.repository;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.entity.Treat;

import java.util.Date;
import java.util.List;

public interface TreatRepository {
    public List<Treat> findByDoctorId(Integer doctorId );

    public void addTreat(Patient patient , Doctor doctor , java.sql.Timestamp time , String symptom , String diagnose );

    public Treat findById(Integer treatId);

    public void updateDiagnose(Integer treatId ,String  symptom ,String diagnose);

    public List<Treat> findByPatientId(Integer patientId);
}
