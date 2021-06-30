package com.example.servlet;

import com.example.entity.Admin;
import com.example.entity.Department;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.service.AdminService;
import com.example.service.Impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*
 管理员功能：查询患者信息、修改科室信息、修改医生信息
*/
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        HttpSession session = req.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if(method == null) {
            method = "findAllPatient";
        }
        switch (method){
            case "findAllPatient":
                List<Patient> patientList = new ArrayList<>();
                patientList = adminService.findAllPatient();
                req.setAttribute("patientList" , patientList);
                req.getRequestDispatcher("jsp/admin/allPatient.jsp").forward(req,resp);
                break;
            case "alterDoctor":
                List<Doctor> doctorList = new ArrayList<>();
                doctorList = adminService.findAllDoctor();
                req.setAttribute("doctorList" , doctorList);
                req.getRequestDispatcher("jsp/admin/alterDoctor.jsp").forward(req,resp);
                break;
            case "alterDepartment" :
                List<Department> departmentList = new ArrayList<>();
                departmentList = adminService.findAllDepartment();
                req.setAttribute("departmentList" , departmentList);
                req.getRequestDispatcher("jsp/admin/alterDepartment.jsp").forward(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
