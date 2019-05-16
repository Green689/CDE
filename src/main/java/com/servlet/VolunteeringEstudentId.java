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
 * @author oswal servlet para obtener el ide del estudiante, y de esa forma
 * poder voler al detalle
 */
public class VolunteeringEstudentId extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        int idSt = Integer.parseInt(id);

        Student student;
        try {
            student = StudentDao.getByIdStudent(idSt);
            request.setAttribute("stu", student);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(" error al obtener el estudiante para el boton " + ex);
        }

        request.getRequestDispatcher("newVolunteering.jsp").forward(request, response);

    }

}
