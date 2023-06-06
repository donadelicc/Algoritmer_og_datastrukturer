package Eksamen.tjuenitten;

import Datastrukturer.Tre.BS.BinaerTreNode;

public class O3_trær {

    // a) Har BS-treet: 50, 30 - 60, 10 - 45, 55 - 70, 5 - 40, 65, 35
    /*
    i) Vi setter inn ny node med verdien 32 i treet T. Hvor blir den plassert?
    Svar: Venstrebarn til 35
    ii) Vi setter inn ny node med verdien 75 i det opprinnelige treet T. Hvor blir noden plassert?
    Svar: Høyrebarn til 70
    iii) Vi sletter elementet med verdien 50 i det opprinnelige treet T. Hvilken verdi vil rotnoden ha etter sletting? 
    Svar: Her vil enten størst verdi i venstre undertre eller minst verdi i høyre undertre bli rotnoden.
            Altså, node 45 eller 55.
    */

    // b) 
    /*
    I) Hva mener vi med at et binært tre er balansert? Forklar hvorfor det er viktig at et bs-tre er balansert.
    Svar: For alle noder så skal forskjellen på høyden i venstre undertre og høyre undertre være maksimalt 1. 
            Når treet er balansert vil søking, insetting og sletting kunne gjøres i tid O(log n).
    ii) Hva er tidskompleksiteten uttrykt i stor O-notasjon med hensyn på sammenligninger
        (i forbindelse med søking og innsetting) i et bs-tre som er
            1) helt ubalansert
    Svar: O(n)
            2) tilnærmet helt balansert.
    Svar: O(log n)
    iii) Høyrerotasjon av et balansert tre:
    Svar: 10, 5 -20, 2, 15 - 30
    Iv) Venstre rotasjon av et balansert tre.
    Svar: 7, 5 - 6, 9, 4, 10
     */

    // Vi ser på klassen KjedetBSTre

    // c) Lag metoden finnMin som returnere det minste elementet i BS-treet.

    public T finnMin() {
        T resultat = null;
        if(!erTom()){
            BinaerTreNode<T> aktuell = rot;
            while(aktuell.getVenstre() != null) {
                aktuell = aktuell.getVenstre();
            }
            resultat = aktuell.getElement();
        }
        return resultat;
    }

    // d) ) Lag den rekursive metoden antallMindre som returnerer antall elementer i bstreet
    //       som er mindre enn elementet gitt som parameter.

    private int antallMindre(BinaerTreNode<T> t, T element) {
        int mindre = 0;
        if(t != null) {
            mindre = antallMindre(t.getVenstre(), element);
            if(t.getVenstre().compareTo(element) < 0){
                mindre += 1 + antallMindre(t.getHoyre, element);
            }
        }
        return mindre;
    }
    
    // e) Vi ser på fler-veis søketre
    //  i) Forklar hva vi mener med et 2-3 tre. Få fram hva vi mener med 2-node og3-node
    //  Svar: Et 2-3 tre er et balansert søketre der hver node kan være en 2-node eller en 3-node:
    //      En 2-node har ett nøkkelverdi-element og to barn - et høyre og ventsre barn.
    //      En 3-node har to nøkkelverdi-elementer og tre barn - et høyre, et midtre og venstre barn.
    //  i) Hvordan søker vi et i 2-3 tre?
    //  Svar: Vi sammenligner med rotnoden. Er verdien vi søker med mindre går vi til venstre undertre oog
    //        er verdien større går vi til høyre undertre. Dette søket gjentas rekursivt til søket treffer en node med samme verdi.

    
}
