package Eksamen.tjueen;

public class O3_Flettesortering {

    //a) Forklar hva void flette(T[] tabell, int forste, int midten, int siste) gjør:

    /*
     * Denne metoden fletter de sorterte delene som ligger ved siden av hverandre
     * i tabellen til en sortert del. 
     * Venstre del starter på indeks foerste og slutter på indeks midten.
     * Høyre del starter på indeks midten +1 og slutter på indeks siste.
     */

    //b)

    void fletteSort(T[] tab, int foerste, int siste) {
        if(foerste < siste) {
            int midten = (foerste + siste)/2;
            fletteSort(tab, foerste, midten);
            fletteSort(tab, midten+1, siste);
            flette(tab, foerste, midten, siste);
        }
    }

    //c) Vis hvordan tabellen under blir flettet med flettesorteringalgoritmen:
    /*
     * tab[8,1,7,3,5,6,4,2]
     * 
     * Svar:
     * Deler tabellen i to deler [8,1,7,3] og [5,6,4,2]
     * Oppdeling:
     * 8                            1
     * 1                            8
     *          7               3
     *          3               7
     * 1        3               7   8
     * 
     *                  5    6
     *                  5    6
     *      4       2
     *      2       4
     *      2       4   5   6
     * 
     * Sammenslåing:
     * 1    2   3   4   5   6   7   8
     * Gir den sorterte tabllen: [1,2,3,4,5,6,7,8]
     * 
     */

     

    
}
