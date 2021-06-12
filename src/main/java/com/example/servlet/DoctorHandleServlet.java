package com.example.servlet;

import com.example.entity.*;
import com.example.service.DoctorHandleService;
import com.example.service.Impl.DoctorHandleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            case "handle": // 确认挂号状态
                Integer registerId = Integer.parseInt(req.getParameter("registerId"));
                Integer state = Integer.parseInt(req.getParameter("state"));
                doctorHandleService.changeState(registerId , state );
                Register register = doctorHandleService.findById(registerId);
                if(state == 1) {
                    // 增加一条病例，即增加一条Treat记录
                    Map<Drug, Integer> drug_list = new HashMap<>();
                    doctorHandleService.addTreat(register.getPatient()  , register.getDoctor() , "" , "" );
                }

            case "caseHandle": // 病例管理
                Integer doctorId = doctor.getId();
                // 显示该医生所有已确认的病例
                List<Treat> treatList =  doctorHandleService.findByDoctorId(doctorId );
                req.setAttribute("treatList" , treatList);
                req.getRequestDispatcher("/jsp/doctor/case.jsp") .forward(req  ,resp);
                break;

            case "displayDiagnose":
                // 修改当前Treat记录，添加患者症状、诊断信息以及开处方
                Integer treatId = Integer.parseInt(req.getParameter("treatId"));
                Treat treat = doctorHandleService.findTreatById(treatId);
                // 处方信息
                List<GetDrug> getDrugList = doctorHandleService.findGetDrugByTreatId(treatId);
                List<String> drugInfoList = new ArrayList<>();
                for(GetDrug getDrug : getDrugList) {
                    drugInfoList.add(getDrug.getDrugInfo());
                }
                req.setAttribute("drugInfoList" , drugInfoList);
                req.setAttribute("getDrugList" , getDrugList);
                req.setAttribute("treat" , treat);
                req.getRequestDispatcher("/jsp/doctor/diagnose.jsp").forward(req , resp);
                break;
            case "getDrug": // 取药页面
                List<Drug> drugList = doctorHandleService.findAllDrugs();  // 返回所有药品
                treatId = Integer.parseInt(req.getParameter("treatId"));
                req.setAttribute("treatId" , treatId);
                req.setAttribute("drugList" , drugList);
                getDrugList = doctorHandleService.findGetDrugByTreatId(treatId);
                drugInfoList = new ArrayList<>();
                for(GetDrug getDrug : getDrugList) {
                    drugInfoList.add(getDrug.getDrugInfo());
                }
                req.setAttribute("drugInfoList" , drugInfoList);
                req.setAttribute("getDrugList" , getDrugList);
                req.getRequestDispatcher("/jsp/doctor/getDrug.jsp").forward(req , resp);
                break;

        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        HttpSession session = req.getSession();
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        if(method == null) {
            method = "findByDoctor";
        }

        switch (method) {
            case "findByDoctor":
                break;
            case "addDiagnose":
                // 修改当前患者病历
                Integer treatId = Integer.parseInt(req.getParameter("treatId"));
                Treat treat = doctorHandleService.findTreatById(treatId);
                String symptom = req.getParameter("symptom");
                String diagnose = req.getParameter("diagnose");

                // 更新treat记录
                doctorHandleService.updateDiagnose(treatId , symptom , diagnose);
                treat = doctorHandleService.findTreatById(treatId);

                // 处方信息
                List<GetDrug> getDrugList = doctorHandleService.findGetDrugByTreatId(treatId);
                List<String> drugInfoList = new ArrayList<>();
                for(GetDrug getDrug : getDrugList) {
                    drugInfoList.add(getDrug.getDrugInfo());
                }
                req.setAttribute("drugInfoList" , drugInfoList);
                req.setAttribute("getDrugList" , getDrugList);

                req.setAttribute("treat" , treat);
                req.getRequestDispatcher("/jsp/doctor/diagnose.jsp").forward(req , resp);

                break;
            case "addDrug":
                treatId = Integer.parseInt(req.getParameter("treatId"));
                req.setAttribute("treatId" , treatId);
                String drugName = req.getParameter("drugName");
                Integer drugNum = Integer.parseInt(req.getParameter("drugNum"));
                int i = 0;

                doctorHandleService.addOneDrug(treatId , drugName , drugNum  );  // 添加一条取药记录
                getDrugList = doctorHandleService.findGetDrugByTreatId(treatId);
                drugInfoList = new ArrayList<>();
                for(GetDrug getDrug : getDrugList) {
                    drugInfoList.add(getDrug.getDrugInfo());
                }
                req.setAttribute("drugInfoList" , drugInfoList);
                req.setAttribute("getDrugList" , getDrugList);
                req.getRequestDispatcher("/jsp/doctor/getDrug.jsp").forward(req , resp);

        }
    }
}
