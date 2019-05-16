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
public class UpateStudent {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        StudentDao.update(
                new Student(1, "Juan Andres Celon Cartas", "masculino", "17", "8va avenida 2-14 zona 3", "juan@gmail.com", true)
        );
    }
}
