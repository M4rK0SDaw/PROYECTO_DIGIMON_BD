/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd;

import Sleer2.SLeer2;
import java.util.*;

/**
 *
 * @author marek
 * version 1.1 de digimon
 * Aqui vamos a usar un solo usuario. 
 * ademas teneos 6 digimon basicos creados, se le asignan 3 por defecto.
 * crear peleas osea crear mas "usuario" mas personajes para poder luchar.
 */
public class DigimonTreeMap {

    public static int Menu() {

        System.out.println(
                "     *                 MENÚ             *\n"
                + "     ************************************\n"
                + "     *                                  *\n"
                + "     *        [1] INICIAR PARTIDA       *\n"
                + "     *                                  *\n"
                + "     *        [2] BORRAR PARTIDA        *\n"
                //              + "     *        [2] ADMINISTRADOR         *\n"
                + "     *                                  *\n"
                + "     ************************************\n");

        int numero = SLeer2.datoInt("¿Como desea inciciar?");
        SLeer2.limpiar();
        return numero;
    }

    public static int MenuUsuario() {

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
                + "     *        [2] DIGIEVOLUCIONAR       *\n"
                + "     *                                  *\n"
                + "     *        [2] CERRAR SESION         *\n"
                + "     *                                  *\n"
                + "     ************************************\n");
        // en cerar sesion la partida se auto guarda 
        // ademas hay que implementar el auto guardado en cietos eventos del juego
        int numero = SLeer2.datoInt("¿Como desea inciciar?");
        SLeer2.limpiar();
        return numero;
    }

//    public static int menuAdministrador() {
//
//        System.out.println(
//                "     *           MENÚ ADMINISTRADOR         *\n"
//                + "     ***************************************\n"
//                + "     *                                      *\n"
//                + "     *        [1] ALTA DIGIUSUARIO          *\n"
//                + "     *                                      *\n"
//                + "     *        [2] ALTA DE DIGIMON           *\n"
//                + "     *                                      *\n"
//                + "     *        [3] DEFINIR DIGIEVOLUCION     *\n"
//                + "     *                                      *\n"
//                + "     *        [2] VER DIGIMON               *\n"
//                + "     *                                      *\n"
//                + "     *        [2] VOLVER AL INDICE          *\n"
//                + "     *                                      *\n"
//                + "     ****************************************\n");
//
//        int numero = SLeer2.datoInt("¿Como desea inciciar?");
//        SLeer2.limpiar();
//        return numero;
//    }
    public static void main(String[] args) {
        int usu = Menu();
        if (usu == 1) {
            MenuUsuario();
        }
    }
}
