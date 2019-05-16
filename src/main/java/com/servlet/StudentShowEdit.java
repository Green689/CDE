/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.StudentDao;
import com.model.Student;
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
 * @author oswal servlet que extrae la informacion dle estudiante a editar
 */
public class StudentShowEdit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        int idSt = Integer.parseInt(id);
        Student student;
        try {
            student = StudentDao.getByIdStudent(idSt);
            request.setAttribute("stu", student);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentShowEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("editStudent.jsp").forward(request, response);
    }
}
