package no.hvl.dat102.sortering;

public class InnsettingsSortering {
	public static <T extends Comparable<? super T>>void sorteringVedInsetting(T[] data) {
		for (int indeks = 1; indeks < data.length; indeks++) {
			T n�kkel = data[indeks];
			int p = indeks;
	// Forskyv st�rre verdier mot h�yre
			while (p > 0 && data[p-1].compareTo(n�kkel) > 0){
				data[p] = data[p-1];
				p--;
			}
			data[p] = n�kkel;
		}//ytre
	}//metode
}
