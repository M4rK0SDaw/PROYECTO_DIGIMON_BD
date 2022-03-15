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

    HashSet<Digimon> DigimonSet = new HashSet<Digimon>();

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

    SortedMap<Usuario, HashSet< Digimon>> Esta_Eqp;

    Estar_Equipo() {
        Esta_Eqp = new TreeMap<Usuario, HashSet<Digimon>>();
    }
    
    
    
    

    Usuario Usuario;
    Digimon Digimon;

    boolean Esta_Equipo;

    boolean Estar_Equipo(Usuario Usuario, Digimon Digimon) {

        return false;

    }

}
