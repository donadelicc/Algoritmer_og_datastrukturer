package Eksamen.testtytest;

import Datastrukturer.Stabel.LinearNode;

public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste;
    private LinearNode<T> siste;

    // get – og set-metoder kan du anta
    public void snu() {
    // fyll inn
    }
    public boolean erLike(KjedetOrdnetListe<T> denAndre) {
        if (antall == denAndre.antall){
            return erLikRek(foerste, denAndre.foerste);
        } else {
            return false;
        }
    }
    //... andre metoder

    private boolean erLik(LinearNode<T> p1, LinearNode<T> p2) {
        if(p1 == null){
            return true;
        } else {
            T e1 = p1.getElement();
            T e2 = p2.getElement();
            if(e1.equals(e2)) {
                return erLik(p1.getNeste(), p2.getNeste());
            } else {
                return false;
            }
        }
    }
}

