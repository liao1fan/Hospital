package com.example.filter;


import com.example.entity.Admin;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.service.Impl.LoginServiceImpl;
import com.example.service.Impl.SignUpServiceImpl;
import com.example.service.LoginService;
import com.example.service.SignupService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/login")
public class LoginFilter implements Filter {

    private static SignupService signupService = new SignUpServiceImpl();

    private static LoginService loginService = new LoginServiceImpl();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("utf-8");
        String type = req.getParameter("type");
        switch (type) {
            case "patient":
                String username = req.getParameter("username");
                boolean stateUsername = loginService.findByUsername(username);
                if(stateUsername == false) { // 用户名不存在
                    req.setAttribute("stateUser" , "1");  // 1表示用户名不存在
                    req.getRequestDispatcher("/login1.jsp").forward(req , resp);
                } else { // 用户存在，检查密码是否正确
                    String password = req.getParameter("password");
                    Patient patient = (Patient) loginService.login(username , password , "patient");
                    if(patient == null) {
                        req.setAttribute("stateUser" , "2");  // 2表示密码错误
                        req.getRequestDispatcher("/login1.jsp").forward(req , resp);
                    }
                    else {
                        filterChain.doFilter(req  , resp);
                    }
                }
                break;
            case "doctor":
                username = req.getParameter("username");
                stateUsername = loginService.findDoctorByUsername(username);
                if(stateUsername == false) { // 用户名不存在
                    req.setAttribute("stateUser" , "1");  // 1表示用户名不存在
                    req.getRequestDispatcher("/login1.jsp").forward(req , resp);
                } else { // 用户存在，检查密码是否正确
                    String password = req.getParameter("password");
                    Doctor doctor = (Doctor) loginService.login(username , password , "doctor");
                    if(doctor == null) {
                        req.setAttribute("stateUser" , "2");  // 2表示密码错误
                        req.getRequestDispatcher("/login1.jsp").forward(req , resp);
                    }
                    else {
                        filterChain.doFilter(req  , resp);
                    }
                }
                break;
            case "admin":
                username = req.getParameter("username");
                stateUsername = loginService.findAdminByUsername(username);
                if(stateUsername == false) { // 用户名不存在
                    req.setAttribute("stateUser" , "1");  // 1表示用户名不存在
                    req.getRequestDispatcher("/login1.jsp").forward(req , resp);
                } else { // 用户存在，检查密码是否正确
                    String password = req.getParameter("password");
                    Admin admin = (Admin) loginService.login(username , password , "admin");
                    if(admin == null) {
                        req.setAttribute("stateUser" , "2");  // 2表示密码错误
                        req.getRequestDispatcher("/login1.jsp").forward(req , resp);
                    }
                    else {
                        filterChain.doFilter(req  , resp);
                    }
                }
                break;
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
