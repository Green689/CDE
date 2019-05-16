/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testAttendance;

import com.dao.AttendanceDao;
import com.model.Attendance;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author oswal
 */
public class ShowAttendance {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        List<Attendance> attendance = AttendanceDao.all(1);
        for (Attendance att : attendance) {
            System.out.println("Esto es: " + att.getIdAt() + att.getIdStu() + att.getIdCou() + att.getDescription() + att.getSkipCourse() + att.getDate() + att.getHours());
        }
    }
}
