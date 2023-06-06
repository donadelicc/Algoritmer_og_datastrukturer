package Eksamen.tjueen;

import Datastrukturer.Kø.LinearNode;

public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste;
    private LinearNode<T> siste;

    public int antall() {
        return antall;
    }
    public boolean erTom() {
        return antall == 0;
    }

    // a)
    public KjedetOrdnetListe(T minverdi, T maksverdi) {
        foerste = new LinearNode<T>(minverdi);
        siste = new LinearNode<T>(maksverdi);
        foerste.setNeste(siste);
        antall = 0; 
    }

    //b) 
    public T finnMaks() {
        if(!erTom()) {
            throw new EmptyCollectionException("ordnet liste tom");
        } else {
            LinearNode<T> aktuell = foerste;
            while(aktuell.getNeste() != siste) {
                aktuell = aktuell.getNeste();
            }
            return aktuell.getElement();
        }
    }

    //c) 

    public boolean fjernAlle(T el) {
        if (erTom()) {
            throw new EmptyCollectionException("tom ordnet liste")
        }
        LinearNode<T> aktuell = foerste;
        LinearNode<T> neste = aktuell.getNeste();
        boolean slettetAlle = false;
        int teller = 0;
        if(aktuell != null && !slettetAlle) {
            for(int i=0; i< antall;i++) {
                if(el.equals(aktuell.getElement())) {
                    aktuell.setNeste(neste);
                    teller++;
                    aktuell = aktuell.getNeste();
                } else {
                    aktuell = aktuell.getNeste();
                }
                slettetAlle = true;
            }
        }
        return slettetAlle;
    }

    
    

    
}

