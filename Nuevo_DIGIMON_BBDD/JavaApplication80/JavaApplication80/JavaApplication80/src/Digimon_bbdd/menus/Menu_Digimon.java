/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd.menus;

import Digimon_bbdd.*;
import Digimon_bbdd.consultas.Consultas;
import Sleer2.SLeer2;

/**
 * @author Marek
 */
public class Menu_Digimon {

    static Digimon digi;

    private Partidas partida;
    protected static Usuario user;

    public static boolean exit;

    public Menu_Digimon() {
        exit = false;
        //creamos digimons por defecto
        Estar_Equipo etEqu = new Estar_Equipo();
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

                    //introducir usuario y contraseña
                    //iniciar el menu
                    if (pedirCredenciales()) {
                        menuUsuario();
                    }

                    break;
                case 2:
                    //comprobamos que exista un usuario creado
                    if (user != null) {
                        //pedir nombre y contraseña para borrar la partida si la hay
                        if (pedirCredenciales()) {
                            if (partida != null) {
                                //si existe partida la eliminamos
                                eliminarPartida();
                            } else {
                                System.err.println("No existen partidas");
                            }
                        }
                    } else {
                        System.err.println("No existen usuarios disponibles");
                        //pedir si se desea crear un usuario
                        Administrador.altaUsuario();
                    }

                    break;
                case 3:
                    boolean correcto = false;
                    do {
                        String usuario, contrasenya;
                        usuario = SLeer2.datoString("Introduzca usuario: ");
                        SLeer2.limpiar();
                        contrasenya = SLeer2.datoString("Introduzca contraseña: ");
                        SLeer2.limpiar();
                        //administrar partida
                        //llamar al menu de administrador
                        if (Consultas.consultaCredencialesAdmin(usuario, contrasenya)) {
                            new Administrador().menu();
                            correcto = true;
                        } else {
                            System.err.println("Credenciales incorrectas, repitalas");
                            System.out.println();
                        }
                    } while (!correcto);
                    //alta usuario, alta digimon, ver digimons, salir al menu

                    break;
                default:
                    System.err.println("Opcion erronea, vuelva a seleccionar");
                    break;
            }
        }
    }

    private void eliminarPartida() {
        partida = null;
    }

    private boolean pedirCredenciales() {
        boolean correcto;

        String usuario;
        String contrasnya;
        do {
            usuario = SLeer2.datoString("Introduce el usuario: ");
            SLeer2.limpiar();
            contrasnya = SLeer2.datoString("Introduce la contraseña: ");
            SLeer2.limpiar();
            correcto = Consultas.consultaCredencialesUsuario(usuario, contrasnya);
        } while (!correcto);
        return correcto;
    }

    /*private boolean comprobarCredenciales(String usuario, String contrasnya) {
        //recibimos le usuario y la contraseña y hacemos la comporobacion el bbdd
        //comprobamos que las credenciales sean correctas
        return Consultas.consultaExisteUsuario(usuario, contrasnya);
     *//*if (Consultas.consultaExisteUsuario(usuario, contrasnya)) {
            //comprobar contraseña
            return Consultas.consultarContrasenya(usuario, contrasnya);
        }
     *//**//*do {
            if (!(usuario.charAt(0) >= 'a' && usuario.charAt(0) <= 'z'
                    || usuario.charAt(0) >= 'A' && usuario.charAt(0) <= 'Z')) {
                System.out.println("");
                System.err.println(" El nombre introducido es erroneo.");
                System.out.println("");
            }
        } while (!(usuario.charAt(0) >= 'a' && usuario.charAt(0) <= 'z'));

        do {
            if (!(contrasnya.charAt(0) >= 'a' && contrasnya.charAt(0) <= 'z'
                    || contrasnya.charAt(0) >= 'A' && contrasnya.charAt(0) <= 'Z')) {
                System.out.println("");
                System.err.println(" El nombre introducido es erroneo.");
                System.out.println("");
            }
        } while (!(contrasnya.charAt(0) >= 'a' && contrasnya.charAt(0) <= 'z'));*//**//*
        return false;*//*
    }*/

    public void menuUsuario() {
        int numero;
        do {

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
            numero = SLeer2.datoInt("¿Como desea inciciar?");
            SLeer2.limpiar();
            //la opcion del 4 es salir desde el principio
            switch (numero) {
                case 1:
                    //Ver mis digimon
                    // vuelta al menu
                    break;
                case 2:
                    //Organizar mi equipo
                    System.out.println("Los digimons son unos vagos y no quieren moverse. ");
                    break;
                case 3:
                    //Jugar partida
                    //Llamar menu partida, selecionar difcultad(medu dificultad(facil, medio, dificil y aleatorio)).
                    System.out.println("Los digimons  no quieren pelearse contra sus amigos, los otros digimons. Lo sentimos, esperese hasta la proxima actualización. ");
                    break;
                case 4:
                    System.out.println("Actualmente los digimons están pensado en que digievolucionar, espere a la proxima actualización. ");
                    break;
                case 5:
                    //guardar la informacion en la bbdd
                    System.out.println("¿Realmente quiere salir?");
                    System.out.println();
                    System.out.println("[OPCIONES]");
                    System.out.println("----------");
                    System.out.println("Y: si");
                    System.out.println("N: no");
                    String respuesta = SLeer2.datoString();
                    if (!respuesta.equals("Y")) {
                        numero = 0;
                    } else {
                        user = null;
                    }

                    break;

                default:
                    System.err.println("Opcion erronea, vuelva a seleccionar una de las opciones correctas. ");
                    break;
            }
            //hasta no pulsar el 5 no se sale del menu
        } while (numero != 5);

    }

    public static void menuAdministrador() {
        int numero = 0;
        do {

            System.out.println(
                    "     *           MENÚ ADMINISTRADOR           *\n"
                    + "     ***************************************\n"
                    + "     *                                      *\n"
                    + "     *        [1] ALTA DIGIUSUARIO          *\n"
                    + "     *                                      *\n"
                    + "     *        [2] ALTA DE DIGIMON           *\n"
                    + "     *                                      *\n"
                    // + "       *        [3] DEFINIR DIGIEVOLUCION   *\n"
                    + "     *                                      *\n"
                    + "     *        [4] VER DIGIMONS              *\n"
                    + "     *                                      *\n"
                    + "     *        [5] VOLVER AL INDICE          *\n"
                    + "     *                                      *\n"
                    + "     ****************************************\n");

            numero = SLeer2.datoInt("¿Como desea inciciar?");
            SLeer2.limpiar();
            if (numero == 5) {
                exit = true;
            } else {
                switch (numero) {
                    case 1:
                        //ALta usuario
                        Administrador.altaUsuario();
                        break;
                    case 2:
                        //Alta Digimon
                        Administrador.altaDigimon();

                        break;
                    case 3:
                        //Definir Digi Evolucion
                        System.out.println("Actualmente los digimons están pensado en que digievolucionar, espere a la proxima actualización");
                        break;
                    case 4:
                        //listar los digimons
                        Estar_Equipo.mostrarLista();
                        break;

                    default:
                        System.err.println("Opcion erronea, vuelva a seleccionar una de las opciones correctas");
                        break;
                }
            }

        } while (numero >= 1 && numero <= 5);

    }
}
