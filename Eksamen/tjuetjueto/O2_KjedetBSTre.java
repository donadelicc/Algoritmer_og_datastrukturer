package Eksamen.tjuetjueto;

import Datastrukturer.Tre.BS.BinaerTreNode;

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>, Iterable<T> {
    private int antall;
    private BinaerTreNode<T> rot;

    public KjedetBSTre() {
        antall = 0;
        rot = null;
    }

    //a)
    public KjedetBSTre(T element) {
        rot = new BinearTreNode<T>(element);
        antall = 1;
    }

    // set- og get-metoder kan du anta
    public int antall() {
        return antall;
    }

    public boolean erTom() {
        return (antall == 0);
    }

    // b) 
    public T finnMin() {
        T resultat = null;
        BinaerTreNode<T> aktuell = rot;
        if(!erTom()){
            while(aktuell.getVenstre() != null){
                aktuell = aktuell.getVenstre();
            }
            resultat = aktuell.getElement();
        }
        return resultat;
    }

    public void skrivInorden() {
        skrivInorden(rot);
    }

    // c) 
    private void skrivInorden(BinaerTreNode<T> p) {
        if(p!=null) {
            skrivInorden(p.getVenstre());
            System.out.print(p.getElement()+ " ");
            skrivInorden(p.getHoyre());
        }
    }

    public int antallNoder() {
        return antallNoder(rot);
    }
    
    // d)
    private int antallNoder(BinaerTreNode<T> p) {
        if(p==null) {
            return 0;
        }
        return 1 + antallNoder(p.getVenstre()) + antallNoder(p.getHoyre());
    }

    public BinaerTreNode<T> tabTilBS(T[] tab) {
        BinaerTreNode<T> rot = tabTilBS(tab, 0, tab.length - 1);
        return rot;
    }

    private BinaerTreNode<T> tabTilBS(T tab[], int start, int siste) {
        // e) Fyll ut
    }
}
