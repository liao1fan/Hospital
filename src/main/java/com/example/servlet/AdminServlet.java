package com.example.servlet;

import com.example.entity.Admin;
import com.example.entity.Department;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.repository.DepartmentRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.Impl.DepartmentRepositoryImpl;
import com.example.repository.Impl.DoctorRepositoryImpl;
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
    private DepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    private DoctorRepository doctorRepository = new DoctorRepositoryImpl();
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
            case "alterDepartmentPhone":
                Integer departmentId = Integer.parseInt(req.getParameter("departmentId"));
                Department department = departmentRepository.findByDepartmentId(departmentId);
                req.setAttribute("department" , department);
                req.getRequestDispatcher("jsp/admin/alterDepartmentPhone.jsp").forward(req , resp);
                break;
            case "addDepartment":
                resp.sendRedirect("/jsp/admin/addDepartment.jsp");
                break;
            case "addDoctor":
                resp.sendRedirect("jsp/admin/addDoctor.jsp");
                break;
            case "deleteDoctor":
                Integer doctorId = Integer.parseInt(req.getParameter("doctorId"));
                doctorRepository.deleteById(doctorId);
                resp.sendRedirect("/admin?method=alterDoctor");
                break;
            case "alterDoctorInfo":
                doctorId = Integer.parseInt(req.getParameter("doctorId"));
                Doctor doctor = doctorRepository.findByDoctorId(doctorId);
                req.setAttribute("doctor" , doctor);
                req.getRequestDispatcher("/jsp/admin/alterDoctorInfo.jsp").forward(req , resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        HttpSession session = req.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        switch (method) {
            case "alterPhone":
                String phone = req.getParameter("phone");
                Integer departmentId = Integer.parseInt(req.getParameter("departmentId"));
                departmentRepository.alterPhone(departmentId , phone);
                resp.sendRedirect("/admin?method=alterDepartment");
                break;
            case "addDepartment":
                String name = req.getParameter("name");
                phone  = req.getParameter("phone");
                departmentRepository.add(name , phone);
                resp.sendRedirect("/admin?method=alterDepartment");
                break;
            case "addDoctor":
                name = req.getParameter("name");
                Integer age = Integer.parseInt(req.getParameter("age"));
                String sex = req.getParameter("sex");
                String title = req.getParameter("title");
                String speciality= req.getParameter("speciality");
                String departmentName = req.getParameter("departmentName");
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                adminService.addDoctor(name , age , sex ,title , speciality , departmentName , username , password);
                resp.sendRedirect("/admin?method=alterDoctor");
                break;
            case "alterDoctor":
                Integer doctorId = Integer.parseInt(req.getParameter("doctorId"));
                age = Integer.parseInt(req.getParameter("age"));
                title = req.getParameter("title");
                speciality = req.getParameter("speciality");
                departmentName = req.getParameter("departmentName");
                departmentId = departmentRepository.findByDepartmentName(departmentName).getId();
                doctorRepository.alter(doctorId , age , title , speciality , departmentId );
                resp.sendRedirect("/admin?method=alterDoctor");
                break;
        }
    }
}
