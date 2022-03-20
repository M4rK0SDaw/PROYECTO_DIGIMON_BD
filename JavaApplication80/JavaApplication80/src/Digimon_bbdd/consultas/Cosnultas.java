/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd.consultas;

import Digimon_bbdd.Conection.Conection;
import static Digimon_bbdd.Conection.Conection.con;
import java.sql.*;

/**
 *
 * @author marek
 *
 *
 * informacion de:
 * http://chuwiki.chuidiang.org/index.php?title=Ejemplo_con_createStatement
 */
public class Cosnultas {

    /**
     *
     * @param nombre
     */
    public static void consultaUsuario(String nombre) {
       Connection con = Conection.conexion();
        try {

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from " + Conection.NomDB + ".JUGADORES "
                    + "where NAME_J = " + nombre);

            while (rs.next()) {
                System.out.println(
                        rs.getString(1) + " "
                        + rs.getString(2));
            }
             rs.close();
        } catch (SQLException e) {

            System.out.println(e);

        } finally {
           Conection.cerrarConexion();
        }
        }
    

    public static void main(String[] args) {
        consultaUsuario("marek");
    }
}
