/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
//hacemos los imports que vamos a utilizar

import com.connection.Conection;
import com.model.SystemInformation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oswal metodos que se usaran para manipular la informacion de la base
 * de datos del sistema de informacion
 */
public class SystemInformationDao {

    //iniciamos la creacion del metodo de agregar
    public static boolean add(SystemInformation systemInformation) throws ClassNotFoundException, SQLException {
        //instanceamos la coneccion a la base de datos
        Connection con = Conection.getConection();
        //instanciamos una variable para que contenga la sentencia sql a ejecutar
        String sql = "insert into informacion_sistema values(null, ?, ?)";
        //le enviamps los datos a utilizar, e instanciamos el metodo preparedStatement
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, systemInformation.getDescription());
        ps.setInt(2, systemInformation.getValue());
        //creamos un try catch por si llega a fallar en ejecutar la sentencia sql
        try {
            ps.executeLargeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ingresar informacion en la BD " + e);
        }
        //cerramos nuestra coneccion a la BD
        ps.close();
        con.close();
        return false;
    }

    //inicamos la creacin de un metodo para optener la lista
    public static List<SystemInformation> all() throws ClassNotFoundException, SQLException {
        //instanciamos nuestra coneccion a la BD
        Connection con = Conection.getConection();
        //creamos nuestra sentencia sql para optener todos los existentes
        String sql = "select * from informacion_sistema";
        //instanciamos el metodo preparedStatement
        PreparedStatement ps = con.prepareStatement(sql);
        //ejecutamos la sentencia sql
        ResultSet rs = ps.executeQuery();
        //creamos e instanceamos una lista
        List<SystemInformation> list1 = new ArrayList<>();
        //por medio de un ciclo optenemos los atributos necesarios a utilizar
        while (rs.next()) {
            list1.add(new SystemInformation(
                    rs.getInt("id_si"),
                    rs.getString("descripcion"),
                    rs.getInt("valor")
            ));
        }
        //cerramos nuestra instancia a la BD, y returnamos una lista
        rs.close();
        ps.close();
        con.close();
        return list1;
    }

    //iniciamos la creacion de un metodo para actualizar
    public static boolean update(SystemInformation systemInformation) throws ClassNotFoundException, SQLException {
        //instanciamos la conecion a la BD
        int row;
        Connection con = Conection.getConection();
        //cramos nuestra sentencia sql
        String sql = "update informacion_sistema set descripcion = ?, valor = ? where id_si = ?;";
        //cambiamos los signos de interrogacion por la informacion a la que queremos actualizar
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(3, systemInformation.getIdSy());
        ps.setString(1, systemInformation.getDescription());
        ps.setInt(2, systemInformation.getValue());
        row = ps.executeUpdate();
        ps.close();
        con.close();
        return row == 1;

    }

    //iniciamos la creacion de un metodo para optener un infromacion del sistema
    public static SystemInformation getByIdSystemInformation(int id) throws ClassNotFoundException, SQLException {
        //creamos una variable de tipo infromacion del sistema, e instanciamos nuestra coneccion a la base de datos
        SystemInformation sys;
        Connection con = Conection.getConection();
        //creamos la sentencia sql para poder realizar el select
        String sql = "Select * from informacion_sistema where id_si = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        //reemplazamos el signo de interrogacion por el id lo que deseamos extraer de la base de datos
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        //extraemos los atributos de curso
        rs.first();
        sys = new SystemInformation(
                rs.getInt("id_si"), rs.getString("descripcion"),
                rs.getInt("valor")
        );
        //cerramos nuestra instancia a la base de datos, y enviamos el objeto
        rs.close();
        ps.close();
        con.close();

        return sys;
    }

    //iniciamos la creacion de un metodo para optener un infromacion del sistema faltante de un alumno
    public static SystemInformation getByIdSystemInformationS(int id) throws ClassNotFoundException, SQLException {
        //creamos una variable de tipo infromacion del sistema, e instanciamos nuestra coneccion a la base de datos
        SystemInformation sys;
        Connection con = Conection.getConection();
        //creamos la sentencia sql para poder realizar el select
        String sql = "SELECT valor - SUM(horas_realizadas) as valor from estudiante, informacion_sistema, voluntariado where voluntariado.id_est = estudiante.id_es and id_es = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        //reemplazamos el signo de interrogacion por el id lo que deseamos extraer de la base de datos
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        //extraemos los atributos de curso
        rs.first();
        sys = new SystemInformation(
                rs.getInt("valor")
        );
        //cerramos nuestra instancia a la base de datos, y enviamos el objeto
        rs.close();
        ps.close();
        con.close();

        return sys;
    }
}
