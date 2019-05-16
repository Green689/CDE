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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oswal servlet que extrae la lista de sistemas de informacion
 */
public class SystemInformationList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<SystemInformation> systemInformation = SystemInformationDao.all();
            request.setAttribute("systemInformation", systemInformation);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al recibir la lista de informacion del sistema " + ex);
        }
        request.getRequestDispatcher("listSystemInformation.jsp").forward(request, response);
    }

}
