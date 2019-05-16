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
public class CreateCourse {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CourseDao.add(
                new Course("Programacion", "", 250)
        );
    }
}
