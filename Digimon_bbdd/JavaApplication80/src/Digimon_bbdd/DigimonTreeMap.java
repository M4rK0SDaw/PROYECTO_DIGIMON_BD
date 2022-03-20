/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd;

import Sleer2.SLeer2;
import java.io.*;
import java.util.*;

/**
 *
 * @author marek version 1.1 de digimon Aqui vamos a usar un solo usuario.
 * ademas teneos 6 digimon basicos creados, se le asignan 3 por defecto. crear
 * peleas osea crear mas "usuario" mas personajes para poder luchar.
 */
public class DigimonTreeMap {

    static Estar_Equipo EstEq;
    static String nombre;
    static Digimon digimon;

    public static void cls(int c) {

        for (int i = 0; i < c; i++) {
            System.out.println("  ");
        }
    }

    public static void CargarDigimonTreeMap() {

        try {
            File fl = null;
            FileInputStream flIS = null;
            ObjectInputStream oIS = null;

            try {
                fl = new File("DIGIMONS_BBDD.dat");
                if (fl.exists()) {
                    flIS = new FileInputStream(fl);
                    oIS = new ObjectInputStream(flIS);

                    EstEq = (Estar_Equipo) oIS.readObject();
                }
            } catch (EOFException eof) {
                System.out.println(" Fin del archivo ");
            } catch (FileNotFoundException fnf) {
                System.err.println("Fichero no encontrado " + fnf);
            } catch (IOException e) {
                System.err.println("Se ha producido una IOException");
                e.printStackTrace();
            } catch (Throwable e) {
                System.err.println("Error de programa: " + e);
                e.printStackTrace();
            } finally {
                if (oIS != null) {
                    oIS.close();
                    flIS.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void GuardarDigimonTreeMap() {

        try {
            FileOutputStream fls = new FileOutputStream("DIGIMONS_BBDD.dat");
            ObjectOutputStream OpSt = new ObjectOutputStream(fls);

            OpSt.writeObject(EstEq);

            if (OpSt != null) {
                OpSt.close();
                fls.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        cls(1);
        System.out.println(" \033[32mDatos guardados correctamente");

    }

    void agregarDigimon() {

    }

    public static void PedirNombre(String frase) {//pedir nombre..... es no vacio y que el primer caracter sea una letra

        do {
            nombre = SLeer2.datoString(frase);
            if (!(nombre.charAt(0) >= 'a' && nombre.charAt(0) <= 'z'
                    || nombre.charAt(0) >= 'A' && nombre.charAt(0) <= 'Z')) {
                cls(1);
                System.err.println(" El nombre introducido es erroneo.");
                cls(1);
            }
        } while (!(nombre.charAt(0) >= 'a' && nombre.charAt(0) <= 'z'
                || nombre.charAt(0) >= 'A' && nombre.charAt(0) <= 'Z'));

    }

    public static void ListarAgenda() {

        SLeer2.limpiar();
        cls(2);
        System.out.println("\033[33m  ----------------------------------------------");
        System.out.println(" |" + "\033[33m Ha elegido listar los DIGIMONS.     " + "|");
        System.out.println("\033[33m  ----------------------------------------------");
        cls(1);

        for (Map.Entry<String, ArrayList<Digimon>> Lista : EstEq.total()) {

            String Usuario = Lista.getKey();
            ArrayList<Digimon> digimon = Lista.getValue();

            cls(1);
            System.out.println("******* DIGIMONS *******");
            cls(1);

        }
        cls(2);
        System.out.println("\033[33m        ------------------------------");
        System.out.println("       |" + "\033[33m FIN DE LA LISTA DE DIGIMONS." + "|");
        System.out.println("\033[33m        ------------------------------");
        cls(1);

    }

    public static void main(String[] args) {
        int usu = Menu_Digimon.Menu();

        if (usu == 1) {
            Menu_Digimon.menuUsuario();
        }
    }
}
