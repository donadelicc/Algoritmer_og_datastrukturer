package Eksamen.tjuenitten;

public class O4_Haug {

    // c) Lag metoden reparerOpp. Denne metoden skal treet tilbake til en maksimumshaug etter insetting av siste blad.

    private void reparerOpp() {
		T hjelp;
        int node;
        int forelder;
        node = antall -1; //Siste node
        forelder = (node-1)/2;
        boolean ferdig = false;

        while((node!=0) && (!ferdig)) {
            if((data[node]).compareTo(data[forelder]) > 0) {
                hjelp = data[node]; // Bytter om data i forelder
                data[node] = data[forelder];
                data[forelder] = hjelp;
                node = forelder; // går et trinn oppover
                forelder = (node-1)/2;
            } else {
                ferdig = true;
            }
        }
	}

    // d) Lag en metode som avgjør om et tre med rot r, er en maksimumshaug.
    // Vi har en tabell som er fyllt i alle posisjoner fra og med indeks 0 til og med indeks m.
    // Indeks r i tabellen der 0 <= r <= m, så vil r være rot i et binært tre. 

    public static boolean erHaug(Comparable data[], int r, int m) {
        if(r > (m-1)/2) {
            return true;
        }
        if(data[r].compareTo(data[2*r+1]) >= 0 && (2*r+2 < m) && data[r].compareTo(data[2*r+2]) >=0
        && erHaug(data,2*r+1, m) && erHaug(data,2*r+2, m)) {
            return true;
        }
        return false;
    }


    
}
