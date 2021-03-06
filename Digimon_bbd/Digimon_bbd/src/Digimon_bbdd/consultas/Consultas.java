/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd.consultas;

import Digimon_bbdd.Conection.Conection;
import Digimon_bbdd.Digimon;
import Digimon_bbdd.Estar_Equipo;
import static Digimon_bbdd.Estar_Equipo.ListaDigi;
import Digimon_bbdd.Usuario;

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
     * @param contrasenya
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
                            "select * from  player "
                            + "where NAME_J = '" + nombre
                            + "' and PASSWD = '" + contrasenya
                            + "' and Administrador =  + " + 0)) {
                //bucle para sacar todos la informacion
                while (rs.next()) {
                    comp = true;
                    // System.out.println(rs.getString(1) + " " + rs.getString(2));
                    // se puede poner que si se accede al admin que no tiene las creedenciales necesarias (usuario ordinario) ,pero es muy inefiicente, por que se puede saber ciertas creedenciales y luego implementar las inyecciones
                }
                //cerramos la conexion

            }
        } catch (SQLException e) {

            System.err.println("El usuario ya existe " + nombre);

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
                     ResultSet rs = s.executeQuery("select * from player "
                            + " where NAME_J = " + "'" + usuario + "'"
                            + " and Administrador =" + 0)) {
                //bucle para sacar todos la informacion
                if (rs.next()) {
                    comp = true;
                    System.out.println(" " + rs.getString(2) + " ");
                }
                //cerramos la conexion
            }
        } catch (SQLException e) {

            System.err.println("El no existe " + usuario);
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
                     ResultSet rs = s.executeQuery("select * from  player "
                            + " where NAME_J = '" + nombre + "' and passwd = '" + contrasenya
                            + "' and Administrador = " + 1)) {
                //bucle para sacar todos la informacion
                while (rs.next()) {
                    comp = true;
                    //   System.out.println(" " + rs.getString(2));
                }
                //cerramos la conexion
            }
        } catch (SQLException e) {

            System.err.println("El Usuario ya existe " + nombre);

        }
        return comp;
    }

    public static boolean insertatUsuario(String nombre, String passwor, int x) {
        boolean comp = false;
        //nos conectamnos en la base de datos
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            PreparedStatement s = con.prepareStatement(
                    "INSERT INTO player (NAME_J,PASSWD,Administrador)"
                    + "values(?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            //bucle para sacar todos la informacion
            //creamos las consulta

            s.setString(1, nombre);
            s.setString(2, passwor);
            s.setInt(3, x);
            s.executeUpdate();

            //bucle para sacar todos la informacion
            //cerramos la conexion
            con.close();

        } catch (SQLException e) {

            System.err.println("El usuario ya existe " + nombre);

        }
        return comp;
    }

    public static boolean insertatAdmin(String nombre, String passwor, int x) {
        boolean comp = false;
        //nos conectamnos en la base de datos
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            PreparedStatement s = con.prepareStatement(
                    "INSERT INTO player (NAME_J,PASSWD,Administrador)"
                    + "values(?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            //bucle para sacar todos la informacion
            //creamos las consulta

            s.setString(1, nombre);
            s.setString(2, passwor);
            s.setInt(3, x);
            s.executeUpdate();

            //bucle para sacar todos la informacion
            //cerramos la conexion
            con.close();

        } catch (SQLException e) {

            //System.err.println("El usuario ya existe " + nombre);
        }
        return comp;
    }

    public static boolean consultaExistDigimon(String nombre) {
        //iniciamos el comprobador en false
        boolean comp = false;
        //nos conectamnos en la base de datos
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            Statement s = con.createStatement();
            //bucle para sacar todos la informacion
            try ( //creamos las consulta
                     ResultSet rs = s.executeQuery("select * from digimon "
                            + " where NAME_Digi like " + "'" + nombre + "'")) {
                //bucle para sacar todos la informacion
                if (rs.next()) {
                    comp = true;
                    System.out.println(rs.getString(2));
                }
                //cerramos la conexion
            }
            con.close();
        } catch (SQLException e) {
            System.err.println("El Digimon ya existe " + nombre);

        }
        return comp;

    }

    /**
     * este emteo compara si existen diigmons al iniciar el juego, si sexiste no
     * hace nada y si no existe los crea
     *
     * @param nombre
     * @return
     */
    public static boolean compInicioDigimon(String nombre) {
        boolean comp = false;
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            Statement s = con.createStatement();
            //bucle para sacar todos la informacion
            try ( //creamos las consulta
                     ResultSet rs = s.executeQuery("select * from digimon "
                            + " where NAME_Digi = " + "'" + nombre + "'")) {
                if (rs.next()) {
                    comp = true;
                    //muestra resultado
                    // System.out.println(rs.getString(2));
                }
                //cerramos la conexion
            }
            con.close();
        } catch (SQLException e) {
            //resultado de la excepcion
            //  System.err.println("El Digimon ya existe " + nombre);

        }
        return false;

    }

    public static boolean insertatDigimonInicial(String nombreD, int atack, int deff, String tipoD, int lvl) {

        boolean comp = false;
        //nos conectamnos en la base de datos
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            PreparedStatement s = con.prepareStatement(
                    "INSERT INTO digimon (NAME_Digi,ATTACK,DEFENSE,TYPE_DIGI,LVL)"
                    + " values(?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            //bucle para sacar todos la informacion
            //creamos las consulta

            s.setString(1, nombreD.toLowerCase());
            s.setInt(2, atack);
            s.setInt(3, deff);
            s.setString(4, tipoD);
            s.setInt(5, lvl);
            s.executeUpdate();

            //bucle para sacar todos la informacion
            //cerramos la conexion
            con.close();
        } catch (SQLException e) {
            // System.out.println("Esto digimons ya existen");
        }
        return comp;
    }

    public static boolean insertatDigimon(String nombreD, int atack, int deff, String tipoD, int lvl) {

        boolean comp = false;
        //nos conectamnos en la base de datos
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            PreparedStatement s = con.prepareStatement(
                    "INSERT INTO digimon (NAME_Digi,ATTACK,DEFENSE,TYPE_DIGI,LVL)"
                    + " values(?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            //bucle para sacar todos la informacion
            //creamos las consulta

            s.setString(1, nombreD.toLowerCase());
            s.setInt(2, atack);
            s.setInt(3, deff);
            s.setString(4, tipoD);
            s.setInt(5, lvl);
            s.executeUpdate();

            //bucle para sacar todos la informacion
            //cerramos la conexion
            con.close();
        } catch (SQLException e) {
            System.out.println("Esto digimons ya existen");
        }
        return comp;
    }

    public static void eliminarUsuario(String nombre) {
        //String usuario = SLeer2.datoString("Introduce el usuario: ");
        //iniciamos el comprobador en false

        //nos conectamnos en la base de datos
        Connection con = Conection.conexion();
        Statement s = null;
        try {
            //creamos la sentencia
            s = con.createStatement();
            //bucle para sacar todos la informacion
            //creamos las consulta
            String query = " delete from player where  NAME_J = '" + nombre + "';"
                    + " "
                    + "alter table player auto_increment=1;";

            s.executeUpdate(query);
            //bucle para sacar todos la informacion
            System.out.println("La eliminacion del usuario " + nombre + ". ");
            //cerramos la conexion

        } catch (SQLException excep) {
        } catch (Exception excep) {
        } finally {
            try {

                if (s != null) {
                    con.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
            }

        }
    }

    public static void cargarDIgimonyAdmin() {

        //comporbamos que el admin no existe.
        consultaCredencialesAdmin("admin", "admin");
        //si no existe lo creamos.
        insertatAdmin("admin", "admin", 1);
        // con los digimons lo mismo.
        compInicioDigimon("Agumon");
        insertatDigimonInicial("Agumon", 40, 40, "vacuna", 1);
        compInicioDigimon("Tentomon");
        insertatDigimonInicial("Tentomon", 40, 40, "vacuna", 1);
        compInicioDigimon("ANTOMON");
        insertatDigimonInicial("ANTOMON", 40, 40, "vacuna", 1);
        compInicioDigimon("MANAMON");
        insertatDigimonInicial("MANAMON", 40, 40, "vacuna", 1);
        compInicioDigimon("ZAPATAMON");
        insertatDigimonInicial("ZAPATAMON", 40, 40, "vacuna", 1);
        compInicioDigimon("KOKORIMON");
        insertatDigimonInicial("KOKORIMON", 40, 40, "vacuna", 1);
    }

    public static void muestraDigimonAdmin() {
        System.out.println(" ***LOS DIGIMON*** ");
        boolean comp = false;
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            Statement s = con.createStatement();
            //bucle para sacar todos la informacion
            try ( //creamos las consulta
                     ResultSet rs = s.executeQuery("select * from digimon "
                    )) {

                        while (rs.next()) {
                            comp = true;

                            //muestra resultado
                            System.out.println("[ Nombre: " + rs.getString(2) + ", ataque: " + rs.getInt(4) + ", defensa: " + rs.getInt(5) + ", tipo: " + rs.getString(6) + ", nivel: " + rs.getInt(7) + " ]");
//                            Digimon digi = new Digimon(0, rs.getString(2), 0, rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
//                            Equip.ListaDigi.add(digi);
                        }
                        //cerramos la conexion
                    }
                    con.close();
        } catch (SQLException e) {
            //resultado de la excepcion
            //  System.err.println("El Digimon ya existe " + nombre);

        }
    }

    public static void muestraUsuarios() {
        System.out.println(" *** LOS USUARIOS*** ");
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            Statement s = con.createStatement();

            //creamos las consulta
            try ( ResultSet rs = s.executeQuery("select * from player ")) {
                while (rs.next()) {

                    //muestra resultado
                    System.out.println("[ Nombre: " + rs.getString(2) + " ]"); // ", //conatrase??a: " + rs.getString(3)+" ]");
                }

            }
            //cerramos la conexion
            con.close();
        } catch (SQLException e) {
            //resultado de la excepcion
            System.err.println("Ocurrio un error.");

        }
    }

    public static void insertaDigiAlArray() {
        boolean comp = false;
        Connection con = Conection.conexion();
        try {
            //creamos la sentencia
            Statement s = con.createStatement();
            //bucle para sacar todos la informacion
            try ( //creamos las consulta
                     ResultSet rs = s.executeQuery("select * from digimon "
                    )) {
                        Estar_Equipo Equip = new Estar_Equipo();

                        while (rs.next()) {
                            comp = true;

                            //muestra resultado
                            //    System.out.println(rs.getInt(1)+","+rs.getString(2) + ", " + rs.getInt(4) + ", " + rs.getInt(5) + ", " + rs.getString(6) + "," + rs.getInt(7));
                            Digimon digi = new Digimon(rs.getInt(1), rs.getString(2), 0, rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
                            Equip.ListaDigi.add(digi);
                           // Equip.agreg_Digi_a_Usu_Inicio();
                        }
                        // vemos que nos muestra los digimon
//                        for (int i = 0; i < ListaDigi.size(); i++) {
//                            System.out.println(ListaDigi.get(i).toString());
//                        }

                    }   //cerramos la conexion
                    con.close();
        } catch (SQLException e) {
            //resultado de la excepcion
            //  System.err.println("El Digimon ya existe " + nombre);
        }
    }

    public static void inserta_Usu_y_Digi() {

    }

    public static void main(String[] args) {
        insertaDigiAlArray();

    }
}
