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

    static Usuario user;

    public static boolean exit;

    public Menu_Digimon() {
        exit = false;
        //creamos digimons por defecto
        Estar_Equipo etEqu = new Estar_Equipo();
//        etEqu.crearDigiDefault();
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
                // buscar el usuario en la base de datos
                String nombre = SLeer2.datoString("Introduce el nombre");

                if (Consultas.consultaExisteUsuario(nombre)) {
                    Consultas.eliminarUsuario(nombre);
                } else {
                    System.err.println(".....No existe dicho usuario");
                }
                break;
            case 3:
                boolean correcto = false;
                do {
                    String usuario, contrasenya;
                    usuario = SLeer2.datoString("Introduzca usuario: ");
                    //SLeer2.limpiar();
                    contrasenya = SLeer2.datoString("Introduzca contraseña: ");
                    //SLeer2.limpiar();
                    //administrar partida
                    //llamar al menu de administrador
                    if (Consultas.consultaCredencialesAdmin(usuario, contrasenya)) {
                        new Administrador();
                        menuAdministrador();
                        correcto = true;
                    } else {
                        System.err.println("Credenciales incorrectas, repitalas");
                        System.out.println();
                    }
                } while (!correcto);
                //alta usuario, alta digimon, ver digimons, salir al menu

                break;
            case 4:
                exit = true;
                break;
            default:
                System.err.println("Opcion erronea, vuelva a seleccionar");
                break;

        }
    }

    private boolean pedirCredenciales() {
        boolean correcto;
        String usuario;
        String contrasnya;
        do {
            usuario = SLeer2.datoString("Introduce el usuario: ").toLowerCase();
//            SLeer2.limpiar();
            contrasnya = SLeer2.datoString("Introduce la contraseña: ").toLowerCase();
//            SLeer2.limpiar();
            correcto = Consultas.consultaCredencialesUsuario(usuario, contrasnya);
        } while (!correcto);
        return correcto;
    }

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
                    Consultas.muestraDigimon();
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
                    String respuesta = SLeer2.datoString().toUpperCase();
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

    /*
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
                muestraDigimon();
                break;
            case 4:
            //default -> informar numero erroneo y salir
            default:
                System.err.println("Opcion introducicda erronea");
                break;
        }
    }
    

    public void menu() {
        //mostrar el meu  de adiminstrador 
        Menu_Digimon.menuAdministrador();
        int eleccion = SLeer2.datoInt("Selecciona la opcion: ");

        switch (eleccion) {
            //crear los casos para cada eleccion y el default
            //1 -> alta usuario

            case 1:
                Administrador.altaUsuario();
                break;

            //2 -> alta digimon
            case 2:
                Administrador.altaDigimon();
                break;

            //3 -> muestra digimon
            case 3:
                Administrador.muestraDigimon();
                break;
            case 4:
            //default -> informar numero erroneo y salir
            default:
                System.err.println("Opcion introducicda erronea");
                break;
        }
    }
     */
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
                    + "     *        [3] DEFINIR DIGIEVOLUCION     *\n"
                    + "     *                                      *\n"
                    + "     *        [4] VER DIGIMONS              *\n"
                    + "     *                                      *\n"
                    + "     *        [5] VE USUARIOS               *\n"
                    + "     *                                      *\n"
                    + "     *        [6] VOLVER AL INDICE          *\n"
                    + "     ****************************************\n");

            numero = SLeer2.datoInt("¿Como desea inciciar?");
            SLeer2.limpiar();

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
                    //listar los digimons// metodo de la consulta
//                    Estar_Equipo.mostrarLista();
                    break;
                case 5:
                    Consultas.muestraUsuarios();
                    break;
                case 6:
                    //guardar la informacion en la bbdd
                    System.out.println("¿Realmente quiere salir?");
                    System.out.println();
                    System.out.println("[OPCIONES]");
                    System.out.println("----------");
                    System.out.println("Y: si");
                    System.out.println("N: no");
                    String respuesta = SLeer2.datoString().toUpperCase();
                    if (!respuesta.equals("Y")) {
                        numero = 0;
                    }
                    break;

                default:
                    System.err.println("Opcion erronea, vuelva a seleccionar una de las opciones correctas");
                    break;
            }

        } while (numero != 6);

    }
}
