/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.VolunteeringDao;
import com.model.Volunteering;
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
 * @author oswal servlet para ingresar voluntariado
 */
public class VolunteeringNew extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String date = request.getParameter("date");
        String description = request.getParameter("description");
        int hoursEnd = Integer.parseInt(request.getParameter("hoursEnd"));
        int idSt = Integer.parseInt(request.getParameter("idSt"));

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        Date datet = Date.valueOf(date);

        try {
            VolunteeringDao.add(
                    new Volunteering(description, hoursEnd, datet, idSt)
            );
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al ingresar nuevo voluntariado " + ex);
        }
        request.getRequestDispatcher("StudentList").forward(request, response);
    }

}
