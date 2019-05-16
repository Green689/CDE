/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
//hacemos todas la importaciones necesarias

import com.connection.Conection;
import com.model.Volunteering;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oswal metodos que se usaran para manipular la informacion de la base
 * de datos del voluntariado
 */
public class VolunteeringDao {
    //iniciamos la creacion del metodo de agregar voluntariado

    public static boolean add(Volunteering volunteering) throws ClassNotFoundException, SQLException {
        //instanceamos la coneccion a la base de datos
        Connection con = Conection.getConection();
        //instanciamos una variable para que contenga la sentencia sql a ejecutar
        String sql = "insert into voluntariado values(null, ?, ?, ?, ?)";
        //le enviamps los datos a utilizar, e instanciamos el metodo preparedStatement
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, volunteering.getDescription());
        ps.setInt(2, volunteering.getHoursEnd());
        ps.setDate(3, Date.valueOf(volunteering.getDate()));
        ps.setInt(4, volunteering.getIdStu());
        //creamos un try catch por si llega a fallar en ejecutar la sentencia sql
        try {
            ps.executeLargeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ingresar voluntariado en la BD " + e);
        }
        //cerramos nuestra coneccion a la BD
        ps.close();
        con.close();
        return false;
    }

    //inicamos la creacin de un metodo para optener la lista de el voluntariado realizado
    public static List<Volunteering> all(int id) throws ClassNotFoundException, SQLException {
        //instanciamos nuestra coneccion a la BD
        Connection con = Conection.getConection();
        //creamos nuestra sentencia sql para optener todo el voluntariado realizado por un alumno
        String sql = "select id_vo, descripcion, horas_realizadas, fecha from voluntariado, estudiante where voluntariado.id_est = estudiante.id_es and id_est=?";
        //instanciamos el metodo preparedStatement
        PreparedStatement ps = con.prepareStatement(sql);
        //le enviamos el atributo que queremos sustituir por el signo de interrogacion
        ps.setInt(1, id);
        //ejecutamos la sentencia sql
        ResultSet rs = ps.executeQuery();
        //creamos e instanceamos una lista de tipo voluntariado
        List<Volunteering> list1 = new ArrayList<>();
        //por medio de un ciclo optenemos los atributos necesarios a utilizar
        while (rs.next()) {
            list1.add(new Volunteering(
                    rs.getInt("id_vo"),
                    rs.getInt("horas_realizadas"),
                    rs.getString("descripcion"),
                    rs.getDate("fecha")
            ));
        }
        //cerramos nuestra instancia a la BD, y returnamos una lista
        rs.close();
        ps.close();
        con.close();
        return list1;
    }

    //iniciamos la creacion de un metodo para actualizar un volluntariado
    public static boolean update(Volunteering volunteering) {
        //instanciamos la conecion a la BD
        Connection con;
        //cramos nuestra sentencia sql
        String sql = "update voluntariado set descripcion = ?, horas_realizadas = ?, fecha = ? where id_vo = ?;";
        //cambiamos los signos de interrogacion por la informacion a la que queremos actualizar
        int row = 0;
        try {
            con = Conection.getConection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, volunteering.getDescription());
            ps.setInt(2, volunteering.getHoursEnd());
            ps.setDate(3, Date.valueOf(volunteering.getDate()));
            ps.setInt(4, volunteering.getIdVo());

            row = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("huidhsufd " + e);
        }

        return row == 1;
    }

    //iniciamos la creacion de un metodo para optener un voluntariado
    public static Volunteering getByIdVolunteering(int id) throws ClassNotFoundException, SQLException {
        //creamos una variable de tipo voluntariado, e instanciamos nuestra coneccion a la base de datos
        Volunteering vol;
        Connection con = Conection.getConection();
        //creamos la sentencia sql para poder realizar el select
        String sql = "Select * from voluntariado where id_vo = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        //reemplazamos los signos de interrogacion por el id del voluntariado que deseamos extraer de la base de datos
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        //extraemos los atributos del voluntariado a utilizar
        rs.first();
        vol = new Volunteering(
                rs.getInt("id_vo"), rs.getInt("horas_realizadas"), rs.getString("descripcion"),
                rs.getDate("fecha")
        );
        //cerramos nuestra instancia a la base de datos, y enviamos un objeto voluntariado
        rs.close();
        ps.close();
        con.close();

        return vol;
    }
}
