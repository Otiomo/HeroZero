package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.*;
import com.dao.DAO;



@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO registerDao;

    public void init() {
        registerDao = new DAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        RegisterBean employee = new RegisterBean();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setEmail(email);
        employee.setAddress(address);

        try {
            registerDao.registerEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("registersuccess.jsp");
    }
}
