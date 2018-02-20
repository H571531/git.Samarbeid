package no.hvl.dat102.mengde.klient;

import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Ordliste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MengdeADT<String> ordListe1 = new KjedetMengde<String>();
		//MengdeADT<String> ordListe1 = new TabellMengde<String>();

		String[] ord = { "God", "dag", "Hans", "Hansen", "Hansaby", "Olsen", "Ole", "buss", "rute", "Bergen" };

		Scanner tastatur = new Scanner(System.in);
		// Legger til ordene i mengden ordListe1

		for (int i = 0; i < ord.length; i++) {
			ordListe1.leggTil(ord[i]);
		}
		MengdeADT<String> ordListe2 = new KjedetMengde<String>();
		//MengdeADT<String> ordListe2 = new TabellMengde<String>();

		System.out.print("Oppgi en streng, avslutt med zzz :");
		String streng = tastatur.nextLine();
		// Leser inn ord
		while (!streng.equals("zzz")) {

			if (ordListe1.inneholder(streng)) {
				System.out.println("ordListe1 inneholder " + streng);
			} else {
				System.out.println("ordListe1 inneholder ikke " + streng);

			}
			// Legger innleste ord inn i ordliste2
			ordListe2.leggTil(streng);
			System.out.print("Oppgi en streng, avslutt med zzz :");
			streng = tastatur.nextLine();

		} // while
		tastatur.close();

		// Lager unionen av de to ordlistene
		MengdeADT<String> ordListeBegge = new KjedetMengde<String>();

		ordListeBegge = ordListe1.union(ordListe2);

		System.out.println("Utskrift av unionen av begge ordlistene");
		String hentStreng = "";
		while (!ordListeBegge.erTom()) {
			hentStreng = ordListeBegge.fjernTilfeldig();
			System.out.println(hentStreng);

		}

		// Lager snittet av de to ordlistene
		MengdeADT<String> ordListeFelles = new KjedetMengde<String>();

		ordListeFelles = ordListe1.snitt(ordListe2);

		System.out.println("Utskrift av snittet av begge ordlistene");
		hentStreng = "";
		while (!ordListeFelles.erTom()) {
			hentStreng = ordListeFelles.fjernTilfeldig();
			System.out.println(hentStreng);

		}

		// Lager differansen av de to ordlistene
		MengdeADT<String> ordListeDiff = new KjedetMengde<String>();

		ordListeDiff = ordListe1.differens(ordListe2);

		System.out.println("Utskrift av differensen av begge ordlistene");
		hentStreng = "";
		while (!ordListeDiff.erTom()) {
			hentStreng = ordListeDiff.fjernTilfeldig();
			System.out.println(hentStreng);

		}

		
		//Delmengde
		System.out.println("M2 delmengde av m1: " + ordListe1.undermengde(ordListe2));
	}

}