package Digimon_bbdd.menus;

import Digimon_bbdd.*;
import Digimon_bbdd.Usuario;
import static Digimon_bbdd.consultas.Consultas.*;
import Digimon_bbdd.consultas.Consultas;
import static Digimon_bbdd.menus.Menu_Digimon.user;
import Sleer2.SLeer2;

/**
 *
 * @author marek
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
    static int adminUsu;

    public static void altaUsuario() {
        //boolean aux3 = false;
        boolean exists = true;
        //nombre del usuario
        String usuario;
        //Contrasenya del usuario y su comprobacion
        String contrasenya = null, contrasenya1, contrasenya2;
        //1(true) o 0(false) para saber si es administrador.
        char AdminChar;

        boolean aux4 = false;
        do {
            AdminChar = SLeer2.datoChar("Desea que sea Admin?[S/N] :");
            // hacemos la respuesta en minuscula.
            char caracter = Character.toLowerCase(AdminChar);
            if (caracter == 's') {

                //aux3 = true;
                aux4 = true;
                adminUsu = 1;

            } else if (caracter == 'n') {
                //   aux3 = false;
                aux4 = true;
                adminUsu = 0;
            } else {
                Menu_Digimon.cls(1);
                System.out.println("Valor introducido erroneo, por defecto no es administrador");
            }
        } while (aux4 = false);

        do {
            usuario = SLeer2.datoString("Introduce el usuario: ");
            // SLeer2.limpiar();
            //combio por consultaExisteUsuario
            exists = consultaExisteUsuario(usuario);

            if (exists) {
                System.out.println("El usuario indicado ya existe, inserte otro distinto.");
            } else {
                contrasenya1 = SLeer2.datoString("Introduce la contraseña: ");
                //SLeer2.limpiar();
                contrasenya2 = SLeer2.datoString("Repita la contraseña: ");
                // SLeer2.limpiar();
                if (contrasenya1.equals(contrasenya2)) {
                    contrasenya = contrasenya1;
                } else {
                    System.out.println("la contraseña esta mal escrita, se volverán a pedir las credenciales");
                    exists = true;
                }
                Menu_Digimon.cls(1);
                System.out.println("\u001B[32m EL usuario " + usuario + ", fue creado corrctamente. ");
                Menu_Digimon.cls(1);
                Menu_Digimon.pausa();
                Menu_Digimon.cls(15);
            }

        } while (exists);

        //crear usuario admin
        Menu_Digimon.user = new Usuario(usuario, contrasenya, adminUsu);
        Consultas.insertatUsuario(usuario, contrasenya, adminUsu);
     //   .Estar_Equipo.agregarUsuario(Menu_Digimon.user);
        Estar_Equipo.agreg_Digi_a_Usu_Inicio(Menu_Digimon.user);

    }

    /**
     * Este emtodo es el dar de alta a digimon, con sus atributos
     * correspondientes.
     */
    public static void altaDigimon() {
        String NAME_Digi;
        int ATTACK;
        int DEFENSE;
        String TYPE_DIGI;
        int LVL;
        boolean aux = false;
        boolean aux1 = false;
        boolean exists = true;
        do {
            NAME_Digi = SLeer2.datoString("Introduce el nombre del digimon :").toLowerCase();
            // SLeer2.limpiar();
            ATTACK = SLeer2.datoInt("Introduce el ataque del Digimon :");
            SLeer2.limpiar();
            DEFENSE = SLeer2.datoInt("Introduce la defensa del Digimon :");
            SLeer2.limpiar();
            do {
                TYPE_DIGI = SLeer2.datoString("Introduce el tipo del digimon [vacuna, virus, elemental, planta, animal]:").toLowerCase();
                switch (TYPE_DIGI) {
                    case "vacuna":
                        tipoDigi = "vacuna";
                        aux = true;
                        break;
                    case "virus":
                        tipoDigi = "virus";
                        aux = true;
                        break;
                    case "animal":
                        tipoDigi = "animal";
                        aux = true;
                        break;
                    case "planta":
                        tipoDigi = "planta";
                        aux = true;
                        break;
                    case "elemental":
                        tipoDigi = "elemental";
                        aux = true;
                        break;
                    default:
                        tipoDigi = "vacuna";
                        System.out.println("El tipo de digimon no existe, en su case se le otorga el tipo de vacuna");
                        aux = true;
                        break;
                }

            } while (!aux);

            do {
                LVL = SLeer2.datoInt("Introduce El nivel del Digimon :");
                SLeer2.limpiar();
                switch (LVL) {
                    case 1:
                        LVL = 1;
                        aux1 = true;
                        break;
                    case 2:
                        LVL = 2;
                        aux1 = true;
                        break;
                    case 3:
                        LVL = 3;
                        aux1 = true;
                        break;
                    default:
                        LVL = 1;
                        aux1 = true;
                        System.out.println("El nivel de digimon no existe, en su case se le otorga el tipo de 1");
                        break;
                }
            } while (!aux1);
        } while (!exists);

        Menu_Digimon.digi = new Digimon(0, nomDigi, 0, atackDigi, deffkDigi, tipoDigi, lvlDigi);
        Consultas.insertatDigimon(NAME_Digi, ATTACK, DEFENSE, tipoDigi, LVL);
        System.out.println("El digimon se creo exitosamente ");
    }

    /**
     * Este metodo muestra todos los digimons creados, con sus atributos
     * correspondientes.
     */
}
