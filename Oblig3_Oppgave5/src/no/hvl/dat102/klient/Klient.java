package no.hvl.dat102.klient;

import java.util.Random;
import no.hvl.dat102.sortering.*;

public class Klient {

	public static void main(String[] args) {
		Integer[] randomTabVinsetting=TilfeldigTabell(20);
		
		//Test uten binaer endring
		long tid1=System.nanoTime();
			InnsettingsSortering.sorteringVedInsetting(randomTabVinsetting);
		tid1=System.nanoTime()-tid1;
		
		//Test med binaer endring
		long tid2=System.nanoTime();
			
		tid2=System.nanoTime()-tid2;
		
		
		System.out.println("Sortering ved innsetting uten binaersok\n tid: "+ tid1/1000 +"uS");
		System.out.println("Sortering ved innsetting med binaersok\n tid: "+tid2/1000+"uS");
		
		
		if(tid1<tid2) {
			System.out.println("Uten binaersok var kjappere med: "+(tid2-tid1)+"nS");
		}else if(tid2<tid1) {
			System.out.println("Med binaersok var kjappere med: "+ (tid1 - tid2) +"nS");
		}
	}
	
	//QOL - Hjelpemetoder:
	
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
