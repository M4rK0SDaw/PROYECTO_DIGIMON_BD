/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd;

import Sleer2.SLeer2;

/**
 *
 * @author Marek
 */
public class Menu_Digimon {

    public static int Menu() {

        System.out.println(
                "     *                 MENÚ             *\n"
                + "     ************************************\n"
                + "     *                                  *\n"
                + "     *        [1] INICIAR PARTIDA       *\n"
                + "     *                                  *\n"
                + "     *        [2] BORRAR PARTIDA        *\n"
                + "     *                                  *\n"
//                + "     *        [2] ADMINISTRADOR         *\n"
                + "     *                                  *\n"
                + "     ************************************\n");

        int numero = SLeer2.datoInt("¿Como desea inciciar?");
        SLeer2.limpiar();
        return numero;
    }

    public static int menuUsuario() {

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
        return numero;
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
                + "     *        [3] DEFINIR DIGIEVOLUCION     *\n"
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
