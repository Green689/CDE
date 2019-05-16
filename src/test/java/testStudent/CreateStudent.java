/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testStudent;

import com.dao.StudentDao;
import com.model.Student;
import java.sql.SQLException;

/**
 *
 * @author oswal
 */
public class CreateStudent {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        StudentDao.add(
                new Student("Jimana", "Femenino", "8", "fdsajhkjfe", "gefwedfe", false)
        );
    }
}
