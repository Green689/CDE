/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttestVolunteering;

import com.dao.VolunteeringDao;
import com.model.Volunteering;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author oswal
 */
public class CreateVolunteering {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String date = "2019-02-02";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        Date datet = Date.valueOf(date);
        VolunteeringDao.add(
                new Volunteering("limpiar calles", 25, datet, 1)
        );
    }
}
