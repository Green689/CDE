/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.StudentDao;
import com.model.Student;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oswal servlet el cual crea a el nuevo estudiante
 */
public class StudentNew extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String direction = request.getParameter("direction");
        String email = request.getParameter("email");
        boolean active = Boolean.parseBoolean(request.getParameter("active"));

        try {
            StudentDao.add(
                    new Student(name, gender, age, direction, email, active)
            );
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error en el servlet al ingresar estudiante :" + ex);
        }
        request.getRequestDispatcher("StudentList").forward(request, response);
    }
}
