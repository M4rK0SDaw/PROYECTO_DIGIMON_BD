/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd.consultas;

import Digimon_bbdd.Conection.Conection;

import java.sql.*;

/**
 * @author marek
 * <p>
 * <p>
 * informacion de:
 * http://chuwiki.chuidiang.org/index.php?title=Ejemplo_con_createStatement
 */
public class Consultas {

    /**
     * @param nombre
     * @return
     */
    public static boolean consultaCredencialesUsuario(String nombre, String contrasenya) {
        //iniciamos el comprobador en false
        boolean comp = false;
        //nos conectamnos en la base de datos
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            Statement s = con.createStatement();
            //bucle para sacar todos la informacion
            try ( //creamos las consulta
                     ResultSet rs = s.executeQuery(
                            "select * from " + Conection.NomDB + ".JUGADORES "
                            + "where NAME_J = " + nombre + " and Passwrd = " + contrasenya
                            + " and Administrador = false")) {
                //bucle para sacar todos la informacion
                while (rs.next()) {
                    comp = true;
                    System.out.println(rs.getString(1) + " " + rs.getString(2));
                }
                //cerramos la conexion
            }
        } catch (SQLException e) {

            System.out.println(e);

        }
        return comp;
    }

    public static boolean consultaExisteUsuario(String usuario) {
        boolean comp = false;
        //nos conectamnos en la base de datos
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            Statement s = con.createStatement();
            //bucle para sacar todos la informacion
            try ( //creamos las consulta
                     ResultSet rs = s.executeQuery("select * from " + Conection.NomDB + ".JUGADORES "
                            + "where NAME_J = " + usuario + " and Administrador = false")) {
                //bucle para sacar todos la informacion
                while (rs.next()) {
                    comp = true;
                    System.out.println(rs.getString(1) + " " + rs.getString(2));
                }
                //cerramos la conexion
            }
        } catch (SQLException e) {

            System.out.println(e);
        }
        return comp;
    }

    public static boolean consultaCredencialesAdmin(String nombre, String contrasenya) {
        //iniciamos el comprobador en false
        boolean comp = false;
        //nos conectamnos en la base de datos
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            Statement s = con.createStatement();
            //bucle para sacar todos la informacion
            try ( //creamos las consulta
                     ResultSet rs = s.executeQuery("select * from " + Conection.NomDB + ".JUGADORES "
                            + "where NAME_J = " + nombre + " and Passwrd = " + contrasenya
                            + " and Administrador = true")) {
                //bucle para sacar todos la informacion
                while (rs.next()) {
                    comp = true;
                    System.out.println(rs.getString(1) + " " + rs.getString(2));
                }
                //cerramos la conexion
            }
        } catch (SQLException e) {

            System.out.println(e);

        }
        return comp;
    }

    public static boolean consultaExisteAdmin(String nombre) {
        //iniciamos el comprobador en false
        boolean comp = false;
        //nos conectamnos en la base de datos
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            Statement s = con.createStatement();
            //bucle para sacar todos la informacion
            try ( //creamos las consulta
                     ResultSet rs = s.executeQuery("select * from " + Conection.NomDB + ".JUGADORES "
                            + "where NAME_J = " + nombre
                            + " and Administrador = true")) {
                //bucle para sacar todos la informacion
                while (rs.next()) {
                    comp = true;
                    System.out.println(rs.getString(1) + " " + rs.getString(2));
                }
                //cerramos la conexion
            }
        } catch (SQLException e) {

            System.out.println(e);

        }
        return comp;
    }
}
