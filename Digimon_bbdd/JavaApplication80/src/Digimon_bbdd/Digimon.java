/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digimon_bbdd;

/**
 *
 * @author Marek
 */
public class Digimon {

    int ID_DIGIMON;
    String NAME_Digi;
    int ID_EVOLUTION;
    int ATTACK;
    int DEFENSE;
    int TYPE_DIGI;
    int LVL;

    Digimon(int ATTACK, int DEFENSE, int TYPE_DIGI) {
        this.TYPE_DIGI = 1;
        this.DEFENSE = 40;
        this.ATTACK = 40;
    }

    Digimon(String NAME_Digi, int ATTACK, int DEFENSE, int TYPE_DIGI) {
        this.TYPE_DIGI = 1;
        this.DEFENSE = DEFENSE;
        this.NAME_Digi = NAME_Digi;
        this.ATTACK = ATTACK;
    }

    Digimon(String NAME_Digi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setNAME_Digi(String nombre) {
        this.NAME_Digi = NAME_Digi;
    }

    String getNAME_Digi() {
        return NAME_Digi;

    }

    void setATTACK(int ataque) {
        this.ATTACK = ATTACK;
    }

    int getATTACK() {
        return ATTACK;

    }

    void setDEFENSE(int defensa) {
        this.DEFENSE = DEFENSE;
    }

    int getDEFENSE() {
        return DEFENSE;

    }

    void setTYPE_DIGI(int tipo) {
        this.TYPE_DIGI = TYPE_DIGI;
    }

    int getTYPE_DIGI() {
        return TYPE_DIGI;

    }

    int getLVL(int nivel) {
        return LVL;

    }

    void setLVL() {
        this.LVL = LVL;
    }

}
