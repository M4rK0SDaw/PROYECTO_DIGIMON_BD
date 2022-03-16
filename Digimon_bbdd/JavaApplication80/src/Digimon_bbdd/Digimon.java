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
    String TYPE_DIGI;
    int LVL;

    Digimon(String NAME_Digi, int ATTACK, int DEFENSE, int TYPE_DIGI, int LVL) {
        this.TYPE_DIGI = "Vacuna";
        this.DEFENSE = 40;
        this.ATTACK = 40;
        this.LVL = 1;
        this.NAME_Digi = "Gabumon";
    }

    Digimon(String NAME_Digi, int ATTACK, int DEFENSE, String TYPE_DIGI, int LVL) {
        this.TYPE_DIGI = "Vacuna";
        this.DEFENSE = DEFENSE;
        this.NAME_Digi = NAME_Digi;
        this.ATTACK = ATTACK;
        this.LVL = LVL;
    }

    Digimon(String NAME_Digi) {
        this.NAME_Digi = NAME_Digi;
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

    void setTYPE_DIGI(String tipo) {
        this.TYPE_DIGI = TYPE_DIGI;
    }

    String getTYPE_DIGI() {
        return TYPE_DIGI;

    }

    int getLVL(int nivel) {
        return LVL;

    }

    void setLVL() {
        this.LVL = LVL;
    }

    void tipoDeDigimon(int tipo) {

        switch (tipo) {
            case 1:
                TYPE_DIGI = "Vacuna";
                break;
            case 2:
                TYPE_DIGI = "Virus ";
                break;
            case 3:
                TYPE_DIGI = "Animal";
                break;
            case 4:
                TYPE_DIGI = "Planta";
                break;
            case 5:
                TYPE_DIGI = "Elemental";
                break;
            default:
                TYPE_DIGI = "Vacuna";
                break;
        }
    }

    void tipoDeNivel(int num) {

        switch (num) {
            case 1:
                LVL = 1;
                break;
            case 2:
                LVL = 2;
                break;
            case 3:
                LVL = 3;
                break;
            default:
                LVL = 1;
                break;
        }

    }
}
