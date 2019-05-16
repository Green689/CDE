/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;
//hacesmos las importaciones que se necesitaran para la coneccion a la BD

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author oswal creamos nuestra clase conneccion
 */
public class Conection {

    // creamos las variables que necesitaremos para hacer la conexion a la base de datos
    private static Connection con;
    private static String cadenaCone;
    private static Boolean conectado = false;

    //iniciamos a crear la coneccion
    public static Connection getConection() throws ClassNotFoundException {
        //instanciamos las variables, y le agregamos un try catch por si llega a surgir un error
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cadenaCone = "jdbc:mysql://localhost:3306/CDEE?useSSL=false";
            con = DriverManager.getConnection(cadenaCone, "root", "1234");
            return con;
        } catch (SQLException ex) {
            System.out.println("Surgio un error al conectar a la base de datos " + ex);
        }
        return null;
    }
    //creamos un metodo para cerrar la conexion a la BD

    public static void close() throws SQLException {
        if (conectado == true) {
            con.close();
        }
    }

}
