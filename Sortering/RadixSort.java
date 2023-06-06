import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {

    private static final int RADIX = 10;

    public static void radixSortering(Integer[] data) {
        int n = data.length;
        int maks = finnStorste(data);
        int maksAntallSiffer = lengde(maks);

        // Bruker Java sitt Queue objekt og legger sifferene inn der
        Queue<Integer>[] sifferkøer = new Queue[RADIX];
        for (int i = 0; i < sifferkøer.length; i++) {
            sifferkøer[i] = new LinkedList<>();
        }

        // Legger inn sifferene inn i riktig kø.
        // Sorterer flrst på enerplassen, så tierplassen osv..
        for (int i = 0; i < maksAntallSiffer; i++) {
            for (int j = 0; j < n; j++) {
                int siffer = finnSiffer(data[j], i);
                sifferkøer[siffer].add(data[j]);
            }
            // Går igjennom hver kø og tar ut elementene i den rekkefølgen de ble lagt inn
            // og legger dem tilbake i arrayet i sortert rekkefølge
            int index = 0;
            for (Queue<Integer> sifferkø : sifferkøer) {
                while (!sifferkø.isEmpty()) {
                    data[index] = sifferkø.remove();
                    index++;
                }
            }
        }
    }

    private static int finnStorste(Integer[] data) {
        int maks = data[0];

        for (int i = 1; i < data.length; i++) {
            if (data[i] > maks) {
                maks = data[i];
            }
        }
        return maks;
    }

    private static int finnSiffer(int tall, int sifferPosisjon) {
        int vekt = (int) Math.pow(RADIX, sifferPosisjon);
        return (tall / vekt) % RADIX;
    }

    private static int lengde(int tall) {
        int len = String.valueOf(tall).length();
        return len;
    }
}
