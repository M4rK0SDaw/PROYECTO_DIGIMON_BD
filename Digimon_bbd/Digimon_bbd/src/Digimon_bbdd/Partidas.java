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
public class Partidas {

    public void contadores() {

        //Creamos las variables.
        int parjugada = 0, parganada = 0, tpartida = 0, tevolu = 0, yo = 0, el = 0;

        //Hcemos un bucle para jugar x partidas y hacemos que 'yo' batalle con 'el' con números aleatorios.
        for (int i = 0; i < 50; i++) {

            yo = (int) (Math.random() * 10 + 1);
            el = (int) (Math.random() * 10 + 1);

            //ponemos un contador para que cuente cada vez que hacemos una jugada.
            parjugada++;

            //Hacemos un if para contar cada vez que ganamos y lo almacenamos en el contador 'parganada'. 
            if (yo > el) {
                parganada++;
            }

        }

        //En la variable 'tpartida' guardamos 1 token cada 10 partidas jugadas.
        tpartida = parjugada / 10;

        //En la variable 'tevolu' guardamos 1 token cada 10 partidas ganadas.
        tevolu = parganada / 10;

        //Para finalizar imprimimos todos los datos.
        System.out.println("Yo: " + yo);
        System.out.println("Rival: " + el);
        System.out.println("Partidas jugadas: " + parjugada);
        System.out.println("Partidas ganadas: " + parganada);
        System.out.println("Token cada 10 partidas: " + tpartida);
        System.out.println("Token cada 10 victorias: " + tevolu);
    }

}
