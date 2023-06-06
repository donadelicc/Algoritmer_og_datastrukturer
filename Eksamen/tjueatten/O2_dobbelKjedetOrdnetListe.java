public class DobbelKjedetOrdnetListe<T extends Comparable<T>> implements DobbelKjedetOrdnetListeADT<T> {
    private DobbelNode<T> foerste;
    private DobbelNode<T> siste;
    private int antall;

    // …konstruktør
    // …andre metoder


    // a)
    // Lag konstuktuøren for klassen. Konstruktøren skal opprette en tom liste.

    public DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi){
        foerste = new DobbelNode<T>(minVerdi);
        siste = new DobellNode<T>(maksVerdi);
        foerste.setNeste(siste);
        siste.setForrige(foerste);
        antall = 0;
    }

    // b)
    // Lag metoden leggTil som legger til et element til i listen. 

    public void leggTil(T el) {
        // Oppretter en ny node med elementet som skal legges til
        DobbelNode<T> nyNode = new DobbelNode<T>(el);
        // Setter "aktuell" til å være noden etter første noden i listen
        DobbelNode<T> aktuell = foerste.getNeste();
    
        // Finner riktig posisjon for å sette inn den nye noden
        while (el.compareTo(aktuell.getElement()) > 0) {
            aktuell = aktuell.getNeste();
        }
        // Setter opp koblingene for den nye noden
        nyNode.setNeste(aktuell);
        nyNode.setForrige(aktuell.getForrige());
        // Oppdaterer koblingene for nodene rundt den nye noden
        aktuell.getForrige().setNeste(nyNode);
        aktuell.setForrige(nyNode);

        antall++;
    }

    
    




}