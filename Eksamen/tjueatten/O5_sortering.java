public static <T extends Comparable<T>> void utvalgSortering( T[] data) {
    int minste;
    T temp;
    for (int neste = 0; neste < data.length - 1; neste++) {
        minste = neste; 
        for (int sok = neste + 1; sok < data.length; sok++) {
            if (data[sok].compareTo(data[minste]) < 0) {
                minste = sok;
            }
        }
        // indre for-løkke
        /** Bytt verdiene */
        temp = data[minste];
        data[minste] = data[neste];
        data[neste] = temp;
    }// ytre for-løkke
}// metode

// i) Utvalgssortering av [7 5 9 1 6 3]
    // Iterasjon 1: [1 5 9 7 6 3]
    // Iterasjon 2: [1 3 9 7 6 5]
    // Iterasjon 3: [1 3 5 7 6 9]
    // Iterasjon 4: [1 3 5 6 7 9]

// ii) Vis at antall sammenligninger blir n(n-1)/2, der n er antall elementer som skal sorteres.
    // Svar:
        // I den ytre løkken har vi (n-1) sammenligninger og får en mindre sammenligninger i ytre rekken ved å
        //  flytte det minste tallet fra den usorterte delene til den sorterte delen i den indre løkke.
        // På denne måten får vi: (n-1)+(n-2)+(n-3)+...+1 som gir den aritmiske rekken: (n/2)*(1+n-1)
        //  denne kan fornekles slik: n(n-1)/2
        

// b) Sortering ved insetting

// i) Bygger en sortert del av listen et element av gangen. Sammenligner elementene i den usorterte delen med de i den sorterte delen
//     og plasserer det på den riktige plassen i den sorterte delen. 
//     Dette gjentas til hele listen er sortert og har en gj.snittlig tidskompleksitet på O(n^2).

//ii) Sortering Ved Innsetting av [7 5 9 1 6 3]
    // Iterasjon 1: [5 7 9 1 6 3]
    // Iterasjon 1: [5 7 9 1 6 3]
    // Iterasjon 1: [1 5 7 9 6 3]
    // Iterasjon 1: [1 5 6 7 9 3]
    // Iterasjon 1: [1 3 5 6 7 9]

// c)
// i) Forklar hva den hjelpemetoden...







