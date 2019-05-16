/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.SystemInformationDao;
import com.model.SystemInformation;
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
 * @author oswal servlet para editar la informacion del sistema
 */
public class SystemInformationEdit extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String description = request.getParameter("description");
        int value = Integer.parseInt(request.getParameter("value"));
        int idSy = Integer.parseInt(request.getParameter("idSy"));

        try {
            SystemInformationDao.update(
                    new SystemInformation(idSy, description, value)
            );
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al editar el sistema de informacion " + ex.getMessage());
        }
        request.getRequestDispatcher("SystemInformationList").forward(request, response);
    }

}
