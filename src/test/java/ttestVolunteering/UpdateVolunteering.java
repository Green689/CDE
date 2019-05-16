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
public class UpdateVolunteering {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Boolean rs;
        String date = "2019-02-02";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        Date datet = Date.valueOf(date);
        rs = VolunteeringDao.update(
                new Volunteering("21k", 50, datet, 1)
        );
        System.out.println("holaa " + rs);
    }
}
