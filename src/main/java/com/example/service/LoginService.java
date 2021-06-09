package com.example.service;

public interface LoginService {
    public Object login(String username  ,String password , String type);

    public boolean findByUsername(String username); //通过患者用户名寻找患者是否存在

    public boolean findDoctorByUsername(String username); //通过医生用户名寻找医生是否存在

    public boolean findAdminByUsername(String username); //通过管理员用户名寻找管理员是否存在
}
