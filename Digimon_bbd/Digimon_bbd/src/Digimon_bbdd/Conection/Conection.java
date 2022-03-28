/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd.Conection;

import java.sql.*;

/**
 *
 * @author Marek
 */
public class Conection {

    public static String NomDB = "jdbc:mysql://localhost:3306/digimon_bd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String usuarioBD = "root";
    static String pass = "santabarbara40";
    public static Connection con;

    public static Connection conexion() {
        try {

            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(NomDB, usuarioBD, pass);
            // Al realizar la conexion imprime la palabra 'connected'
            // System.out.println("Connected");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }

    public static void cerrarConexion() {

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerra la conexion" + e);
        }

    }

}
