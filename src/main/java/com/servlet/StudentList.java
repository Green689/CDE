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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
*creamos el servlet que va a enviar la lista de estudiantes al jsp
*
 */
public class StudentList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Student> students = StudentDao.all();
            request.setAttribute("students", students);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al recibir la lista de estudiantes " + ex);
        }
        request.getRequestDispatcher("listStudent.jsp").forward(request, response);
    }
}
