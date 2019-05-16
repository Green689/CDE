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
public class ShowCourse {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Course course = CourseDao.getByIdCourse(1);
        System.out.println("curso " + course.getName() + " horas " + course.getHours());
    }
}
