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

    static String Nombre_J;
    static String Password;

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
}
