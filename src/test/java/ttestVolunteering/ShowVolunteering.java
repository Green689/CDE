/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttestVolunteering;

import com.dao.VolunteeringDao;
import com.model.Volunteering;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author oswal
 */
public class ShowVolunteering {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        List<Volunteering> volunteering = VolunteeringDao.all(1);
        for (Volunteering vol : volunteering) {
            System.out.println("Esto es: " + vol.getIdVo() + vol.getDescription() + vol.getHoursEnd());
        }
    }
}
