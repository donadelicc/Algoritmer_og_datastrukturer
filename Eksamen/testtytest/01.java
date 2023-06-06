package Eksamen.testtytest;

import Datastrukturer.Stabel.LinearNode;

public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste;
    private LinearNode<T> siste;

    //) a) 

    public KjedetOrdnetListe(T minVerdi, T maksVerdi) {
        LinearNode<T> foerste = new LineaerNode<T>(minVerdi);
        LinearNode<T> siste = new LinearNode<T>(maksVerdi);
        foerste.setNeste(siste);
        antall = 0;
    }
    

    // get – og set-metoder kan du anta
    public int antall() {
        return antall;
    }
    public boolean erTom() {
        return antall == 0;
    }
    //... andre metoder


    // b)
    public T finnMaks() {
        if (erTom())
        throw new EmptyCollectionException("ordnet liste tom");
        T resultat = foerste.getElement();
        LinearNode<T> aktuell = foerste;
        while(aktuell.getNeste() != null) {
            aktuell = aktuell.getNeste();
        }
        resultat = aktuell.getElement();
        return resultat;
    }

    //c) 

    public boolean fjernAlle(T el) {
        if (erTom())
        throw new EmptyCollectionException("tom ordnet liste")
        
        boolean resultat = false;
        int teller = 0;
        LinearNode<T> aktuell = foerste.getNeste();
        LinearNode<T> forrige = foerste;
        while(el.compareTo(aktuell.getElement()) >0 ) {
            forrige = aktuell;              // setter forrige/foerste til verdien før den som skal fjernes
            aktuell = aktuell.getNeste();   // gå til neste
        }

        if(el.equals(aktuell.getElement())) {
            resultat = true;
            teller = 1;
            aktuell = aktuell.getNeste();
            while(el.equals(aktuell.getElement())) {
                aktuell = aktuell.getNeste();
                teller ++;
            }
            //Sletting
            forrige.setNeste(aktuell);
            antall = antall - teller;
        }
        return resultat;
    }



}