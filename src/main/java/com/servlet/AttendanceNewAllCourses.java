/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.CourseDao;
import com.dao.StudentDao;
import com.model.Course;
import com.model.Student;
import java.io.IOException;
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
 * @author oswal
 */
/**
 *
 * extrae los cursos de la base de datos par apoder mostrarlos en el agregar
 * asistencia
 */
public class AttendanceNewAllCourses extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        int idSt = Integer.parseInt(id);

        try {

            Student student = StudentDao.getByIdStudent(idSt);
            List<Course> course = CourseDao.all();

            request.setAttribute("stu", student);
            request.setAttribute("courses", course);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al extraer los cursos, y el estudiante " + ex.getMessage());
        }
        request.getRequestDispatcher("newAttendance.jsp").forward(request, response);
    }

}
