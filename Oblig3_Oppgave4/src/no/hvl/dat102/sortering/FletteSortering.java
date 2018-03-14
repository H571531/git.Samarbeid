package no.hvl.dat102.sortering;

public class FletteSortering {

	/*
	 * Sorterer en del av tabell[f�rste,siste]. Litt annerledes enn i bok
	 */
	public static <T extends Comparable<T>> void fletteSort(T[] tabell, int forste, int siste) {
		if (forste < siste) {// minst to elementer
			int midten = (forste + siste) / 2;
			// Sorter venstre halvdel tabell[f�rste,midten];
			fletteSort(tabell, forste, midten);
			// Sorter h�yre halvdel tabell[midten+1,siste]
			fletteSort(tabell, midten + 1, siste);
			// Fletter de to halvdelene
			flette(tabell, forste, midten, siste);
		} // if
	}// fletteSort

	private static <T extends Comparable<T>> void flette(T[] tabell, int forste, int midten, int siste) {
		/*
		 * Fletter to sorterte deltabeller, tabell[f�rste,midten] og
		 * tabell[midten+1,siste] til en sortert tabell Forkrav: f�rste <= midten <=
		 * siste Deltabellene tabell[f�rste,midten] og tabell[midten+1,siste] er hver
		 * sorterte i �kende rekkef�lge. ResultatIabell[f�rste,siste] er sortert.
		 * Implementasjon : Denne metoden fletter to deltabeller til en hjelpetabell og
		 * kopierer resultatet til den originale tabellen.
		 */
		int stor = siste - forste + 1;
		T[] hjelpeTabell = (T[]) (new Comparable[stor]);
		// Initierer lokale indekser
		// start og slutt p� venstre deltabell
		int forste1 = forste;
		int siste1 = midten;
		// start og slutt p� h�yre deltabell
		int forste2 = midten + 1;
		int siste2 = siste;
		/*
		 * S� lenge begge deltabellene ikke er tomme, kopier det minste elementet til
		 * hjelpetabellen.
		 */
		int indeks = 0;
		
		while ((forste1 <= siste1) && (forste2 <= siste2)) {
			if (tabell[forste1].compareTo(tabell[forste2]) <= 0) {
				hjelpeTabell[indeks] = tabell[forste1];
				forste1++;
			} else {
				hjelpeTabell[indeks] = tabell[forste2];
				forste2++;
			}
			indeks++;
		} // while
			// kopiere resten av venstre del (kan v�re tom)
		while (forste1 <= siste1) {
			hjelpeTabell[indeks] = tabell[forste1];
			forste1++;
			indeks++;
		} // while
			// kopiere resten av h�yre del (kan v�re tom)
		while (forste2 <= siste2) {
			hjelpeTabell[indeks] = tabell[forste2];
			forste2++;
			indeks++;
		} // while
			// Kopier resultatet tilbake til den originale tabellen
		int h = 0;
		for (indeks = forste; indeks <= siste; indeks++) {
			tabell[indeks] = hjelpeTabell[h++];
		}
	}// flette */

}
