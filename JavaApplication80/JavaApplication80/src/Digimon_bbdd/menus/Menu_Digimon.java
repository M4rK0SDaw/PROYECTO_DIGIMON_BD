/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd.menus;

import Digimon_bbdd.Digimon;
import Digimon_bbdd.Estar_Equipo;
import Digimon_bbdd.Partidas;
import Digimon_bbdd.Usuario;
import Sleer2.SLeer2;

/**
 *
 * @author Marek
 */
public class Menu_Digimon {

    static Digimon digi;

    private Partidas partida;
    protected static Usuario user;

    public boolean exit;
    private Estar_Equipo etEqu = new Estar_Equipo();

    public Menu_Digimon() {
        this.exit = false;
        //creamos digimons por defecto
        etEqu.crearDigiDefault();
        //this.partida = new Partidas();
    }

    public void Menu() {

        System.out.println(
                "     *                 MENÚ             *\n"
                + "     ************************************\n"
                + "     *                                  *\n"
                + "     *        [1] INICIAR PARTIDA       *\n"
                + "     *                                  *\n"
                + "     *        [2] BORRAR PARTIDA        *\n"
                + "     *                                  *\n"
                + "     *        [3] ADMINISTRADOR         *\n"
                + "     *                                  *\n"
                + "     *        [4] SALIR                 *\n"
                + "     *                                  *\n"
                + "     ************************************\n");

        int numero = SLeer2.datoInt("¿Como desea inciciar?");
        SLeer2.limpiar();
        if (numero == 4) {
            exit = true;
        } else {
            switch (numero) {
                case 1:
                    //iniciar partida
                    //introducir usuario y contraseña

                    menuUsuario();
                    break;
                case 2:
                    //borrar partida

                    //comprobamos que exista un usuario creado
                    if (user != null) {
                        //pedir nombre y contraseña para borrar la partida si la hay
                        if (partida != null) {
                            //si existe partida la eliminamos
                            eliminarPartida();
                        } else {
                            System.err.println("No existen partidas");
                        }
                    } else {
                        System.err.println("No existen usuarios disponibles");
                        //pedir si se desea crear un usuario

                    }

                    break;
                case 3:
                    //administrar partida
                    //llamar al menu de administrador
                    new Administrador().menu();
                    //alta usuario, alta digimon, ver digimons, salir al menu

                    break;
                default:
                    System.err.println("Opcion erronea, vuelva a seleccionar");
                    break;
            }
        }
    }

    private void eliminarPartida() {
        if (pedirCredenciales()) {
            partida = null;
        }
    }

    private boolean pedirCredenciales() {
        String usuario = SLeer2.datoString("Introduce el usuario: ");
        SLeer2.limpiar();
        String contrasnya = SLeer2.datoString("Introduce la contraseña: ");
        comprobarCredenciales(usuario, contrasnya);
        return false;
    }

    private void comprobarCredenciales(String usuario, String contrasnya) {
        //comprobamos que las credenciales sean correctas
    }

    public void menuUsuario() {

        System.out.println(
                "     *           MENÚ USUARIO             *\n"
                + "     ************************************\n"
                + "     *                                  *\n"
                + "     *        [1] VER MIS DIGIMON       *\n"
                + "     *                                  *\n"
                + "     *        [2] ORGANIZAR MI EQUIPO   *\n"
                + "     *                                  *\n"
                + "     *        [3] JUGAR PARTIDAS        *\n"
                + "     *                                  *\n"
                + "     *        [4] DIGIEVOLUCIONAR       *\n"
                + "     *                                  *\n"
                + "     *        [5] CERRAR SESION         *\n"
                + "     *                                  *\n"
                + "     ************************************\n");
        // en cerar sesion la partida se auto guarda 
        // ademas hay que implementar el auto guardado en cietos eventos del juego
        int numero = SLeer2.datoInt("¿Como desea inciciar?");
        SLeer2.limpiar();
        if (numero == 4) {
            exit = true;
        } else {
            switch (numero) {
                case 1:
                    //Ver mis digimon
                    // vuelta al menu
                    menuUsuario();
                    break;
                case 2:
                    //Organizar mi equipo

                    break;
                case 3:
                    //Jugar partida
                    //Llamar menu partida, selecionar difcultad.

                    break;
                default:
                    System.err.println("Opcion erronea, vuelva a seleccionar");
                    break;
            }
        }

    }

    public static int menuAdministrador() {

        System.out.println(
                "     *           MENÚ ADMINISTRADOR         *\n"
                + "     ***************************************\n"
                + "     *                                      *\n"
                + "     *        [1] ALTA DIGIUSUARIO          *\n"
                + "     *                                      *\n"
                + "     *        [2] ALTA DE DIGIMON           *\n"
                + "     *                                      *\n"
                //                + "     *        [3] DEFINIR DIGIEVOLUCION     *\n"
                + "     *                                      *\n"
                + "     *        [4] VER DIGIMON               *\n"
                + "     *                                      *\n"
                + "     *        [5] VOLVER AL INDICE          *\n"
                + "     *                                      *\n"
                + "     ****************************************\n");

        int numero = SLeer2.datoInt("¿Como desea inciciar?");
        SLeer2.limpiar();
        return numero;

    }
}
