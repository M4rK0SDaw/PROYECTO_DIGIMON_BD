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
 * @author marek version 1.1 de digimon Aqui vamos a usar un solo usuario.
 * ademas teneos 6 digimon basicos creados, se le asignan 3 por defecto. crear
 * peleas osea crear mas "usuario" mas personajes para poder luchar.
 */
public class DigimonTreeMap {

    public static void main(String[] args) {
        int usu = Menu_Digimon.Menu();

        if (usu == 1) {
            Menu_Digimon.menuUsuario();
        }
    }
}
