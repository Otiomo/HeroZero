package com.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.*;
import com.dao.*;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO loginDao;

    public void init() {
        loginDao = new DAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        try {
            if (loginDao.validate(loginBean)) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUsername", username); // Saving username as "loggedInUsername" in the HttpSession
                response.sendRedirect("listedit");
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}