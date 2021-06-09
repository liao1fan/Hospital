package com.example.service.Impl;

import com.example.repository.AdminRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.Impl.AdminRepositoryImpl;
import com.example.repository.Impl.DoctorRepositoryImpl;
import com.example.repository.Impl.PatientRepositoryImpl;
import com.example.repository.PatientRepository;
import com.example.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private PatientRepository patientRepository = new PatientRepositoryImpl();
    private AdminRepository adminRepository = new AdminRepositoryImpl();
    private DoctorRepository doctorRepository = new DoctorRepositoryImpl();


    @Override
    public Object login(String username, String password, String type) {
        Object object = null;
        switch (type) {
            case "patient":
                object = patientRepository.login(username , password);
                break;
            case "doctor" :
                object = doctorRepository.login(username , password);
                break;
            case "admin":
                object = adminRepository.login(username, password);
                break;
        }
        return object;
    }

    @Override
    public boolean findByUsername(String username) {
        return patientRepository.findByUsername(username);
    }

    @Override
    public boolean findDoctorByUsername(String username) {
        return doctorRepository.findByUsername(username);
    }

    @Override
    public boolean findAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}
