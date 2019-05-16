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
 * @author oswal agregar una nueva asistencia al estudiante
 */
public class AttendanceNew extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String description = request.getParameter("description");
        int idSt = Integer.parseInt(request.getParameter("id"));
        int idCou = Integer.parseInt(request.getParameter("course"));
        String date = request.getParameter("date");
        Boolean skipCourse = Boolean.parseBoolean(request.getParameter("skipCourse"));
        int hours = Integer.parseInt(request.getParameter("hours"));

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        Date datet = Date.valueOf(date);

        try {
            AttendanceDao.add(
                    new Attendance(idSt, idCou, datet, description, skipCourse, hours)
            );
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("fallo el ingreso de la asistencia " + ex.getMessage());
        }
        request.getRequestDispatcher("StudentList").forward(request, response);
    }

}
