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

    static String url = "jdbc:mysql://localhost:3306/";
    public static String NomDB = "digimon_bd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String usuarioBD = "root";
    static String passs = "santabarbara40";
    public static Connection con;

    public static Connection conexion() {
        try {

            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url + NomDB + usuarioBD + passs);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("show databases;");
            System.out.println("Connected");

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
