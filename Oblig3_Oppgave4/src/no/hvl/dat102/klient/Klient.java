package no.hvl.dat102.klient;

import no.hvl.dat102.sortering.BobleSortering;
import no.hvl.dat102.sortering.FletteSortering;
import no.hvl.dat102.sortering.InnsettingsSortering;
import no.hvl.dat102.sortering.QuickSort;
import no.hvl.dat102.sortering.RadixSortering;
import no.hvl.dat102.sortering.UtvalgsSortering;

import java.util.Random;

public class Klient {

	public static void main(String[] args) {
		Random rand = new Random();
		// TODO Auto-generated method stub
		Integer[] randomTabRadix=TilfeldigTabell(20);
		Integer[] randomTabBoble=TilfeldigTabell(20);
		Integer[] randomTabFlette=TilfeldigTabell(20);
		Integer[] randomTabInsetting=TilfeldigTabell(20);
		Integer[] randomTabQuick=TilfeldigTabell(20);
		Integer[] randomTabUtvalg=TilfeldigTabell(20);
		
		BobleSortering.bobleSort(randomTabBoble);
		FletteSortering.fletteSort(randomTabFlette, 0,randomTabFlette.length-1);
		InnsettingsSortering.sorteringVedInsetting(randomTabInsetting);
		QuickSort.kvikkSort(randomTabQuick);
		UtvalgsSortering.utvalgsSortering(randomTabUtvalg);
		
		System.out.println("Radix: ");
		RadixSortering.Radix(randomTabRadix);
		System.out.println("Flettet: ");
		PrintListeLinje(randomTabFlette);
		System.out.println("Inetting");
		PrintListeLinje(randomTabInsetting);
		System.out.println("Quick");
		PrintListeLinje(randomTabQuick);
		System.out.println("Utvalg");
		PrintListeLinje(randomTabUtvalg);
		
		
		
		
	}

	private static Integer[] TilfeldigTabell(int antall) {
		Random rand = new Random();
		Integer[] randomTab = new Integer[antall];
		for (int i = 0; i < antall; i++) {
			randomTab[i] = rand.nextInt(9000) + 1000;
		}
		return randomTab;
	}
	
	private static void PrintListeLinje(Integer[] liste) {
		for (int i = 0; i < liste.length; i++) {
			System.out.print(liste[i]+", ");
		}
			System.out.println();
	}

}
