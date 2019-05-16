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
 * @author oswal servlet que extrae la informacion del sistema de informacion a
 * editar
 */
public class SystemInformationShowEdit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        int idSy = Integer.parseInt(id);
        SystemInformation sys;
        try {
            sys = SystemInformationDao.getByIdSystemInformation(idSy);
            request.setAttribute("sys", sys);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al obtener la informacion " + ex.getMessage());
        }
        request.getRequestDispatcher("editSystemInformation.jsp").forward(request, response);
    }

}
