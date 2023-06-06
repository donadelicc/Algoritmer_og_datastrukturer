package Eksamen.tjuetjue;

public class O4_KjedetUordnetListe {
    
    //a) Lag en rekursiv toString()-metode som lager en strengrepresentasjon av elementene i
    //   den uordnete kjedete listen med et linjeskift mellom hvert element.

    public String toString() {
        return toString(foerste);
    }

    private String toString(LinearNode<T> p) {
        if(p == null){
            return "";
        } else {
            return p.getElement() + "\n" + toString(p.getNeste());
        }
    }

    // b) Lag metoden settInn som setter inn et element fremst i listen

    public void settInn(T el) {
        LinearNode<T> nynode = LinearNode<T>(el);
        nynode.setNeste(foerste);
        foerste = nynode;
        antall++;
    }

    //c) Lag en metode flyttFoersteTilSiste som flytter det første elementet sist i listen. 

    public void flyttFoersteTilSiste() {
        if(antall > 1) {
            LinearNode<T> tmp = foerste;
            LinearNode<T> siste = foerste;
            while(siste.getNeste() != null) { // loop-er til siste element i listen
                siste = siste.getNeste();
            }
            siste.setNeste(tmp); // etter vi har funnet siste så setter vi siste element til å være lik det første
            foerste = foerste.getNeste(); // flytter det andre elementet til plassen til det første
        }
    }

    // d) Lag en metode finnNestMinste som finner og returnerer det nest minste elementet i
    //    listen bare ved å gå gjennom listen en gang. Hvis listen har færre enn to elementer, skal
    //    metoden returnere null-referansen.

    public T finnNestMinste() {
        T svar = null;
        if(antall > 2) {
            return null;
        } else {            
            LinearNode<T> minste = foerste;
            LinearNode<T> nesteMinste = foerste;
            LinearNode<T> aktuell = foerste.getNeste();
            while(aktuell != null ) {
                if(aktuell.getElement().compareTo(minste.getElement()) < 0) {
                    nestMinste = minste;
                    minste = aktuell;
                } else if(aktuell.getElement().compareTo(nestMinste.getElement()) < 0) {
                    nestMinste = aktuell;
                }
                aktuell = aktuell.getNeste(); // går til neste node
            }
            svar = nestMinste.getElement();
        }
        return svar;
    }

}
