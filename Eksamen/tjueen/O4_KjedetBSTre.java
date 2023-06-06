package Eksamen.tjueen;

import Datastrukturer.Tre.BS.BinaerTreNode;

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T> {
    private int antall;
    private BinaerTreNode<T> rot;
    public KjedetBSTre() {
        antall = 0;
        rot = null;
    }

    // a) 
    public T finnMinste() {
        BinearTreNode<T> aktuell = rot;
        T resultat = null;
        if(!erTom()) {
            while(aktuell.getVenstre() != null) { // går til bladet helt nederst til venstre i venstre undertre
                aktuell = aktuell.getVenstre();
                resultat = aktuell.getElement();
            }
        }
        return resultat;
    }
    public int antallBlad() {
        return antallBladRek(rot);
    }

    //b) 
    private int antallBladRek(BinaerTreNode<T> p) {
        if(p== null){
            return 0;
        } else if(p.getVenstre() == null && p.getHoyre() == null){
            return 1;
        } else {
            return antallBladRek(p.getVenstre()) + antallBladRek(p.getHoyre());
        }
    }

    //c) Sletting av et element i et BS-tre
    /*
     * i) Forklar hvilke tre tilfeller man ser på ved sletting av et element i et BS-tre
     * Svar:
     * 1) Ser først om elementet du skal slettet er større eller mindre enn roten.
     *    Er elementet mindre, skal vi slette fra venstre undertre
     *    Er elementet størrem skal vi slette fra høyre undertre.
     */
}
    
