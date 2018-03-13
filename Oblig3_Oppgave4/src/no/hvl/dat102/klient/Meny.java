package no.hvl.dat102.klient;

import java.util.ArrayList;
import java.util.Scanner;

import no.hvl.dat102.TabellTing;

public class Meny {

	Integer[] tab1 = TabellTing.tilfeldigTabell(20);
	Integer[] tab2 = TabellTing.tilfeldigTabell(20);
	Integer[] tab3 = TabellTing.tilfeldigTabell(20);
	Integer[] tab4 = TabellTing.tilfeldigTabell(20);
	Integer[] tab5 = TabellTing.tilfeldigTabell(20);
	Integer[] tab6 = TabellTing.tilfeldigTabellFireSifre(20);

	/*
	 * private final int INNSETTING = 1; private final int UTVALG = 2; private final
	 * int BOBLE = 3; private final int QS = 4; private final int FLETTE = 5;
	 * private final int RADIX = 6;
	 */

	public void start() {

		int valg1 = -1;
		int valg2 = -1;
		int valg3 = -1;

		int storrelse = 0;
		long bruktTid = 0;
		Scanner inn = new Scanner(System.in);

		System.out.println("1. Sorter tabell med Sortering ved innsetting");
		System.out.println("2. Sorter tabell med Sortering ved utvalg");
		System.out.println("3. Sorter tabell med boblesortering");
		System.out.println("4. Sorter tabell med quicksort");
		System.out.println("5. Sorter tabell med flettesortering");
		System.out.println("6. Sorter tabell med radix-sortering");

		valg1 = inn.nextInt();
		inn.nextLine();

		if (valg1 != 0) {
			System.out.println("1. Tabell med 32000");
			System.out.println("2. Tabell med 64000");
			System.out.println("3. Tabell med 128000");
			valg2 = inn.nextInt();
			inn.nextLine();

			switch (valg2) {
			case 1:
				storrelse = 32000;
				break;
			case 2:
				storrelse = 64000;
				break;
			case 3:
				storrelse = 128000;
				break;
			default:
				
			}

			if (valg2 != 0) {
				System.out.println("Hvor mange ganger?");
				valg3 = inn.nextInt();
				inn.nextLine();
			}
		}

		
		SorteringsValg sValg = SorteringsValg.finnValg(valg1);

		ArrayList<Long> resultatListe = new ArrayList<Long>();

		int i = 0;
		while (i < valg3) {
			tab1 = TabellTing.tilfeldigTabellSamme(storrelse);
			switch (sValg) {
			case INNSETTING:
				bruktTid = SorteringsResultat.testSortering(sValg, tab1);
				break;
			case UTVALG:
				bruktTid = SorteringsResultat.testSortering(sValg, tab1);
				break;
			case BOBLE:
				bruktTid = SorteringsResultat.testSortering(sValg, tab1);
				break;
			case QS:
				bruktTid = SorteringsResultat.testSortering(sValg, tab1);
				break;
			case FLETTE:
				bruktTid = SorteringsResultat.testSortering(sValg, tab1);
				break;
			case RADIX:
				tab6 = TabellTing.tilfeldigTabellFireSifreSamme(storrelse);
				bruktTid = SorteringsResultat.testSortering(sValg, tab6);
				break;

			}
			i++;
			resultatListe.add(bruktTid);
		}

		if(valg3 <= 1) {
			SorteringsResultat.skrivResultat(sValg, bruktTid, storrelse);
		} else {
			SorteringsResultat.skrivTotalResultat(sValg, storrelse, resultatListe);
		}
		

		inn.close();
	}

}
