package Eksamen.tjuenitten;

import Datastrukturer.Kø.LinearNode;

public class O5_KjedetOrdneListe {

    // Vi ser på en ordnet liste implementert ved hjelp av en kjedet struktur.

    // a) Lag metoden finnAntallMindre som finner antall elementer (inkludert duplikater) som er mindre enn parameteren.

    public int finnAntallMindre(T el) {
        LinearNode<T> aktuell = foerste;
        int antallMindre = 0;

        while(aktuell != null && aktuell.getElement().compareTo(el) < 0) {
            antallMindre ++;
        }
        return antallMindre;
    }

    // c) Lag metoden fjernDuplikater som fjerner alle duplikater i listen.
    
    public void fjernDuplikater() {
        LinearNode<T> aktuell = foerste;
        LinearNode<T> p = null;
        LinearNode<T> neste = null;
        
        while(aktuell != null) {
            p = aktuell;
            neste = aktuell.getNeste();
            while(neste != null && aktuell.getElement().equals(neste.getElement())) {
                p = neste;
                neste = neste.getNeste();
            }
            if(p != aktuell) {
                akutell.setNeste(p.getNeste()); // elementer mellom aktuell og (til og med) p
                aktuell = neste;                // går videre
            } else {
                aktuell = aktuell.getNeste();   // går videre
            }
        }
        if(p.getNeste() == null){
            siste = aktuell;
        }

    } 
    
}
