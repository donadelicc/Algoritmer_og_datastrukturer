public class QuickSort {

    // HJELPEMETODER

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void order(int[] a, int i, int j) {
        if (a[i] < (a[j]))
            swap(a, i, j);
    }

    private static void sortFirstMiddleLast(int[] a, int first, int mid, int last) {
        order(a, first, mid); // Make a[first] <= a[mid]
        order(a, mid, last); // Make a[mid] <= a[last]
        order(a, first, mid); // Make a[first] <= a[mid]
    }

    public static void sorteringVedInnsetting(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    private static int partition(int[] a, int forste, int siste) {
        int midten = (forste + siste) / 2;

        // Ordnar f�rste, midterse og siste element slik at dei st�r rett i forhold til
        // kvarandre
        sortFirstMiddleLast(a, forste, midten, siste);

        // Flyttar pivot til nest siste plass
        swap(a, midten, siste - 1);
        int pivotIndex = siste - 1;
        int pivotValue = a[pivotIndex];

        // Finn f�rste i venstre del som er mindre st�rre enn pivot
        // siste i h�gre del som er mindre enn pivot

        int fraVenstre = forste;
        int fraHogre = siste - 1;

        boolean ferdig = false;
        while (!ferdig) {

            while (a[fraVenstre] < pivotValue) {
                fraVenstre++;
            }

            while (fraHogre > 0 && a[fraHogre] > pivotValue) {
                fraHogre--;
            }

            if (fraVenstre < fraHogre) {
                swap(a, fraVenstre, fraHogre);
                fraVenstre++;
                fraHogre--;
            } else
                ferdig = true;
        }

        // Place pivotValue between the subarrays Smaller and Larger
        swap(a, pivotIndex, fraVenstre);
        pivotIndex = fraVenstre;

        return pivotIndex;
    }

    // KVIKKSORTERING MED ANNEN PARAMETERLISTE
    public static void quickSort(int[] array, int n) {
        kvikksorter(array, 0, n - 1);

        sorteringVedInnsetting(array);
    }

    // KVIKKSORTERING
    public static void kvikksorter(int[] a, int forste, int siste) {

        if (forste < siste) { // mer enn to elementer
            int pivot = partition(a, forste, siste); // Finner pivot med partition()-metoden
            kvikksorter(a, forste, pivot - 1); // Sorterer venstre del til jeg ikke kan dele opp mer
            kvikksorter(a, pivot + 1, siste); // Sorterer høyre del til jeg ikke kan dele opp mer
        }
    }

}
