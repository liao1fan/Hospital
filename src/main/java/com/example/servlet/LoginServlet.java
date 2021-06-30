package com.example.servlet;

import com.example.entity.Admin;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.service.Impl.LoginServiceImpl;
import com.example.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static LoginService loginService = new LoginServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String logintype = req.getParameter("logintype");

        switch (logintype) {

            case "登录":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String usertype = req.getParameter("type");
                HttpSession session = (HttpSession)req.getSession();
                Object object = loginService.login(username ,password , usertype );

                switch (usertype) {
                    case "patient":
                        // 将返回的用户存入session中
                        Patient patient = (Patient) object;
                        session.setAttribute("patient" , patient);
                        resp.sendRedirect("/register");
                        break;
                    case "doctor":
                        Doctor doctor = (Doctor) object;
                        session.setAttribute("doctor" , doctor);
                        resp.sendRedirect("/doctorHandle");
                        break;
                    case "admin":
                        Admin admin = (Admin) object;
                        session.setAttribute("admin" , admin);
                        resp.sendRedirect("admin");
                        break;
                }
                break;
            case "注册":
                resp.sendRedirect("/jsp/patient/signup1.jsp");
                break;
        }
    }
}
