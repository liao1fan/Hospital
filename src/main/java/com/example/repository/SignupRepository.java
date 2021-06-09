package com.example.repository;

public interface SignupRepository {
    public void AddPatient(String username, String password, String name, Integer age, String sex, String address, String phone);

}
