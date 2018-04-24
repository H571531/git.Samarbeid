package no.hvl.dat102;

import java.util.*;

public class KlientB {
	
	public static void main(String[] args) {
		int n=100;
		int storrelse=1024;
		int storrelseto=4096;
		int minsteHoyde=-2;
		int storsteHoyde=-2;
		double gjHoyde=0;
		double c=0;
		int TeoretiskMaksHoyde=storrelse-1;
		double TeoretiskMinHoyde=teoretiskMinsteHoyde(storrelse);
		KjedetBinaerSokeTre<Integer> TestTre;
		
		for(int i=0; i<n; i++) {
			TestTre=tilfeldigTre(storrelse);
			
			//int TeoretiskMaksHoyde=storrelse-1;
			//double TeoretiskMinHoyde=teoretiskMinsteHoyde(storrelse);
			minsteHoyde=minste(TestTre.TreHoyde(),minsteHoyde);
			storsteHoyde=storste(TestTre.TreHoyde(),storsteHoyde);
			gjHoyde=gjHoyde+TestTre.TreHoyde();
			
			//System.out.println("Antall noder: "+storrelse);
			//System.out.println("Teoretisk Min h�yde: "+TeoretiskMinHoyde);
			//System.out.println("Teoretisk Maks h�yde: "+TeoretiskMaksHoyde);
			//System.out.println("H�yden er: "+TestTre.TreHoyde());
			//System.out.println("---------------------------------------");
		}
		System.out.println("---------------------------------------");
		System.out.println("For alle tr�r i m�lingen: ");
		System.out.println("Antall noder: "+storrelse);
		System.out.println("Teoretisk Min h�yde: "+TeoretiskMinHoyde);
		System.out.println("Teoretisk Maks h�yde: "+TeoretiskMaksHoyde);
		System.out.println("---------------------------------------");
		System.out.println("Antall tr�r: "+n);
		System.out.println("Antall noder i tr�rne: "+storrelse);
		System.out.println("Minste funnet h�yde: "+minsteHoyde);
		System.out.println("Storste funnet h�yde: "+storsteHoyde);
		System.out.println("Gjennomsnitt h�yde for "+n+" antall(hoydetot/antall): "+(gjHoyde/n));
		c=(gjHoyde/n)/((Math.log(storrelse)/Math.log(2)));
		System.out.println("---------------------------------------");
		System.out.println("Oppgave C\nFor alle tr�r i m�lingen med n=4096:  ");
		System.out.println("Antall noder: "+storrelseto);
		System.out.println("Teoretisk Min h�yde: "+teoretiskMinsteHoyde(4096));
		System.out.println("Teoretisk Maks h�yde: "+(storrelseto-1));
		System.out.println("--------------------------------------- ");
		System.out.println("C=h/log_2 n =" + c);
		System.out.println("Antatt gjennomsnitt for "+storrelseto+" elementer vil da v�re: "+(c*(Math.log(storrelseto)/Math.log(2))));
		gjHoyde=0;
		for(int i=0; i<n; i++) {
			TestTre=tilfeldigTre(storrelseto);
			
			minsteHoyde=minste(TestTre.TreHoyde(),minsteHoyde);
			storsteHoyde=storste(TestTre.TreHoyde(),storsteHoyde);
			gjHoyde=gjHoyde+TestTre.TreHoyde();
		
		}
		System.out.println("Gjennomsnitt h�yde for "+storrelseto+" antall elementer i "+n+" tr�r er m�lt til: "+(gjHoyde/n));
	}

	
	

	private static  KjedetBinaerSokeTre<Integer> tilfeldigTre(int storrelse) {
		Random random = new Random();
		BSTreADT<Integer> utTre = new KjedetBinaerSokeTre<Integer>();
		for(int i = 0; i < storrelse; i++) {
			utTre.leggTil(random.nextInt());
		}
		return  (KjedetBinaerSokeTre<Integer>) utTre;
	}
	private static int teoretiskMinsteHoyde(int n) {
		return (int) (Math.log(n)/Math.log(2));
	}
	private static int minste(int h, int minsteHoyde) {
		if(minsteHoyde==-2) {
			minsteHoyde=h;
			return minsteHoyde;
		}else {
			if(h<=minsteHoyde) {

					return h;
			}else {
				return minsteHoyde;
			}
		}
	}
	private static int storste(int h, int storsteHoyde) {
		if(storsteHoyde==-2) {
			storsteHoyde=h;
			return storsteHoyde;
		}else {
			if(h>=storsteHoyde) {

					return h;
			}else {
				return storsteHoyde;
			}
		}
	}
}