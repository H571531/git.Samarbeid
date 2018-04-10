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
		
		KjedetBinaerSokeTre<Integer> TestTre;
		
		for(int i=0; i<n; i++) {
			TestTre=tilfeldigTre(storrelse);
			
			int TeoretiskMaksHoyde=storrelse-1;
			double TeoretiskMinHoyde=teoretiskMinsteHoyde(storrelse);
			minsteHoyde=minste(TestTre.TreHoyde(),minsteHoyde);
			storsteHoyde=storste(TestTre.TreHoyde(),storsteHoyde);
			gjHoyde=gjHoyde+TestTre.TreHoyde();
			
			System.out.println("Antall noder: "+storrelse);
			System.out.println("Teoretisk Min høyde: "+TeoretiskMinHoyde);
			System.out.println("Teoretisk Maks høyde: "+TeoretiskMaksHoyde);
			System.out.println("Høyden er: "+TestTre.TreHoyde());
			System.out.println("---------------------------------------");
		}
		
		System.out.println("Antall trær: "+n);
		System.out.println("Antall noder i trærne: "+storrelse);
		System.out.println("Minste høyde: "+minsteHoyde);
		System.out.println("Storste høyde: "+storsteHoyde);
		System.out.println("Gjennomsnitt høyde for "+n+"antall(hoydetot/antall): "+(gjHoyde/n));
		c=(gjHoyde/n)/((Math.log(storrelse)/Math.log(2)));
		System.out.println("---------------------------------------\nOppgave C: ");
		System.out.println("C=h/log_2 n =" + c);
		System.out.println("Antatt gjennomsnitt for "+storrelseto+" elementer vil da være: "+(c*(Math.log(storrelseto)/Math.log(2))));
		gjHoyde=0;
		for(int i=0; i<n; i++) {
			TestTre=tilfeldigTre(storrelseto);
			
			minsteHoyde=minste(TestTre.TreHoyde(),minsteHoyde);
			storsteHoyde=storste(TestTre.TreHoyde(),storsteHoyde);
			gjHoyde=gjHoyde+TestTre.TreHoyde();
		
		}
		System.out.println("Gjennomsnitt høyde for "+storrelseto+" antall elementer i "+n+" trær er målt til: "+(gjHoyde/n));
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