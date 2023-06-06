public class ShellSort {

    // Modifisert InsertionSort (tre parametere)
    private static <T extends Comparable<? super T>> void sorteringVedInnsetting(T[] a, int n,
            int h) {

        for (int i = h; i < n; i++) {
            T tmp = a[i];
            int j;
            for (j = i; j >= h && tmp.compareTo(a[j - h]) < 0; j -= h) {
                a[j] = a[j - h];
            }
            a[j] = tmp;
        }
    }

    // SHELLSORT
    public static <T extends Comparable<? super T>> void shellSort(T[] a) {
        int h = 1;
        int n = a.length;

        // Velger verdi for h som gir størst verdi mindre enn n/3
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        // Sorterer med forskjellige h-verdier
        while (h >= 1) {
            sorteringVedInnsetting(a, n, h);
            h /= 3;
        }
    }
}