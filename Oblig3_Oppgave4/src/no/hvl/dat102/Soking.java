package no.hvl.dat102;

public class Soking {

	public static <T extends Comparable<? super T>> int binaerSoek3(T[] tabell, T el) {
		return binaerSoek3(tabell, 0, tabell.length - 1, el);
	}

	public static <T extends Comparable<? super T>> int binaerSoek3(T[] tabell, int min, int maks, T el) {

		if (min > maks) {
			return -1;
		}

		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(tabell[midtpunkt]);

		if (resultat == 0) {
			return midtpunkt;
		} else if (resultat < 0) {
			return binaerSoek3(tabell, min, midtpunkt - 1, el);
		} else {
			return binaerSoek3(tabell, midtpunkt + 1, maks, el);
		}

	}

	//Oppgave 5 - Binærsøk til sortering ved innsetting 3, som returnerer plass i tabellen som inneholder element <= T, i stedet for -1 når T ikke finnes i sortert del
	public static <T extends Comparable<? super T>> int binaerSoek5(T[] tabell, int min, int maks, T el) {
		
		if (min > maks) {
			//I stedet for å returnere -1 ved ikke funnet element, returneres indeks for siste element i den sorterte delen som er mindre enn eller lik søke-elementet
			return min;
		}
		
		int midtpunkt = (min + maks) / 2;
		
		int resultat = el.compareTo(tabell[midtpunkt]);

		 if (resultat < 0) {
			return binaerSoek5(tabell, min, midtpunkt-1, el);
		} else if(resultat > 0){
			return binaerSoek5(tabell, midtpunkt + 1, maks, el);
		} else {
			return midtpunkt;
		}
		 
	}
	
	

}
