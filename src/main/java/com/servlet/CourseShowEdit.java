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
 * @author oswal sevlet que muestra la informacion del curso a editar
 */
public class CourseShowEdit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        int idCou = Integer.parseInt(id);
        Course course;
        try {
            course = CourseDao.getByIdCourse(idCou);
            request.setAttribute("cou", course);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al obtener el curso " + ex.getMessage());
        }
        request.getRequestDispatcher("editCourse.jsp").forward(request, response);
    }

}
