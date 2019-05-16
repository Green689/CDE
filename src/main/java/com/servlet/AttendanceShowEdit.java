/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.AttendanceDao;
import com.dao.CourseDao;
import com.dao.StudentDao;
import com.model.Attendance;
import com.model.Course;
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
 * @author oswal servlet que extrae la informacion de la asistencia a editar
 */
public class AttendanceShowEdit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        int idAt = Integer.parseInt(id);
        String ids = request.getParameter("ids");
        int idSt = Integer.parseInt(ids);
        Attendance attendance;
        Student student;
        Course course;
        try {
            attendance = AttendanceDao.getByIdAttendance(idAt);
            student = StudentDao.getByIdStudent(idSt);
            request.setAttribute("att", attendance);
            request.setAttribute("stu", student);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al obtener la asistencia " + ex.getMessage());
        }
        request.getRequestDispatcher("editAttendance.jsp").forward(request, response);
    }

}
