/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.StudentDao;
import com.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oswal Editar la informacion del estudiante
 */
public class StudentEdit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idSt = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String direction = request.getParameter("direction");
        String email = request.getParameter("email");
        boolean active = Boolean.parseBoolean(request.getParameter("active"));

        try {
            StudentDao.update(
                    new Student(idSt, name, gender, age, direction, email, active)
            );
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error en el servlet al editar estudiante :" + ex);
        }
        request.getRequestDispatcher("StudentList").forward(request, response);
    }

}
