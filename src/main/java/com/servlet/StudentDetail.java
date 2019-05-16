/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.AttendanceDao;
import com.dao.StudentDao;
import com.dao.SystemInformationDao;
import com.dao.VolunteeringDao;
import com.model.Attendance;
import com.model.Student;
import com.model.SystemInformation;
import com.model.Volunteering;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oswal
 */
/**
 *
 * Servlet el cual manda los datos a mostrar en el detalle del estudiante
 */
public class StudentDetail extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        int idSt = Integer.parseInt(id);

        try {
            Student student = StudentDao.getByIdStudent(idSt);
            List<Attendance> attendance = AttendanceDao.all(idSt);
            List<Volunteering> volunteering = VolunteeringDao.all(idSt);
            SystemInformation sys = SystemInformationDao.getByIdSystemInformationS(idSt);

            request.setAttribute("stu", student);
            request.setAttribute("att", attendance);
            request.setAttribute("vol", volunteering);
            request.setAttribute("sys", sys);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al extraer el estudiante " + ex.getMessage());
        }
        request.getRequestDispatcher("detailStudent.jsp").forward(request, response);

    }

}
