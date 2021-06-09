package com.example.servlet;


import com.example.service.Impl.LoginServiceImpl;
import com.example.service.Impl.SignUpServiceImpl;
import com.example.service.LoginService;
import com.example.service.SignupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    private static SignupService signupService = new SignUpServiceImpl();

    private static LoginService loginService = new LoginServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        boolean state = loginService.findByUsername(username);
        if(state == false) {
            String name = req.getParameter("name");
            Integer age = Integer.parseInt(req.getParameter("age"));
            String sex = req.getParameter("sex");
            String address = req.getParameter("address");
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");
            signupService.AddPatient(username , password , name,age , sex , address , phone);

        }
//        else {
//            req.setAttribute("SignupState" , state);
//            req.getRequestDispatcher("signup.jsp").forward(req , resp);
//        }
        req.setAttribute("SignupState" , state);
        req.getRequestDispatcher("/jsp/patient/signup1.jsp").forward(req , resp);
    }
}
