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

    Digimon() {
    }

    Digimon(String NAME_Digi) {
        this.NAME_Digi = NAME_Digi;
        TYPE_DIGI = "Vacuna";
        DEFENSE = 40;
        ATTACK = 40;
        LVL = 1;
    }

  public  Digimon(String NAME_Digi, int ATTACK, int DEFENSE, int LVL, String TYPE_DIGI) {

        this.DEFENSE = DEFENSE;
        this.NAME_Digi = NAME_Digi;
        this.ATTACK = ATTACK;
        this.LVL = LVL;
         this.TYPE_DIGI = TYPE_DIGI;
    }

    /*Digimon(String NAME_Digi) {
        this.NAME_Digi = NAME_Digi;
    }*/
    public int getID_DIGIMON() {
        return ID_DIGIMON;
    }

    public void setID_DIGIMON(int ID_DIGIMON) {
        this.ID_DIGIMON = ID_DIGIMON;
    }

    public String getNAME_Digi() {
        return NAME_Digi;
    }

    public void setNAME_Digi(String NAME_Digi) {
        this.NAME_Digi = NAME_Digi;
    }

    public int getID_EVOLUTION() {
        return ID_EVOLUTION;
    }

    public void setID_EVOLUTION(int ID_EVOLUTION) {
        this.ID_EVOLUTION = ID_EVOLUTION;
    }

    public int getATTACK() {
        return ATTACK;
    }

    public void setATTACK(int ATTACK) {
        this.ATTACK = ATTACK;
    }

    public int getDEFENSE() {
        return DEFENSE;
    }

    public void setDEFENSE(int DEFENSE) {
        this.DEFENSE = DEFENSE;
    }

    public String getTYPE_DIGI() {
        return TYPE_DIGI;
    }

    public void setTYPE_DIGI(String TYPE_DIGI) {
        this.TYPE_DIGI = TYPE_DIGI;
    }

    public int getLVL() {
        return LVL;
    }

    public void setLVL(int LVL) {
        this.LVL = LVL;
    }

    @Override
    public String toString() {
        return "Digimon{" + "NAME_Digi=" + NAME_Digi + ", ATTACK=" + ATTACK + ", DEFENSE=" + DEFENSE + ", TYPE_DIGI=" + TYPE_DIGI + ", LVL=" + LVL + '}';
    }

}
