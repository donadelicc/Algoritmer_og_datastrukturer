// a) Forklar hva en abstrakt datatype kø er. 

// Svar:
// Kø er en lineær datastruktur der innsetting (bak) og uttak (foran) skjer i begge ender.
// Kø opererer etter FIFO prinsippet der det elementet som ble satt inn sist vil bli først tatt ut. 


public class TabellKoe<T> implements KoeADT<T> {
    private final static int STDK = 100;
    private int bak;
    private T[] koe;

    public tabellKoe() {
    this(STDK);
   }

    public TabellKoe(int startKapasitet) {
        bak = 0;
        koe = (T[]) (new Object[startKapasitet]);
    }

    // b) Lag metoden innKoe som setter inn et element i køen.
    public void innKoe(T element) {
        if(bak == koe.length-1) {
            utvid();
        }
        koe[bak] = element;
        bak++;
    }

    //d) Lag metoden utKoe som returnere og sletter det første elementet i køen
    public T utKoe() {
        if(erTom()) {
            throw new EmptyCollectionException("Koe");
        }
        T resultat = koe[0];
        bak--;
        //flytter elementene en plass frem
        for(int i=0; i < bak; i++) {
            koe[i] = koe[i+1];
        }
        koe[bak] = null;
        return resultat;
    }

    //c) Lag metoden foerste som returnere det første elementet i køen
    public T foerste() {
        if(erTom()) {
            throw EmptyCollectionException("Koe");
        }
        return koe[0];
    }

    private void utvid() {
    // Denne metoden utvider tabellområdet ved å lage en
    // større tabell og kopierer referansene
    // Du antar at denne metoden eksisteter
    …
    }

    public boolean erTom() {
        return (antall == 0);
    }

    public int antall() {
        return antall;
    }

    // e) 
    // Hva er tidskompleksiteten for metoden utkoe (i denne implementasjonen) med
    //    hensyn på flyttinger av elementer uttrykt i stor O-notasjon? Begrunn svaret.
    
    //Svar:
    // O(n) siden alle elementene må flyttes en plass til venstre.




}

