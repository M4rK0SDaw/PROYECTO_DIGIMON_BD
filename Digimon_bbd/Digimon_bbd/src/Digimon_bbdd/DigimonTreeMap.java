/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd;

import Digimon_bbdd.consultas.Consultas;
import Digimon_bbdd.menus.Menu_Digimon;
import Sleer2.SLeer2;

import java.util.*;

/**
 *
 * @author marek version 1.1 de digimon Aqui vamos a usar un solo usuario.
 * ademas teneos 6 digimon basicos creados, se le asignan 3 por defecto. crear
 * peleas osea crear mas "usuario" mas personajes para poder luchar.
 */
public class DigimonTreeMap {

    static Estar_Equipo EstEq;
    static Usuario usuario;
    static String nombre;
    static Digimon digimon;

    public static void main(String[] args) {
        // cargar los digimon si no existen, si existen no lo hace.
        Consultas.cargarDIgimonyAdmin();
        //mostrar menu
        Menu_Digimon men = new Menu_Digimon();

        while (!Menu_Digimon.exit) {
            men.Menu();

        }

    }
}
