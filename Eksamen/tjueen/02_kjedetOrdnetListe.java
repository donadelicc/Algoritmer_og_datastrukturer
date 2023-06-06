package Eksamen.tjueen;

import Datastrukturer.Kø.LinearNode;

public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste;
    private LinearNode<T> siste;
    
    public boolean erLike(KjedetOrdnetListe<T> denAndre) {
        if (antall == denAndre.antall){
            return erLikRek(foerste, denAndre.foerste);
        } else {
            return false;
        }
    }
    // a) 
    private boolean erLikRek(LinearNode<T> p1, LinearNode<T> p2) {
        boolean erLike = false;
        if(p1 == null) {
            return true;
        } else {
            T e1 = p1.getElement();
            T e2 = p2.getElement();
            if(e1.equals(e2)){
                return erLikRek(p1.getNeste(), p2.getNeste());
            } else {
                return false;
            }
        }
    }


    //b) 
    public void snu() {
        LinearNode<T> r, n, s;
        s = foerste;
        siste = foerste;
        r = null;
        while(s!=null) {
            n = s;
            s = s.getNeste();
            n.setNeste(r);
            r = n;
        }
        foerste = r;
    }

    

}
