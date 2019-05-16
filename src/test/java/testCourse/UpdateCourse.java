/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCourse;

import com.dao.CourseDao;
import com.model.Course;
import java.sql.SQLException;

/**
 *
 * @author oswal
 */
public class UpdateCourse {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CourseDao.update(
                new Course(2, "Ingles", "Ingles Profesional", 240)
        );
    }
}
