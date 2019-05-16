/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.CourseDao;
import com.model.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oswal servlet para editar los cursos
 */
public class CourseEditt extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int hours = Integer.parseInt(request.getParameter("hours"));
        int idCo = Integer.parseInt(request.getParameter("idCo"));

        try {
            CourseDao.update(
                    new Course(idCo, name, description, hours)
            );
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al editar curso " + ex.getMessage());
        }
        request.getRequestDispatcher("CourseList").forward(request, response);
    }

}
