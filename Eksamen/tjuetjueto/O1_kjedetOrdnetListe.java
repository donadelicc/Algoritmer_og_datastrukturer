package Eksamen.tjuetjueto;

import Datastrukturer.Kø.LinearNode;

public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste, siste;

    // a)
    public KjedetOrdnetListe(int p1, int p2) {
        LinearNode<T> foerste = new LinearNode<>(p1);
        LinearNode<T> siste = new LinearNode<>(p2);
        foerste.setNeste(siste);
        antall = 0;
    }

    // b)
    public T fjernFoerste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");
        T resultat = foerste.getElement();
        // huske å sette forrige foerste til neste
        foerste = foerste.getNeste();
        antall--;
        return resultat;
    }

    // c)
    public void leggTil(T element) {
        LinearNode<T> nynode = new LinearNode<>(element);
        LinearNode<T> aktuell = foerste;
        LinearNode<T> forrige = null;
        while (aktuell != null && element.compareTo(aktuell.getElement()) > 0) {
            forrige = aktuell;
            aktuell = aktuell.getNeste();
        }
        // hvis tom liste
        if (forrige == null) {
            nynode.setNeste(foerste);
            foerste = nynode;
        } else {
            nynode.setNeste(aktuell);
            forrige.setNeste(nynode);
        }
        antall++;
    }
    // d) Har metoden leggTilListe under. 
    /*
     *Vi ser på sammenligninger (kall av compareTo). I analysen av metoden leggTilListe,
        antar vi at det er n/2 elementer både i this-listen og i parameter-listen. Hva blir
        tidskompleksiteten uttrykt i stor O-notasjon for metoden gitt under?
     */

    public KjedetOrdnetListe<T> leggTilListe(KjedetOrdnetListe<T> denAndre) {
        KjedetOrdnetListe<Integer> nyListe = new KjedetOrdnetListe<Integer>();
        LinearNode<T> denne = foerste;

        // Legge til this-listen
        for (int i = 0; i < antall; i++) {
            nyListe.leggTil(denne.getElement());
            denne = denne.getNeste();
        }
        // Legge til den andre listen
        denne = denAndre.getFoerste();
        for (int i = 0; i < denAndre.antall(); i++) {
            nyListe.leggTil(denne.getElement());
            denne = denne.getNeste();
        }
        return nyListe;
    }

    // Svar:
    /*
     * 
     */

    public KjedetOrdnetListe<T> fletteTilListe(KjedetOrdnetListe<T> denAndre) {
        // e)… Fyll ut
    }
}