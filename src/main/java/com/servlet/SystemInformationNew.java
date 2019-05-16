/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.SystemInformationDao;
import com.model.SystemInformation;
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
 * @author oswal servlet para ingresar nueva informacion del sistema
 */
public class SystemInformationNew extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String description = request.getParameter("description");
        int hours = Integer.parseInt(request.getParameter("hours"));

        try {
            SystemInformationDao.add(
                    new SystemInformation(description, hours)
            );
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al ingresar el sistema de informacion a la BD");
        }
        request.getRequestDispatcher("SystemInformationList").forward(request, response);
    }

}
