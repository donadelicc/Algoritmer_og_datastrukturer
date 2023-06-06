package Eksamen.tjueatten;

public class UordnetKjedetListe<T> implements UordnetKjedetListeADT<T>{

    private int antall;
    private LinearNode<T> foerste, siste;
    
    public UordnetKjedetListe (){
        antall = 0;
        foerste = null;
        siste = null;
    }

    //... andre metoder i klassen

    //a) 
    // Skriv metoden public int antallLike(T el){…}som finner og returnerer antall elementer i listen
    //  som er lik elementet gitt som parameter.

    @Override
    public int antallLike(T el) {
        int antallLike = 0;
        LinearNode<T> aktuell = foerste;

        while(aktuell != null) {
            if(aktuell.getElement().equals(el)) {
                antallLike ++;
            }
            aktuell = aktuell.getNeste();
        }
        return antallLike;
    }


    //b) 
    // Skriv metoden public T minste() {…} som finner og returnerer det minste elementet ilisten.
    // Metoden returnerer null-referansen hvis listen er tom.

    public T minste() {
        T minste;
        if(foerste != null) {
            minste = foerste.getElement();
            LinearNode<T> aktuell = foerste.getNeste();
            while(aktuell != null) {
                if(aktuell.getElement().compareTo(minste) < 0) {
                    minste = aktuell.getElement();
                }
                aktuell = aktuell.getNeste();
            }
        }
        return minste;
    }

    //c)
    // Lag den rekursive metoden, inneholderRek, som avgjør om et element finnes i den uordnede listen
    public boolean inneholder(T element){
        return inneholderRek(foerste, element);
    }
    
    private boolean inneholderRek(LinearNode<T> denne, T element) {
        boolean funnet = false;
        // Hvis den gjeldende noden er null, har vi nådd slutten av listen
        // uten å finne elementet. Sett "funnet" til false.
        if (denne == null) {
            funnet = false;
        }
        // Hvis elementet i den gjeldende noden er lik det søkte elementet,
        // har vi funnet det. Sett "funnet" til true.
        else if (element.equals(denne.getElement())) {
            funnet = true;
        }
        // Hvis ingen av de to betingelsene over er oppfylt, kaller vi
        // rekursivt på den neste noden i listen for å fortsette søket.
        else {
            funnet = inneholderRek(denne.getNeste(), element);
        }
        return funnet;
    }

        

}


