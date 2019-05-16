/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.StudentDao;
import com.dao.VolunteeringDao;
import com.model.Student;
import com.model.Volunteering;
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
 * @author oswal servlet que extrae la informacion del voluntariado a editar
 * para mostrarla
 */
public class VolunteeringShowEdit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        int idVo = Integer.parseInt(id);
        String ids = request.getParameter("ids");
        int idSt = Integer.parseInt(ids);
        Volunteering volunteering;
        Student student;

        try {
            volunteering = VolunteeringDao.getByIdVolunteering(idVo);
            student = StudentDao.getByIdStudent(idSt);
            request.setAttribute("vol", volunteering);
            request.setAttribute("stu", student);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al obtener el voluntariado " + ex.getMessage());
        }
        request.getRequestDispatcher("editVolunteering.jsp").forward(request, response);
    }

}
