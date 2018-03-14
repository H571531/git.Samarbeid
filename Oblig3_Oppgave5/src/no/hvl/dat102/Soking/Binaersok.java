package no.hvl.dat102.Soking;

public class Binaersok {

	public static <T extends Comparable<T>> boolean binaerSoek(T[] data, int min, int maks, T el) {
		if (min > maks) { // basistilfelle, ingen element
			return false;
		}
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);
		if (resultat == 0) { // basistilfelle, finner elementet
			return true;
		}
		if (resultat < 0) {// (her vil også fungere med else if)
			return binaerSoek(data, min, midtpunkt - 1, el);
		} else { // resultat > 0
			return binaerSoek(data, midtpunkt + 1, maks, el);
		}
	}//
	public static <T extends Comparable<T>> void binaerSoek(T[] data,T el) {
		binaerSoek(data, 0, data.length-1, el);	
	}
	
}