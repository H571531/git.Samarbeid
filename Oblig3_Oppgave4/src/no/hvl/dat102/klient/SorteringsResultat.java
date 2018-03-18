package no.hvl.dat102.klient;

import java.util.ArrayList;

import no.hvl.dat102.Sortering;

public class SorteringsResultat {
	
	static SorteringsValg sValg;
	
	public static long testSortering(SorteringsValg type, Integer[] tabell) {
		
		long tid1 = 0;
		switch(type) {
			case INNSETTING:
				tid1 = System.nanoTime();
				Sortering.sorteringVedInnsetting(tabell);
				return System.nanoTime() - tid1;
			case UTVALG:
				tid1 = System.nanoTime();
				Sortering.sorteringVedUtvalg(tabell);
				return System.nanoTime() - tid1;
			case BOBLE:
				tid1 = System.nanoTime();
				Sortering.sorteringVedUtvalg(tabell);
				return System.nanoTime() - tid1;
			case QS:
				tid1 = System.nanoTime();
				Sortering.kvikkSortering(tabell);
				return System.nanoTime() - tid1;
			case FLETTE:
				tid1 = System.nanoTime();
				Sortering.fletteSortering(tabell);
				return System.nanoTime() - tid1;
			case RADIX:
				tid1 = System.nanoTime();
				Sortering.radixSortering(tabell);
				return System.nanoTime() -tid1;
			case QS2:
				tid1 = System.nanoTime();
				Sortering.kvikkSortering2(tabell);
				return System.nanoTime() - tid1;
			case INNSETTING3:
				tid1 = System.nanoTime();
				Sortering.SorteringVedInnsetting3(tabell);
				return System.nanoTime() - tid1;
			
				default: return 0;
				
				
			
		}
		
	}
	
	public static void skrivResultat(SorteringsValg type, long tid, int tabStorrelse) {
		
		System.out.println("Testet " + type.toString());
		System.out.println("Tabellstørrelse: " + tabStorrelse);
		System.out.println("Tid: " + tid);
		
	}
	
	public static void skrivTotalResultat(SorteringsValg type, int tabStorrelse, ArrayList<Long> tidsResultat) {
		long totalt = 0;
		
		System.out.println("Testet " + type.toString());
		System.out.println("Tabellstørrelse: " + tabStorrelse);
		System.out.println("Antall tester: " + tidsResultat.size());
		System.out.print("Tider:\t");
		for(long res : tidsResultat) {
			System.out.print(res + " ns = " + res/1000000 + " ms\t");
			totalt += res;
		}
		long gjSnittstid = totalt/tidsResultat.size();
		System.out.println("\nTotal tid: " + totalt + " ns = " + totalt/1000000 + " ms");
		System.out.println("Gjennomsnitt: " + gjSnittstid + " ns = " + gjSnittstid/1000000 + " ms");
		if(type == SorteringsValg.QS || type == SorteringsValg.FLETTE || type == SorteringsValg.QS2) {
			System.out.println("C: tid / (n log2n): " + (gjSnittstid / (tabStorrelse * (Math.log(tabStorrelse) / (Math.log(2))))));
		} else if (type == SorteringsValg.BOBLE || type == SorteringsValg.INNSETTING || type == SorteringsValg.UTVALG){
			System.out.println("C: tid / n^2 :" + (gjSnittstid / Math.pow(tabStorrelse, 2)));
		} else {
			//radix
			System.out.println("C: tid / n: " + (gjSnittstid / tabStorrelse));
		}
		
		
		
		
	}

}
