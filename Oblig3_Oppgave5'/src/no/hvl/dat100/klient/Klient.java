package no.hvl.dat100.klient;

import no.hvl.dat100.sorteringog.*;
import java.util.Random;


public class Klient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] innsetting=lagtilfeldig(20);
		Integer[] binerinnsetting=lagtilfeldig(20);
		
		long tid1 = System.nanoTime();
			Sortering.sorteringVedInnsetting(innsetting);
		tid1=System.nanoTime()-tid1;
		
		
		long tid2 = System.nanoTime();
			Sortering.BinaryInsertionSort(binerinnsetting);
		tid2=System.nanoTime()-tid2;
		
		
		System.out.print("Vanlig sortering ved insetting: \nSortert: ");
			printTabell(innsetting);
		System.out.print("Brukte: "+tid1/1000+"uS\n");
		
		System.out.print("Sortering ved insetting med binærsøk: \nSortert: ");
			printTabell(binerinnsetting);
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
