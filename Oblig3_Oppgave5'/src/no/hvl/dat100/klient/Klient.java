package no.hvl.dat100.klient;

import java.util.Random;

import no.hvl.dat100.sorteringog.Sortering;


public class Klient {

	public static void main(String[] args) {
		int elementer=9000;
		//if(!args.equals(null))elementer=Integer.parseInt(args[0]);
		// TODO Auto-generated method stub
		
		
		Integer[] innsetting=lagtilfeldig(elementer);
		Integer[] binerinnsetting=innsetting;
		
		
		
		long tid1 = System.nanoTime();
			Sortering.sorteringVedInnsetting(innsetting);
		tid1=System.nanoTime()-tid1;
		
		
		long tid2 = System.nanoTime();
			Sortering.BinaryInsertionSort(binerinnsetting);
		tid2=System.nanoTime()-tid2;
		
		
		
		/*
		long tid1 = System.nanoTime();
		Sortering.BinaryInsertionSort(innsetting);
		tid1=System.nanoTime()-tid1;
	
		
		long tid2 = System.nanoTime();
			Sortering.sorteringVedInnsetting(binerinnsetting);
		tid2=System.nanoTime()-tid2;
		*/
		
		
		
		System.out.println("Sorterer "+elementer+" elementer.");
		System.out.print("Vanlig sortering ved insetting: \nSortert: ");
			//printTabell(innsetting);
		System.out.print("Brukte: "+tid1/1000+"uS\n");
		
		System.out.print("Sortering ved insetting med binærsøk: \nSortert: ");
			//printTabell(binerinnsetting);
		System.out.print("Brukte: "+tid2/1000+"uS\n");
		
	}

	private static Integer[] lagtilfeldig(int n) {
		Integer[] tabell=new Integer[n];
		Random rand = new Random();
		
		for(int i=0; i<n; i++) {
			tabell[i]= rand.nextInt(8999) + 1000;
		}
		return tabell;	
	}
	
	private static void printTabell(Integer[] tabell) {
		for(int i=0; i<tabell.length; i++) {
			System.out.print(tabell[i]+" ");
		}
		System.out.println();
	}
	
	
}
