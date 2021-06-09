package com.example.entity;

public class Doctor {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String title;
    private String speciality;
    private Department department;
    private String username ;
    private String password;

    public Doctor(Integer id, String name, String title  , String speciality) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.speciality = speciality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Doctor(Integer id, String name, Integer age, String sex, String title, String speciality, Department department, String username, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.title = title;
        this.speciality = speciality;
        this.department = department;
        this.username = username;
        this.password = password;
    }

    public Doctor(Integer id, String name, String title, String speciality, String username, String password) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.speciality = speciality;
        this.username = username;
        this.password = password;
    }

}
