
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd;

import java.util.*;

/**
 * @author Marek
 */
public class Estar_Equipo implements java.io.Serializable {

    private Usuario usuario;
    private Digimon digimon;

    // string es el nombre del usu y integer el id del digimon
    HashMap<String, HashSet<Integer>> mapUsuDigi;

    HashMap<String, Usuario> inforUser;

    HashMap<Integer, Digimon> inforDigimon;

    //crear una class de coneccion ocn la base de datos 
    // para poder rellenarlo.
    //-------------------------------------------------------------
    //atributos
    SortedMap<String, ArrayList<Digimon>> lista;
    ArrayList<Usuario> ListaUsu;
    String ListaUsu1 = "Ramon";
    String ListaUsu2 = "Perro";
    ArrayList<Digimon> ListaDigi;
    static HashSet<Digimon> DigimonSet;

    //constructor
    public Estar_Equipo() {
        lista = new TreeMap<>();
        ListaDigi = new ArrayList<>();
        DigimonSet = new HashSet<>();
        ListaUsu = new ArrayList<>();
    }

    //digimon por defecto
    Digimon dgL1 = new Digimon("Agumon");
    Digimon dgL2 = new Digimon("Tentomon");
    Digimon dgL3 = new Digimon("ANTOMON");
    Digimon dgL4 = new Digimon("MANAMON");
    Digimon dgL5 = new Digimon("ZAPATAMON");
    Digimon dgL6 = new Digimon("KOKORIMON");

    private void rellenaArray() {

        ListaDigi.add(dgL1);
        ListaDigi.add(dgL2);
        ListaDigi.add(dgL3);
        ListaDigi.add(dgL4);
        ListaDigi.add(dgL5);
        ListaDigi.add(dgL6);

        DigimonSet.addAll(ListaDigi);
    }

    public void crearDigiDefault() {
        rellenaArray();
    }

    /**
     * Este metodo addDigimon agrega un digimon a la lista del hashset, si el
     * nombre es repetido es devuelve true y no existe es false.
     *
     * @param NAME_Digi
     * @return el resultado del bucle if true o false
     */
    public boolean addDigimon(String NAME_Digi) {

        Digimon digi = new Digimon(NAME_Digi);
        if (DigimonSet.contains(digi)) {
            return true;
        } else {
            DigimonSet.add(digi);
            return false;
        }
    }

    /**
     * Este es un metodo borrar digimon, pasamos por parametro un objeto
     * digimon, comprobaremos que su nombre existe en la lista, si esxiste se
     * comple la condicion y el objeto se remueve de la lista y devuelve un true
     * de que se logro la ejecucion en caso contrario sie el nombre no existe en
     * la lista la condicion no se cumple y devuelve un false
     *
     * @param digi objeto digimon
     * @return devuelve true cuando existe el nomnbre en la lista y lo elimina,
     * false si no existe en ella
     */
    public boolean removeDigimon(Digimon digi) {

        if (DigimonSet.contains(digi)) {
            DigimonSet.remove(digi);
            return true;
        } else {
            return false;
        }

    }

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
    boolean agreg_Digi_Usua_Inicio(Usuario usu) {

        if (lista.containsKey(usu.Nombre_J)) {
            return false;
        } else {
            ArrayList<Digimon> A = new ArrayList();

            for (int i = 0; i < 3; i++) {
                A.add(ListaDigi.get(i));
                lista.put(usu.Nombre_J, A);
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
    boolean agregarUsuario(Usuario usu) {

        if (lista.containsKey(usu.Nombre_J)) {
            return false;
        } else {

            lista.put(usu.Nombre_J, new ArrayList<Digimon>());
            return true;
        }
    }

    ArrayList<Digimon> recuperar(Usuario usu) {
        if (lista.containsKey(usu)) {
            return lista.get(usu);
        } else {
            return null;
        }
    }

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

    /**
     * Este metodo muestra el contenido de la lista
     */
    public static void mostrarLista() {
        DigimonSet.forEach(System.out::println);
    }

    public Set<Map.Entry<String, ArrayList<Digimon>>> total() {

        return lista.entrySet();
    }

}
