package com.example.servlet;

import com.example.entity.Doctor;
import com.example.entity.Register;
import com.example.service.DoctorHandleService;
import com.example.service.Impl.DoctorHandleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/doctorHandle")
public class DoctorHandleServlet extends HttpServlet {

    private static DoctorHandleService doctorHandleService = new DoctorHandleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        HttpSession session = req.getSession();
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        if(method == null) {
            method = "findByDoctor";
        }
        switch (method) {
            case "findByDoctor": // 展示医生信息
                req.getRequestDispatcher("/jsp/doctor/doctor_info.jsp").forward(req , resp);
                break;
            case "RegisterHandle": // 挂号管理
                List<Register> registerList = doctorHandleService.findByDoctor(doctor.getId()); // 通过医生ID找出所有与该医生相关的挂号记录
                req.setAttribute("registerList", registerList);
                req.getRequestDispatcher("/jsp/doctor/RegisterHandle.jsp").forward(req , resp);
                break;
            case "": // 病例管理
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
