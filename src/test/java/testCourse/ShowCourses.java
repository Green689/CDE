/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCourse;

import com.dao.CourseDao;
import com.model.Course;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author oswal
 */
public class ShowCourses {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        List<Course> course = CourseDao.all();
        for (Course cou : course) {
            System.out.println("Esto es: " + cou.getIdCou() + "  " + cou.getDescription() + " " + cou.getHours() + " " + cou.getName());
        }
    }
}
