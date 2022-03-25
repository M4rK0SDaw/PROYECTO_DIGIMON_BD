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

     String name_j;
     String passwd;
    int adminUsu;

    public Usuario(String NAME_J, String passwd, int adminUsu) {
        this.name_j = NAME_J;
        this.passwd = passwd;
        this.adminUsu=adminUsu;

    }

    public String getNAME_J() {
        return name_j;
    }

    public void setNAME_J(String name_j) {
        this.name_j = name_j;
    }

    public String getPASSWD() {
        return passwd;
    }

    public void setPASSWD(String passwd) {
        this.passwd = passwd;
    }

    public int getAdministrador() {
        return adminUsu;
    }

    public void setAdministrador(int adminUsu) {
        this.adminUsu = adminUsu;
    }

}
