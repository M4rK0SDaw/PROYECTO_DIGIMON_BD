/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd;

/**
 *
 * @author marek
 */
public class Usuario {

    String Nombre_J;
    String Password;
    int Match_Win;
    int Match_Play;

    /**
     * Este es un metodo constructor de Jugador, se le dan los valores de nombre
     * y de contrasenya
     *
     * @param Nombre_J : parametro de nombre del jugador.
     * @param Password : contrasenya para el jugador .
     */
    Usuario(String Nombre_J, String Password) {
        this.Nombre_J = Nombre_J;
        this.Password = Password;
    }

    /**
     ** Este método devuelve el nombre del objeto.
     *
     * @return Nombre_J: devuelve el nombre del usuario
     */
    String getNombreU() {
        return Nombre_J;
    }

    /**
     * Este metodo establece el nombre del objeto
     *
     * @return
     */
    void setNombreU() {
        this.Nombre_J = Nombre_J;

    }

    void setPasswordU() {
        this.Password = Password;
    }

    String getPasswordU() {
        return Nombre_J;

    }

    boolean compruebaNombre() {
        return false;

    }

    boolean compruebaPassword() {
        return false;

    }

    void muestraDigimon() {
    }

    /*
    Hay que comprobar que el nombre no estes repetido 
    
    la contrasenya escribirla dos veces para comprobar que sea igual
    
    
    
    
    
     */
}
