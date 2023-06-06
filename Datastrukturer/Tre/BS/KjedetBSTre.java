package Datastrukturer.Tre.BS;

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T> {
    private int antall;
    private BinaerTreNode<T> rot;

    /******************************************************************
     * Oppretter et tomt binært søketre.
     ******************************************************************/
    public KjedetBSTre() {
        antall = 0;
        rot = null;
    }

    /******************************************************************
     * Oppretter et binært søketre med en node..
     ******************************************************************/
    public KjedetBSTre(T element) {
        antall = 1;
        rot = new BinaerTreNode<T>(element);
    }
    // hent – og setmetoder kan du anta

    /***********************************************************************
     * Returnerer sann hvis bs-treet er tomt, elles usann.
     **********************************************************************/
    public boolean erTom() {
        return (antall == 0);
    }

    /************************************************************************
     * Returnerer det minste elementet fra bs-treet.
     *************************************************************************/
    public T finnMin() {
        // … fyll ut
    }

    /*********************************************************************
     * finner antall elementer mindre enn elmenentet gitt som parameter
     **********************************************************************/
    public int antallMindreEnn(T element) {
        return antallMindreEnn(rot, element);
    }

    private int antallMindre(BinaerTreNode<T> t, T element) {
        // … fyll ut
    }
}// class