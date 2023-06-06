package Eksamen.tjuetjue;

import Datastrukturer.Tre.BS.BinaerTreNode;

public class HJELP_O5_KjedetBSTre {

    // Har en KjedetBSTre klasse som implementerer en BSTreADT klasse.
    
    
    // a) Lag en rekursiv metode, toString som lager en strengrepresentasjon av elementene i
    //    bs-treet sortert i rekkefølge med et linjeskift mellom hvert element
    //    (Når vi har et bs-tre med noder, så er det blitt brukt compareTo ved innsetting slik at vi
    //     alltid har en ordning).

    public String toString() {
        return toString(rot);
    }

    private String toStringRek(BinaerTreNode<T> p) {
        String resultat = "\n";
        if(p != null) {
            resultat += toStringRek(p.getVenstre());
            resultat += p.getElement().toString();
            resultat += toStringRek(p.getHoyre());
        }
        return resultat;
    }

    // b) Lag en rekursiv metode, verifiserBSTre som verifiserer om et binært tre er et
    //    binært søketre. Parameteren til hovedmetoden (ikke-rekursiv) er en referanse til et binært tre.

    public static <T extends Comparable<T>> boolean verifiserBSTre(BinaerTre<T> detAndre) {
        return verifiserBSTre(detAndre.getRot());
    }
    private static <T extends Comparable<T>> boolean verifiserBSTre(BinaerTreNode<T> p){
        if(p == null){
            return true;
        }
        // Sjekker roten/foreledrenoden er mindre eller lik venstre barn
        if(p.getElement().compareTo(p.getVenstre().getElement()) <= 0) {
            return false;
        }
        // Sjekker roten/foreledrenoden er større enn høyre barn
        if(p.getElement().compareTo(p.getHoyre().getElement()) > 0) {
            return false;
        }
        // Rekursivt kall som går gjennom hele treet på venstre og høyre side
        return verifiserBSTre(p.getVenstre()) && verifiserBSTre(p.getHoyre());

    }
    
}
