/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd;

import java.util.*;

/**
 *
 * @author Marek
 */
public class Estar_Equipo implements java.io.Serializable {

    ArrayList<Digimon> ArrayDigi = new ArrayList();

    HashSet<Digimon> DigimonSet = new HashSet<Digimon>();

    void rellenaArray() {
        for (Digimon d : DigimonSet) {
            ArrayDigi.add(d);
        }
    }

    /**
     * Este metodo addDigimon agrega un digimon a la lista del hashset, si el
     * nombre es repetido es devuelve true y no existe es false
     *
     * @param NAME_Digi
     * @return el resultado del bucle if true o false
     */
    boolean addDigimon(String NAME_Digi) {

        Digimon digi = new Digimon(NAME_Digi);
        if (DigimonSet.contains(digi)) {
            return true;
        } else {
            DigimonSet.add(digi);
            return false;
        }
    }

    /*metodo para digievolucionar*/
    /**
     * Este es un metodo borrar digimon, pasamos por parametro un objeto
     * digimon, comprobaremos que su nombre existe en la lista, si esxiste se
     * comple la condicion y el objeto se remueve de la lista y devuelve un true
     * de que se logro la ejecucion en caso contrario sie el nombre no existe en
     * la lista la condicion no se cumple y devuelve un false
     *
     * @return devuelve true cuando existe el nomnbre en la lista y lo elimina,
     * false si no existe en ella
     */
    boolean removeDigimon(Digimon digi) {

        if (DigimonSet.contains(digi)) {
            DigimonSet.remove(digi);
            return true;
        } else {
            return false;
        }

    }

//  HashMap<Usuario, HashSet< Digimon>> lista = new HashMap<Usuario, HashSet<Digimon>>();
    SortedMap<String, ArrayList<Digimon>> lista;

    Estar_Equipo() {
        lista = new TreeMap<String, ArrayList<Digimon>>();
    }

    boolean agregar_Usu_DIGI(Usuario usu) {

        if (lista.containsKey(usu.Nombre_J)) {
            return false;
        } else {
            ArrayList<Digimon> A = new ArrayList();

            for (int i = 0; i < 3; i++) {
                A.add(ArrayDigi.get(i));
                lista.put(usu.Nombre_J, A);
            }

            return true;
        }
    }

    boolean agregarUsuario(Usuario usu) {

        if (lista.containsKey(usu.Nombre_J)) {
            return false;
        } else {

            lista.put(usu.Nombre_J, new ArrayList<Digimon>());
            return true;
        }
    }

    void modificaPosicion(Usuario usu, String digimon1, String digimon2) {
        if (lista.containsKey(usu)) {
            if (lista.) {

            }

        }
    }

    Usuario recuperar(String  usu) {
        if (lista.containsKey(usu)) {
            return lista.get(usu);
        } else {
            return null;
        }

    }

    boolean eliminar(Usuario usu) {
        if (lista.containsKey(usu)) {
            lista.remove(usu);
            return true;
        } else {
            return false;
        }
    }

    boolean vaciar() {
        if (estaVacia() == false) {
            lista.clear();
            return true;
        } else {
            return false;
        }
    }

    boolean estaVacia() {
        if (lista.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    Usuario Usuario;
    Digimon Digimon;

    boolean Esta_Equipo;

    boolean Estar_Equipo(Usuario Usuario, Digimon Digimon) {

        return false;

    }

}
