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
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oswal servlet que realiza el update de el voluntariado
 */
public class VolunteeringEdit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String description = request.getParameter("description");
        int hours = Integer.parseInt(request.getParameter("hours"));
        String date = request.getParameter("date");
        int idVo = Integer.parseInt(request.getParameter("idVo"));

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        Date datet = Date.valueOf(date);
        VolunteeringDao.update(
                new Volunteering(description, hours, datet, idVo)
        );
        request.getRequestDispatcher("StudentList").forward(request, response);
    }

}
