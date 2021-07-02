package com.example.servlet;

import com.example.entity.*;
import com.example.service.DoctorHandleService;
import com.example.service.Impl.DoctorHandleServiceImpl;
import com.example.service.Impl.RegisterServiceImpl;
import com.example.service.RegisterService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/register")
//用户挂号页面，显示科室信息
public class RegisterServlet extends HttpServlet {

    private static RegisterService registerService = new RegisterServiceImpl();

    private static DoctorHandleService doctorHandleService = new DoctorHandleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if(method == null) {
            method = "findAll";
        }
        switch (method) {
            case "findAll": // 选择科室
                List<Department> departmentList = registerService.findAll();
                req.setAttribute("list" , departmentList);
                req.getRequestDispatcher("/jsp/patient/department.jsp").forward(req, resp);
                break;
            case "findAllDoctor": //进入科室，选择日期和医生
                Integer departmentId = Integer.parseInt(req.getParameter("departmentId"));
                List<Doctor_state> doctorStateList = registerService.findAllDateByDepartmentId(departmentId);
                req.setAttribute("doctorStateList" ,  doctorStateList);
                Date dateFirst = doctorStateList.get(0).getDate();
                // 默认显示最早日期的所有医生
                List<Doctor_state> doctor_stateListDefault = new ArrayList<>();
                for(Doctor_state state : doctorStateList) {
                    if(state.getDate() == dateFirst) {
                        doctor_stateListDefault.add(state);
                    }
                }
                req.setAttribute("stateDateDefault" , dateFirst); // 默认日期为最早日期
                req.setAttribute("doctorStateDefault" , doctor_stateListDefault); // 将默认的医生状态列表发送到doctor.jsp
                req.setAttribute("departmentId" , departmentId);
//                req.setAttribute("dateList" , dateList);
                req.getRequestDispatcher("/jsp/patient/doctor.jsp").forward(req , resp);
                break;
            case "updateState": // 刷新当前日期的医生列表
                String idStr = req.getParameter("id"); // 日期的字符串表示
                Integer depId = Integer.parseInt(req.getParameter("departmentId"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
                List<Doctor_state> doctorStates = registerService.findAllDateByDepartmentId(depId); // 通过id查询的所有的医生记录
                List<Doctor_state> doctor_stateList = new ArrayList<>();
                for(Doctor_state doctor_state : doctorStates) {
                    if(doctor_state.getDate().toString().equals(idStr)){
                        doctor_stateList.add(doctor_state);
                    }
                }
                Date dateDefault = null;
                try {
                    dateDefault = simpleDateFormat.parse(idStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                doctorStateList = registerService.findAllDateByDepartmentId(depId);
                req.setAttribute("doctorStateList" ,  doctorStateList);
                req.setAttribute("departmentId" , depId);
                req.setAttribute("doctorStateDefault" , doctor_stateList);
                req.setAttribute("stateDateDefault" , dateDefault); // 更改默认日期
                req.getRequestDispatcher("/jsp/patient/doctor.jsp").forward(req , resp);
                break;
            case "displayCurrentDoctor":  // 确认挂号页面
                departmentId = Integer.parseInt(req.getParameter("departmentId"));
                Integer doctorStateId = Integer.parseInt(req.getParameter("doctorStateId"));
                Doctor_state doctor_state = registerService.findByDoctorStateId(doctorStateId);
                String departmentName = registerService.findByDepartmentId(doctor_state.getDoctor().getId()).getName();
                req.setAttribute("departmentId" , departmentId);
                req.setAttribute("doctor_state" , doctor_state);
                req.setAttribute("departmentName" , departmentName);
                req.getRequestDispatcher("/jsp/patient/register_info.jsp").forward(req , resp);
                break;
            case "addRegister":
                HttpSession session = req.getSession();
                Patient patient = (Patient) session.getAttribute("patient");
                doctorStateId = Integer.parseInt(req.getParameter("doctorStateId")) ;
                doctor_state = registerService.findByDoctorStateId(doctorStateId);
                registerService.addRegister(patient.getId() , doctor_state.getDoctor().getId()  , doctor_state.getDate() ,
                        doctor_state.getFee() , 0 ); // state = 0 表示挂号成功但未处理
                registerService.changeNum(doctorStateId);
                break;
            case "patientCase":
                Integer patientId = Integer.parseInt(req.getParameter("patientId"));
                List<Treat> treatList = new ArrayList<>();
                treatList = registerService.findAllTreatByPatientId(patientId);
                req.setAttribute("treatList" , treatList);
                req.getRequestDispatcher("/jsp/patient/patientCase.jsp").forward(req,resp);
                break;
            case "patientDiagnose":
                Integer treatId = Integer.parseInt(req.getParameter("treatId"));
                Treat treat = registerService.findTreatByTreatId(treatId);
                List<GetDrug> getDrugList = doctorHandleService.findGetDrugByTreatId(treatId);
                List<String> drugInfoList = new ArrayList<>();
                for(GetDrug getDrug : getDrugList) {
                    drugInfoList.add(getDrug.getDrugInfo());
                }
                Double DrugTotalCost = 0.0;
                for(GetDrug getDrug : getDrugList) {
                    DrugTotalCost += getDrug.getDrugTotalCost();
                }
                Double cost = Double.parseDouble(String.format("%.2f",DrugTotalCost));
                req.setAttribute("drugTotalCost" , cost);
                req.setAttribute("drugInfoList" , drugInfoList);
                req.setAttribute("getDrugList" , getDrugList);
                req.setAttribute("treat" , treat);
                req.getRequestDispatcher("/jsp/patient/patientDiagnose.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
