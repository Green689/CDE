/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
//realizamos los import a utilizar

import com.connection.Conection;
import com.model.Attendance;
import com.model.Course;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oswal metodos que se usaran para manipular la informacion de la base
 * de datos de la asistencia
 */
public class AttendanceDao {

    //iniciamos la creacion del metodo de agregar asistencia
    public static boolean add(Attendance attendance) throws ClassNotFoundException, SQLException {
        //instanceamos la coneccion a la base de datos
        Connection con = Conection.getConection();
        //instanciamos una variable para que contenga la sentencia sql a ejecutar
        String sql = "insert into asistencia values(null, ?, ?, ?, ?, ?, ?)";
        //le enviamps los datos a utilizar, e instanciamos el metodo preparedStatement
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(5, attendance.getIdStu());
        ps.setInt(6, attendance.getIdCou());
        ps.setDate(1, Date.valueOf(attendance.getDate()));
        ps.setString(2, attendance.getDescription());
        ps.setBoolean(3, attendance.getSkipCourse());
        ps.setInt(4, attendance.getHours());
        //creamos un try catch por si llega a fallar en ejecutar la sentencia sql
        try {
            ps.executeLargeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ingresar asistencia en la BD " + e);
        }
        //cerramos nuestra coneccion a la BD
        ps.close();
        con.close();
        return false;
    }

    //inicamos la creacin de un metodo para optener la lista de asistencia
    public static List<Attendance> all(int id) throws ClassNotFoundException, SQLException {
        //instanciamos nuestra coneccion a la BD
        Connection con = Conection.getConection();
        //creamos nuestra sentencia sql para optener todas las asistencias existentes de un estudiante
        String sql = "select id_as, id_est, id_cur, curso.nombre, asistencia.fecha, asistencia.descripcion, asistencia.falta, asistencia.horas from asistencia, estudiante, curso where asistencia.id_est = estudiante.id_es and asistencia.id_cur = curso.id_cu and id_es = ?";
        //instanciamos el metodo preparedStatement
        PreparedStatement ps = con.prepareStatement(sql);
        //cambiamos el signo de interrogacion por el id del estudiante
        ps.setInt(1, id);
        //ejecutamos la sentencia sql
        ResultSet rs = ps.executeQuery();
        //creamos e instanceamos una lista de tipo estudiante
        List<Attendance> list1 = new ArrayList<>();
        //por medio de un ciclo optenemos los atributos necesarios a utilizar
        while (rs.next()) {
            list1.add(new Attendance(
                    rs.getInt("id_as"),
                    rs.getInt("id_est"),
                    rs.getInt("id_cur"),
                    rs.getDate("fecha"),
                    rs.getString("descripcion"),
                    rs.getBoolean("falta"),
                    rs.getInt("horas"),
                    new Course(
                            rs.getString("nombre")
                    )
            ));
        }
        //cerramos nuestra instancia a la BD, y returnamos una lista
        rs.close();
        ps.close();
        con.close();
        return list1;
    }

    //iniciamos la creacion de un metodo para actualizar un asistencia
    public static boolean update(Attendance attendance) throws ClassNotFoundException, SQLException {
        //instanciamos la conecion a la BD
        int row;
        Connection con = Conection.getConection();
        //cramos nuestra sentencia sql
        String sql = "update asistencia set descripcion = ?, falta = ?, horas = ?, fecha = ? where id_as=?;";
        //cambiamos los signos de interrogacion por la informacion a la que queremos actualizar
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, attendance.getDescription());
        ps.setBoolean(2, attendance.getSkipCourse());
        ps.setInt(3, attendance.getHours());
        ps.setInt(5, attendance.getIdAt());
        ps.setDate(4, Date.valueOf(attendance.getDate()));
        row = ps.executeUpdate();
        ps.close();
        con.close();
        return row == 1;

    }
    //iniciamos la creacion de un metodo para optener un la asistencia

    public static Attendance getByIdAttendance(int id) throws ClassNotFoundException, SQLException {
        //creamos una variable de tipo asistencia, e instanciamos nuestra coneccion a la base de datos
        Attendance att;
        Connection con = Conection.getConection();
        //creamos la sentencia sql para poder realizar el select
        String sql = "Select * from asistencia where id_as = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        //reemplazamos los signos de interrogacion por el id de la asistencia que deseamos extraer de la base de datos
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        //extraemos los atributos de la asistencia a utilizar
        rs.first();
        att = new Attendance(
                rs.getInt("id_as"), rs.getInt("id_cur"), rs.getDate("fecha"),
                rs.getString("descripcion"), rs.getBoolean("falta"),
                rs.getInt("horas")
        );
        //cerramos nuestra instancia a la base de datos, y enviamos un objeto asistencia
        rs.close();
        ps.close();
        con.close();

        return att;
    }
}
