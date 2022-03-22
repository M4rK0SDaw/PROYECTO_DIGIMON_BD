package Digimon_bbdd.menus;

import java.sql.*;
import Digimon_bbdd.*;
import Digimon_bbdd.Conection.Conection;
import static Digimon_bbdd.consultas.Consultas.*;

import Digimon_bbdd.consultas.Consultas;
import Sleer2.SLeer2;

/**
 *
 * @author Karol
 */
public class Administrador {

    static String nomDigi;
    static int atackDigi;
    static int deffkDigi;
    static int lvlDigi;
    static String usuario;
    static String contrasenya;
    static String contrasenya2;
    static String tipoDigi;

    public void menu() {
        //mostrar el meu  de adiminstrador 
        Menu_Digimon.menuAdministrador();
        int eleccion = SLeer2.datoInt("Selecciona la opcion: ");

        switch (eleccion) {
            //crear los casos para cada eleccion y el default
            //1 -> alta usuario

            case 1:
                altaUsuario();
                break;

            //2 -> alta digimon
            case 2:
                altaDigimon();

                break;

            //3 -> listar digimon
            case 3:
                listarDigimon();

                break;
            //default -> informar numero erroneo y salir
            default:
                System.err.println("Opcion introducicda erronea");
                break;
        }
    }

    /**
     *
     */
    public static void altaUsuario() {

        boolean exists = true;

        String usuario;
        String contrasenya, contrasenya1, contrasenya2;
        do {
            usuario = SLeer2.datoString("Introduce el usuario: ");
            SLeer2.limpiar();
//combio por consultaExisteUsuario
            exists = consultaExisteUsuario(usuario);
            //Consultas.consultaExisteAdmin(usuario);

            if (exists) {
                System.out.println("El usuario indicado ya existe, inserte otro distinto.");
            } else {
                contrasenya1 = SLeer2.datoString("Introduce la contraseña: ");
                SLeer2.limpiar();
                contrasenya2 = SLeer2.datoString("Repita la contraseña: ");
                SLeer2.limpiar();
                if (contrasenya1.equals(contrasenya2)) {
                    contrasenya = contrasenya1;
                } else {
                    exists = true;
                }
            }

        } while (exists);

        //crear usuario admin
    }

    /**
     * Este emtodo es el dar de alta a digimon, con sus atributos
     * correspondientes.
     */
    public static void altaDigimon() {

        do {
            //nombre de digimon
            nomDigi = SLeer2.datoString("Intoduce el nombre del digimon");
            if (!(nomDigi.charAt(0) >= 'a' && nomDigi.charAt(0) <= 'z'
                    || nomDigi.charAt(0) >= 'A' && nomDigi.charAt(0) <= 'Z')) {
                System.out.println("");
                System.err.println(" El nombre introducido es erroneo.");
                System.out.println("");
            }
        } while (!(nomDigi.charAt(0) >= 'a' && nomDigi.charAt(0) <= 'z'
                || nomDigi.charAt(0) >= 'A' && nomDigi.charAt(0) <= 'Z'));

        do {
            //ataque de digimon
            atackDigi = SLeer2.datoInt("Introduzca el ataque del Digimon [enteros]");
            if (!(atackDigi >= 0 && atackDigi <= 9)) {
                System.out.println("Introduzca numero enteros");
            }
        } while (!(atackDigi >= 0 && atackDigi <= 9));
        do {
            //defensa del digimon
            deffkDigi = SLeer2.datoInt();
            if (!(deffkDigi >= 0 && deffkDigi <= 9)) {
                System.out.println("Introduzca numero enteros");
            }
        } while (!(deffkDigi >= 0 && deffkDigi <= 9));
        do {
            // nivel del digimon
            lvlDigi = SLeer2.datoInt();
            if (!(lvlDigi >= 0 && lvlDigi <= 3)) {
                System.out.println("Introduzca numero enteros");
            }
        } while (!(lvlDigi >= 0 && lvlDigi <= 3));

        do {
            tipoDigi = SLeer2.datoString();
            if (!(tipoDigi.charAt(0) >= 'a' && tipoDigi.charAt(0) <= 'z'
                    || tipoDigi.charAt(0) >= 'A' && tipoDigi.charAt(0) <= 'Z')) {
                System.out.println("");
                System.err.println(" El nombre introducido es erroneo.");
                System.out.println("");

            } else {
                tipoDigi.toLowerCase();
                switch (tipoDigi) {
                    case "vacuna":
                        tipoDigi = "vacuna";
                        break;
                    case "virus ":
                        tipoDigi = "virus ";
                        break;
                    case "animal":
                        tipoDigi = "animal";
                        break;
                    case "planta":
                        tipoDigi = "planta";
                        break;
                    case "elemental":
                        tipoDigi = "elemental";
                        break;
                    default:
                        tipoDigi = "vacuna";
                        break;
                }
            }
        } while (tipoDigi.equals(tipoDigi));

        Menu_Digimon.digi = new Digimon(nomDigi, atackDigi, deffkDigi, lvlDigi, tipoDigi);
    }

    /**
     * Este metodo muestra todos los digimons creados, con sus atributos
     * correspondientes.
     */
    private static void listarDigimon() {
        Estar_Equipo.mostrarLista();
    }

}
