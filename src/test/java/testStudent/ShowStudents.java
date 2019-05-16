/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testStudent;

import com.dao.StudentDao;
import com.model.Student;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author oswal
 */
public class ShowStudents {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        List<Student> student = StudentDao.all();
        for (Student stu : student) {
            System.out.println("Esto es: " + stu.getName() + stu.getDirection() + stu.getAge() + stu.getGender() + stu.getActive());
        }
    }
}
