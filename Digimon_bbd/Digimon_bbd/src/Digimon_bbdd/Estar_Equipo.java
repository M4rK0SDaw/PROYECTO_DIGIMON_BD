
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Marek
 */
public class Estar_Equipo implements java.io.Serializable {

    private Usuario usuario;
    private Digimon digimon;

    //String es el nombre del usu y integer el id del digimon

    /* HashMap<String, HashSet<Integer>> mapUsuDigi;

HashMap<String, Usuario> inforUser;

HashMap<Integer, Digimon> inforDigimon;*/ //crear una class de coneccion ocn la base de datos
    // para poder rellenarlo.
    //-------------------------------------------------------------
    //atributos
    static SortedMap<Integer, ArrayList<Digimon>> lista;
    static ArrayList<Usuario> ListaUsu;
    static String ListaUsu1 = "ramon";
    static String ListaUsu2 = "prrschz";
    public static ArrayList<Digimon> ListaDigi = new ArrayList();

    //constructor
    public Estar_Equipo() {
        lista = new TreeMap<>();
        ListaDigi = new ArrayList<>();

        ListaUsu = new ArrayList<>();
    }

//    /**
//     * Este metodo addDigimon agrega un digimon a la lista del hashset, si el
//     * nombre es repetido es devuelve true y no existe es false.
//     *
//     * @param NAME_Digi
//     * @return el resultado del bucle if true o false
//     */
//    public static boolean addDigimon(String NAME_Digi) {
//
//        Digimon digi = new Digimon(NAME_Digi);
//        if (ListaDigi.contains(digi)) {
//            return true;
//        } else {
//            ListaDigi.add(digi);
//            return false;
//        }
//    }
//    /**
//     * Este es un metodo borrar digimon, pasamos por parametro un objeto
//     * digimon, comprobaremos que su nombre existe en la lista, si esxiste se
//     * comple la condicion y el objeto se remueve de la lista y devuelve un true
//     * de que se logro la ejecucion en caso contrario sie el nombre no existe en
//     * la lista la condicion no se cumple y devuelve un false
//     *
//     * @param digi objeto digimon
//     * @return devuelve true cuando existe el nomnbre en la lista y lo elimina,
//     * false si no existe en ella
//     */
//    public boolean removeDigimon(Digimon digi) {
//        return false;
//
//        /*  if (DigimonSet.contains(digi)) {
//        DigimonSet.remove(digi);
//        return true;
//        } else {
//        return false;
//        }*/
//    }
    /**
     * Este emtodo consiste en Agregar Digimons iniciales al usuario creado. Se
     * pasa por parametor el nombre del usuario al que se quierea asignar los
     * digimons, en este caso son tre desde el principio. Condicion si el nombre
     * existe en el mapa devuelve false, entonces se ejecuta la otra parte, que
     * se crea un arraylist nuevo, y un bucle for, por cada iteaccion se escoge
     * un digimon, no aleatorio, sino secuencial y se le agrega al usuario en el
     * mapa
     *
     * @param usu
     * @return
     */
    public static boolean agreg_Digi_a_Usu_Inicio(Usuario usu) {

        if (!lista.containsKey(usu.getNAME_J())) {
            return false;
        } else {
            ArrayList<Digimon> AlDig = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                //a??adimos un digimon distinto a cada usuario
                AlDig.add(ListaDigi.get(ThreadLocalRandom.current().nextInt(0, ListaDigi.size())));
                // lista.put(Usuario.getNAME_J(), AlDig);

            }

            return true;
        }
    }

    /**
     * Este emtodo es de agregar usuarios al mapa, pasando por parametro el
     * nombre de usuario, comporbamso que si existe que devuelva falso y que no
     * lo cree, y si no existe en el mapa pues se crea y devuelve true, ademas
     * se le agregan Digimons, pero estan vacios
     *
     * @param usu el nombre ue se el pasa por parametro al metodo.
     * @return true cuando se crea usuario y false cuando existe en el mapa
     */
    public static boolean agregarUsuario(Usuario usu) {

        if (lista.containsKey(usu.getNAME_J())) {
            return false;
        } else {
//            lista.put(usu.getNAME_J(), new ArrayList<>());
            return true;
        }
    }

    /* Usuario recuperar(Usuario usu) {
    if (lista.containsKey(usu)) {
    return lista.get(Digimon);
    } else {
    return null;
    }
    }*/
    /**
     * Este emtodo Elimina usuarios, pasamos por parametro un usuario,
     * comprobamos que este en el mapa con la key que es su nombre, si esxiste
     * se borra ese usuario del mapa
     *
     * @param usu parametro de la key
     * @return devuelve true cuando sea eliminado y cuando no false, por que
     * puede no existir.
     */
    boolean eliminar(Usuario usu) {
        if (lista.containsKey(usu)) {
            lista.remove(usu);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Este emtodo es una condicion de si el map esta vacio o no, si esta vacio
     * true, false cuando este llena, se cumple la condicon y se borra el mapa
     *
     * @return false cuando no este vacia y lo varia y true cuando este vacia
     */
    boolean vaciar() {
        if (lista.isEmpty() == false) {// si dev true esta llena y borra y si no false, no hace nada
            lista.clear();
            return true;
        } else {// true
            return false;
        }
    }

    public Set<Map.Entry<String, ArrayList<Digimon>>> total() {
        return null;

        //    return lista.entrySet();
    }
}
