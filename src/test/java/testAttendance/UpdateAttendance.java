/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testAttendance;

import com.dao.AttendanceDao;
import com.model.Attendance;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author oswal public class UpdateAttendan
 */
public class UpdateAttendance {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String date = "2019-02-02";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        Date datet = Date.valueOf(date);
        AttendanceDao.update(
                new Attendance("ououououo", false, 3, 1, datet)
        );
    }
}
