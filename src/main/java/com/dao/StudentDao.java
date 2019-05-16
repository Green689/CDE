/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
//hacemos los respectivos imports que se utilizaran

import com.model.Student;
import com.connection.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oswal metodos que se usaran para manipular la informacion de la base
 * de datos del estudiante
 */
public class StudentDao {

    //iniciamos la creacion del metodo de agregar alumno
    public static boolean add(Student student) throws ClassNotFoundException, SQLException {
        //instanceamos la coneccion a la base de datos
        Connection con = Conection.getConection();
        //instanciamos una variable para que contenga la sentencia sql a ejecutar
        String sql = "insert into estudiante values(null, ?, ?, ?, ?, ?, ?)";
        //le enviamps los datos a utilizar, e instanciamos el metodo preparedStatement
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setString(2, student.getAge());
        ps.setString(3, student.getGender());
        ps.setString(4, student.getDirection());
        ps.setString(5, student.getEmail());
        ps.setBoolean(6, student.getActive());
        //creamos un try catch por si llega a fallar en ejecutar la sentencia sql
        try {
            ps.executeLargeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ingresar estudiante en la BD " + e);
        }
        //cerramos nuestra coneccion a la BD
        ps.close();
        con.close();
        return false;
    }

    //inicamos la creacin de un metodo para optener la lista de estudiantes
    public static List<Student> all() throws ClassNotFoundException, SQLException {
        //instanciamos nuestra coneccion a la BD
        Connection con = Conection.getConection();
        //creamos nuestra sentencia sql para optener todos los estudiantes existentes
        String sql = "select * from estudiante order by id_es DESC";
        //instanciamos el metodo preparedStatement
        PreparedStatement ps = con.prepareStatement(sql);
        //ejecutamos la sentencia sql
        ResultSet rs = ps.executeQuery();
        //creamos e instanceamos una lista de tipo estudiante
        List<Student> list1 = new ArrayList<>();
        //por medio de un ciclo optenemos los atributos necesarios a utilizar
        while (rs.next()) {
            list1.add(new Student(
                    rs.getInt("id_es"),
                    rs.getString("nombre"),
                    rs.getString("genero"),
                    rs.getString("edad"),
                    rs.getString("direccion"),
                    rs.getString("correo"),
                    rs.getBoolean("activo")
            ));
        }
        //cerramos nuestra instancia a la BD, y returnamos una lista
        rs.close();
        ps.close();
        con.close();
        return list1;
    }

    //iniciamos la creacion de un metodo para optener un alummno
    public static Student getByIdStudent(int id) throws ClassNotFoundException, SQLException {
        //creamos una variable de tipo estudiante, e instanciamos nuestra coneccion a la base de datos
        Student stu;
        Connection con = Conection.getConection();
        //creamos la sentencia sql para poder realizar el select
        String sql = "Select * from estudiante where id_es = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        //reemplazamos los signos de interrogacion por el id del alumno que deseamos extraer de la base de datos
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        //extraemos los atributos de estudiante a utilizar
        rs.first();
        stu = new Student(
                rs.getInt("id_es"), rs.getString("nombre"),
                rs.getString("genero"), rs.getString("edad"),
                rs.getString("direccion"), rs.getString("correo"),
                rs.getBoolean("activo")
        );
        //cerramos nuestra instancia a la base de datos, y enviamos un objeto estudiante
        rs.close();
        ps.close();
        con.close();

        return stu;
    }

    //iniciamos la creacion de un metodo para actualizar un estudiante
    public static boolean update(Student student) throws ClassNotFoundException, SQLException {
        //instanciamos la conecion a la BD
        int row;
        Connection con = Conection.getConection();
        //cramos nuestra sentencia sql
        String sql = "update estudiante set nombre = ?, edad = ?, correo = ?, activo = ?, genero = ?, direccion = ? where id_es = ?;";
        //cambiamos los signos de interrogacion por la informacion a la que queremos actualizar
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(7, student.getIdSt());
        ps.setString(1, student.getName());
        ps.setString(5, student.getGender());
        ps.setString(2, student.getAge());
        ps.setString(6, student.getDirection());
        ps.setString(3, student.getEmail());
        ps.setBoolean(4, student.getActive());
        row = ps.executeUpdate();
        ps.close();
        con.close();
        return row == 1;

    }
}
