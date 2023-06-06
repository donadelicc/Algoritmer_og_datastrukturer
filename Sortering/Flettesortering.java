public class Flettesortering {

    // Hjelpemetode FLETTE
    private static void flette(int[] a, int[] tempTab, int forste, int midten,
			int siste) {
		// Flettar saman to deler som ligg ved sida av kvaranre
		// forste, ..., midten og midten + 1, ..., siste
		int fV = forste;
		int sluttV = midten;
		int fH = midten + 1;
		int sluttH = siste;

		// S� lenge det er element att i begge delane, flytt over den minste til tempTab
		int index = fV; // Next available location in tempArray
		for (; (fV <= sluttV) && (fH <= sluttH); index++) {
			if (a[fV] < (a[fH])) {
				tempTab[index] = a[fV];
				fV++;
			} else {
				tempTab[index] = a[fH];
				fH++;
			}
		}

		// No vil ein av delane vere to. Kopierer over resten i den andr eedelen

		// Venstre del, kan vere tom
		for (; fV <= sluttV; fV++, index++) {
			tempTab[index] = a[fV];
		}

		// H�gre del, kan vere tom
		for (; fH <= sluttH; fH++, index++) {
			tempTab[index] = a[fH];
		}

		// Kopier den sorterte delen tilbake
		for (index = forste; index <= siste; index++) {
			a[index] = tempTab[index];
		}
	}

    // FLETTESORTERING
    private static void flettesortering(int[] a, int[] tempTab, int forste, int siste) {
        if (forste < siste) {
            int midten = (forste + siste) / 2;

            flettesortering(a, tempTab, forste, midten);
            flettesortering(a, tempTab, midten + 1, siste);
            flette(a, tempTab, forste, midten, siste);
        }
    }

    // FLETTESORTERING MED ANNEN PARAMETERLISTE
    public static void flettesortering(int[] a, int first, int last) {

        int[] tempArray = new int[a.length]; // unchecked cast
        flettesortering(a, tempArray, first, last);
    }

    // FLETTESORTERING MED ANNEN PARAMETERLISTE
    public static void flettesortering(int[] a, int n) {
        flettesortering(a, 0, n - 1);
    }

}
