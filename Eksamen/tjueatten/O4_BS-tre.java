// a)
// Har dette binære treet:
/*
           10
         /    \
        11     12
       /  \   /
      14  15 8
              \
                4
 */

// i)
// Gi en preorden, inorden og postorden gjennomgang av treet over. Du trenger ikke å
//   gi noen forklaring, bare skrive opp rekkefølgen.

// Preorden:
// 10, 11, 14, 15, 12, 8, 4
// Inorden
// 14, 11, 15, 10, 8, 4, 12
//Postorden
// 14, 15, 11, 4, 8, 12, 10

// ii)

public class BinaerTre<T> implements BinaerTreADT<T> {
    private BinaerTreNode<T> rot;
    private int antall;

    public BinaerTre() {
        rot = null;
        antall = 0;
    }

    public BinaerTre(T element) {
        rot = new BinaerTreNode<T>(element);
        antall = 1;
    }

    public BinaerTre(T element, BinaerTre<T> vt, BinaerTre<T> ht) {
        // Lager et binært tre av to eksisterende binære trær, vt og ht
        // og en ny rot med gitt data
        rot = new BinaerTreNode<T>(element);
        antall = 1;
        rot.setVenstre(vt.getRot());
        antall = antall + vt.antall();
        rot.setHoyre(ht.getRot());
        antall = antall + ht.antall();
    }

    public BinaerTreNode<T> getRot() {
        return rot;
    }

    public int antall() {
        return antall;
    }

    public int hoyde() {
        int resultat = -1;
        if (!erTom()) {
            resultat = hoydeRek(rot);
        }
        return resultat;
    }

    private int hoydeRek(BinaerTreNode<T> p) {
        int resultat = -1;
        if(p != 0) {
            int venstreHoyde = hoydeRek(p.getVenstre());
            int hoyreHoyde = hodeRek(p.getHoyre());
            if(venstreHoyde > hoyreHoyde) {
                resultat = 1 + venstreHoyde;
            } else {
                resultat = 1 + hoyreHoyde;
            }
        }
        return resultat;
    }


}

// b) Definisjon av et BS-tre

// Svar:
    // Et binært tre der for hver node så vil nodene i venstre undertre ha verdier mindre enn foreldre-noden
    //  og nodene i høyre undertre ha verdier som er større eller lik verdien til foreledre-noden.

// c) og d) Sette inn  og slette elementer fra et BS-tre. TEGNE tre

// e) Lag metoden finnMin som finner og returnere det minste elementet i bs-treet.

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T> {
    private int antall;
    private BinaerTreNode<T> rot;
    public KjedetBSTre() {
        antall = 0;
        rot = null;
    }
    public KjedetBSTre(T element) {
        antall = 1;
        rot = new BinaerTreNode<T>(element);
    }

    public int antall() {
        return antall;
    }
    public T finnMin(){
        T svar = null;
        if(rot != null) {
            BinaerTreNode<T> aktuell = rot.getVenstre();
            while(aktuell.getNeste() != null){
                aktuell = aktuell.getVenstre();
            }
        }
        return aktuall.getElement();
    }

}

// f) Lag den rekursive metoden, private BinaerTreNode<T> sortTabTilBSTRek(T[] data, int min, int maks)
    // som lager et bs-tre av elementene i en sortert tabell. Den minste indeksen er kalt min, og den største indeksen er kalt maks.

public KjedetBSTre sortTabTilBST(T[] data){
    KjedetBSTre ny = new KjedetBSTre();
    ny.rot = sortTabTilBSTRek(data, 0, data.length - 1);
    ny.antall = data.length;
    return ny;
}

private BinaerTreNode<T> sortTabTilBSTRek(T[] data, int min, int maks) {
    if(min > maks) {
        return null;
    }
    int midten = (min + maks)/2;
    
    rot = new BinaerTreNode(data[midten]);
    rot.setVentre(sortTabTilBSTRek(data, min, midten-1));
    rot.setHoyre(sortTabTilBSTRek(data, midten+1,maks));

    return rot;
}





