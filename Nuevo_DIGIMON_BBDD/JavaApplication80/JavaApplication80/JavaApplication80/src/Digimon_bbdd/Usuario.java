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

    private String NAME_J;
    private String PASSWD;
    private Boolean Administrador;

    public Usuario(String NAME_J, String PASSWD) {
        this.NAME_J = NAME_J;
        this.PASSWD = PASSWD;

    }

    public String getNAME_J() {
        return NAME_J;
    }

    public void setNAME_J(String NAME_J) {
        this.NAME_J = NAME_J;
    }

    public String getPASSWD() {
        return PASSWD;
    }

    public void setPASSWD(String PASSWD) {
        this.PASSWD = PASSWD;
    }

    public Boolean getAdministrador() {
        return Administrador;
    }

    public void setAdministrador(Boolean Administrador) {
        this.Administrador = Administrador;
    }

}
