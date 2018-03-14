package no.hvl.dat102.sortering;

public class InnsettingsSortering {
	public static <T extends Comparable<? super T>>void sorteringVedInsetting(T[] data) {
		for (int indeks = 1; indeks < data.length; indeks++) {
			T nokkel = data[indeks];
			int p = indeks;
	// Forskyv større verdier mot høyre
			while (p > 0 && data[p-1].compareTo(nokkel) > 0){
				data[p] = data[p-1];
				p--;
			}
			data[p] = nokkel;
		}//ytre
	}//metode
}
