/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
//realizamos los import a utilizar

import com.connection.Conection;
import com.model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oswal metodos que se usaran para manipular la informacion de la base
 * de datos de los cursos
 */
public class CourseDao {

    //iniciamos con la creacion de un metodo para optener curso
    public static boolean add(Course course) throws ClassNotFoundException, SQLException {
        //instanceamos la coneccion a la base de datos
        Connection con = Conection.getConection();
        //instanciamos una variable para que contenga la sentencia sql a ejecutar
        String sql = "insert into curso values(null, ?, ?, ?)";
        //le enviamps los datos a utilizar, e instanciamos el metodo preparedStatement
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, course.getName());
        ps.setString(2, course.getDescription());
        ps.setInt(3, course.getHours());
        //creamos un try catch por si llega a fallar en ejecutar la sentencia sql
        try {
            ps.executeLargeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ingresar curso en la BD " + e);
        }
        //cerramos nuestra coneccion a la BD
        ps.close();
        con.close();
        return false;
    }

    //inicamos la creacin de un metodo para optener la lista de cursos
    public static List<Course> all() throws ClassNotFoundException, SQLException {
        //instanciamos nuestra coneccion a la BD
        Connection con = Conection.getConection();
        //creamos nuestra sentencia sql par aoptener todos los cursos
        String sql = "select * from curso";
        //instanciamos el metodo preparedStatement
        PreparedStatement ps = con.prepareStatement(sql);
        //ejecutamos la sentencia sql
        ResultSet rs = ps.executeQuery();
        //creamos e instanceamos una lista de tipo curso
        List<Course> list1 = new ArrayList<>();
        //por medio de un ciclo optenemos los atributos necesarios a utilizar
        while (rs.next()) {
            list1.add(new Course(
                    rs.getInt("id_cu"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getInt("horas")
            ));
        }
        //cerramos nuestra instancia a la BD, y returnamos una lista
        rs.close();
        ps.close();
        con.close();
        return list1;
    }

    //iniciamos la creacion de un metodo para optener un curso
    public static Course getByIdCourse(int id) throws ClassNotFoundException, SQLException {
        //creamos una variable de tipo curso, e instanciamos nuestra coneccion a la base de datos
        Course cou;
        Connection con = Conection.getConection();
        //creamos la sentencia sql para poder realizar el select
        String sql = "Select * from curso where id_cu = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        //reemplazamos el signo de interrogacion por el id del curso que deseamos extraer de la base de datos
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        //extraemos los atributos de curso
        rs.first();
        cou = new Course(
                rs.getInt("id_cu"), rs.getString("nombre"),
                rs.getString("descripcion"), rs.getInt("horas")
        );
        //cerramos nuestra instancia a la base de datos, y enviamos un objeto curso
        rs.close();
        ps.close();
        con.close();

        return cou;
    }

    //iniciamos la creacion de un metodo para actualizar un curso
    public static boolean update(Course course) throws ClassNotFoundException, SQLException {
        //instanciamos la conecion a la BD, y creamos una variable que utilizaremos despues
        int row;
        Connection con = Conection.getConection();
        //cramos nuestra sentencia sql
        String sql = "update curso set nombre = ?, descripcion = ?, horas = ? where id_cu = ?;";
        //cambiamos los signos de interrogacion por la informacion a la que queremos actualizar
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(4, course.getIdCou());
        ps.setString(1, course.getName());
        ps.setString(2, course.getDescription());
        ps.setInt(3, course.getHours());
        row = ps.executeUpdate();
        //cerramos nuestra connecion a la base de datos
        ps.close();
        con.close();
        return row == 1;

    }
}
