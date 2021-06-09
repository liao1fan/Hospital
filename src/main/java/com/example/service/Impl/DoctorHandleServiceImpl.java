package com.example.service.Impl;

import com.example.entity.Register;
import com.example.repository.Impl.RegisterRepositoryImpl;
import com.example.repository.RegisterRepository;
import com.example.service.DoctorHandleService;

import java.util.List;

public class DoctorHandleServiceImpl implements DoctorHandleService {

    private static RegisterRepository registerRepository = new RegisterRepositoryImpl();

    @Override
    public List<Register> findByDoctor(Integer doctorId) {
        return registerRepository.findByDoctorId(doctorId);
    }
}
