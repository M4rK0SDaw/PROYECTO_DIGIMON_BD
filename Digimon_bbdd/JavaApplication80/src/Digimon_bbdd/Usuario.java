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

    public Usuario(String Nombre_J, String Password) {
        this.Nombre_J = Nombre_J;
        this.Password = Password;

    }
    Usuario(Usuario nombre) {
        this.Nombre_J = Nombre_J;
    }
    public String getNombre_J() {
        return Nombre_J;
    }

    public void setNombre_J(String Nombre_J) {
        this.Nombre_J = Nombre_J;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

//    Usuario() {
//        Nombre_J = "Manuel";
//        Password = "123";
//    }
    /**
     * Este es un metodo constructor de Jugador, se le dan los valores de nombre
     * y de contrasenya
     *
     * @param Nombre_J : parametro de nombre del jugador.
     * @param Password : contrasenya para el jugador .
     */
  
//
//    /**
//     ** Este método devuelve el nombre del objeto.
//     *
//     * @return Nombre_J: devuelve el nombre del usuario
//     */
//    String getNombreU() {
//        return Nombre_J;
//    }
//
//    /**
//     * Este metodo establece el nombre del objeto
//     *
//     * @return
//     */
//    void setNombreU() {
//        this.Nombre_J = Nombre_J;
//
//    }
//
//    void setPasswordU() {
//        this.Password = Password;
//    }
//
//    String getPasswordU() {
//        return Nombre_J;
//
//    }

    
}
