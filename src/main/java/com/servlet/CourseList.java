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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oswal servlet el cual extrae la lista de cursos
 */
public class CourseList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Course> courses = CourseDao.all();
            request.setAttribute("courses", courses);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al recibir la lista de cursos " + ex);
        }
        request.getRequestDispatcher("listCourse.jsp").forward(request, response);
    }

}
