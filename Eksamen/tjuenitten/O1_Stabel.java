package Eksamen.tjuenitten;

import Datastrukturer.Kø.LinearNode;
import Datastrukturer.Stabel.EmptyCollectionException;

public class O1_Stabel {

    // Har denne klassen:
    /*
     *public class KjedetStabel<T> implements StabelADT<T> {
        private LinearNode<T> topp;
        private int antall;
        public KjedetStabel() {
            topp = null;
            antall = 0;
        }
        @Override
        public boolean erTom() {
            return (antall == 0);
        }
    }
    */
    
    // a) Lag metoden push som legger inn et element på toppen av stabelen
    public void push(T el) {
        LinearNode<T> nynode = new LinearNode<T>(el);
        nynode.setNeste(topp);
        topp = nynode;
        antall++;
    }

    // b) Lag metoden pop som fjerner og returnerer et element fra toppen av stabelen
    public T pop() {
        if(erTom()) {
            throw new EmptyCollectionException("Stabel");
        }
        T resultat = topp.getElement();
        topp = topp.getNeste();
        antall--;
        return resultat;
    }

    // c) Lag metoden peek som returnere elementet på toppen av stabelen uten å fjerne det
    public T peek() {
        if(erTom()) {
            throw new EmptyCollectionException("Stabel");
        }
        T resultat = topp.getElement();
        return resultat;
    }





}
