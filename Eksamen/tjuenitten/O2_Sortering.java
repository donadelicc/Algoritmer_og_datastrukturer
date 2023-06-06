package Eksamen.tjuenitten;

public class O2_Sortering {

    // a) Forklar kort prinsippet for sorteringsmetodene sortering ved innsetting (insertion sort)
    //     og utvalgssortering (selection sort). 
    
    /*
    Svar:
    Sortering ved innsetting er en sorteringsalgoritme som deler elementene i en sortert og en usortert del
    ved å sammenligne hvert sortert element med det neste usorterte og flytter det usorterte elementet over i
    den sorterte delen på riktig plass dersom det er mindre enn noen av tallene i den sorterte delen.
    Dette gjøres for hvert element i listen til listen er sortert.

    Utvalgssortering deler også elementene i en sortert og en usortert del, men her så sammenligner den
    tall(ene) i den sorterte delene med det minste tallet i den usorterte delene og setter den på riktig
    plass i den sorterte delen. Dette gjøres for hvert element i listen til listen er sortert.
    */

    // b) Antall sammenligninger av Sortering ved insetting og utvalgssortering:
    /*
    Svar:
        Sortering ved insetting:.
            Beste tilfellet: O(n) --> Elementene er sortert og vi trenger bare en sammenligning for hvert element i "usortert" del.
            Verste tilfellet: O(n^2) --> Elemente er omvendt sortert og hvert element må flyttes til starten av usortert del. 
        Utvalgssortering:
            Beste og verste tilfellet: O(n*2) --> Rekkefølgen på elementene har ingen betydning for antall sammenligninger
            som følge av at algoritmen alltid må sammenligne hvert element med resten av elementene for å finne det minste
            elementet og plassere det på riktig sted.
    */

    //c) Kvikksortering 
    //i) Fyll ut kvikkSort metoden.

    public static <T extends Comparable<T>> void kvikkSort(T[] data) {
    kvikkSort(data, 0, data.length – 1);
    }
    private static <T extends Comparable<T>> void kvikkSort(T[] data, int min, int max) {
        int pivot = partition(data, min, max);
        kvikkSort(data, min, pivot-1);
        kvikkSort(data, pivot+1, max);
    }
    private static <T extends Comparable<T>> int partition(T[] data, int min, int max) {
    // metoden skal ikke lages
    }

    // ii) Forklar kort hva som blir resultatet av å utføre metoden partition.
    /*
     * Svar:
     *  Partition-metoden tar inn en liste og en startindeks og en sluttposisjon. 
     *  Hovedmålet er å velge en pivot (ofte det midterste elementet) og orginisere elementene i listen
     *  slik at alle elementene mindre en pivot elementet er på vinstre siden og alle elementene større
     *  er på høyre side.
     *  Partition-metoden bidrar til effektiviteten i kvikksorteringsalgoritmen ved å dele listen opp i mindre deler
     *  og sortere den delvis. Dette gjør at kvikksortering kan utføres rekursivt på hver del.  
     */

    // Vi bruker tabellen under som parameter når vi kaller partition. Vis innholdet i
    // tabellen etter kallet er utført. Metoden bruker første element (25) som pivot element.
    // [25, 40, 10, 45, 30, 15, 20]

    // Svar:
    //  Etter partition metoden blir kalt på denne listen kan vi få:
    // [15, 20, 10, 25, 30, 45, 40]

    //d) Testklasse
    /*
     * public class SorteringTest {
        private static final int SIZE = 100;
        private Integer[] testdata = new Integer[SIZE];
        @BeforeEach //Det samme som @Before i JUnit4
        public final void setup() {
            Random rInt = new Random();
            for (int i = 0; i < testdata.length; i++) {
            testdata [i] = new Integer(rInt.nextInt());
            }
        }
        @Test
        public final void testKvikkSort() {
            //… fyll ut
        }
        private <T extends Comparable<T>> boolean verifiser(T[] data) {
            //… fyll ut
        }
    }
     */
    // i) Fyll inn metoden testKvikkSort. Denne metoden skal først kalle på kvikkSort og
    //     deretter på metoden verifiser. Til slutt skal testKvikkSort kalle på assertTrue-metoden.

        @Test
        public final void testKvikkSort() {
            Sortering.kvikkSort(testdata);
            boolean ok = verifiser(testdata);
            assertTrue(ok);
            
        }

    // ii) Forklar @BeforeEach og @Test annotasjonenen
    // @BeforeEach betyr at metoden vil kjøre for hver testmetode i den samme klassen
    // @Test idikerer at metoden er en testmetode.

    // iii)  Lag metoden verifiser som avgjør om en tabell er ordnet ikke-avtagende.
    //        Det vil si testdata[0] ≤ testdata[1] … ≤ testdata[n-1] når n er antall elementer.

        private <T extends Comparable<T>> boolean verifiser(T[] data) {
            boolean sortert = true;
            for(int i=0; i<data.length -1 && sortert; i++) {
                sortert = data[i].compareTo(data[i+1]) <= 0 ;
            }
            return sortert;
        }

        // e) Sorter tabllen: [13, 31, 01, 54, 40, 21, 12, 53] med Radix sort

        /*
         * Køer med siffer til høre: 0, 1, 2, 3, 4
         * 0: 40; 1: 31, 01, 21; 2: 12; 3: 53, 4: 54 --> Liste: 40, 31, 01, 21, 12, 53, 54
         * Køer med siffer til venstre: 0, 1, 2, 3, 4, 5
         * 0: 01; 1: 12, 13; 2: 21; 3: 31; 4: 40, 5: 54, 53 --> Liste: 01, 12, 13, 21, 31, 40, 53, 54
         * Liste sortert: 01, 12, 13, 21, 31, 40, 53, 54
         */
    }
