/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.AttendanceDao;
import com.model.Attendance;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oswal servlet para editar la asistencia de un estudiante
 */
public class AttendanceEdit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String description = request.getParameter("description");
        String date = request.getParameter("date");
        boolean skipCourse = Boolean.parseBoolean(request.getParameter("skipCourse"));
        int idAt = Integer.parseInt(request.getParameter("idAt"));
        int hours = Integer.parseInt(request.getParameter("hours"));
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        Date datet = Date.valueOf(date);

        try {
            AttendanceDao.update(
                    new Attendance(description, skipCourse, hours, idAt, datet)
            );
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al editar la asistencia " + ex.getMessage());
        }
        request.getRequestDispatcher("StudentList").forward(request, response);
    }
}
