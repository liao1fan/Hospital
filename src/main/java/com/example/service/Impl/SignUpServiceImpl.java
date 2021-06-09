package com.example.service.Impl;

import com.example.repository.SignupRepository;
import com.example.repository.Impl.SignupRepositoryImpl;
import com.example.service.LoginService;
import com.example.service.SignupService;

public class SignUpServiceImpl implements SignupService {

    private static LoginService loginService = new LoginServiceImpl();

    private static SignupRepository signupRepository = new SignupRepositoryImpl();
    @Override
    public void AddPatient(String username, String password, String name, Integer age, String sex, String address, String phone) {
        signupRepository.AddPatient(username, password, name, age, sex, address, phone);
    }

}
