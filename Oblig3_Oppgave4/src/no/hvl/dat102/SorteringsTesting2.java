package no.hvl.dat102;

import java.util.Arrays;

public class SorteringsTesting2 {

	public static void main(String[] args) {
		
		Integer[] tab1 = TabellTing.tilfeldigTabellSamme(20);
		Integer[] tab2 = TabellTing.tilfeldigTabellSamme(20);
		Integer[] tab3 = TabellTing.tilfeldigTabellSamme(20);
		Integer[] tab4 = TabellTing.tilfeldigTabellSamme(20);
		Integer[] tab5 = TabellTing.tilfeldigTabellSamme(20);
		Integer[] tab6 = TabellTing.tilfeldigTabellFireSifre(20);
		
		System.out.println("tab 1:");
		System.out.println(Arrays.toString(tab1));
		System.out.println("etter sortering ved innsetting:");
		Sortering.sorteringVedInnsetting(tab1);
		System.out.println(Arrays.toString(tab1));
		
		lagMellomrom();
		
		System.out.println("tab 2:");
		System.out.println(Arrays.toString(tab2));
		System.out.println("etter sortering ved utvalg:");
		Sortering.sorteringVedUtvalg(tab2);
		System.out.println(Arrays.toString(tab2));
		
		lagMellomrom();
		
		System.out.println("tab 3:");
		System.out.println(Arrays.toString(tab3));
		System.out.println("etter boblesortering:");
		Sortering.bobleSortering(tab3);
		System.out.println(Arrays.toString(tab3));
		
		lagMellomrom();
		
		System.out.println("tab 4:");
		System.out.println(Arrays.toString(tab4));
		System.out.println("etter quicksort");
		Sortering.kvikkSortering(tab4);
		System.out.println(Arrays.toString(tab4));
		
		lagMellomrom();
		
		System.out.println("tab 5:");
		System.out.println(Arrays.toString(tab5));
		System.out.println("etter flettesortering:");
		Sortering.fletteSortering(tab5);
		System.out.println(Arrays.toString(tab5));
		
		lagMellomrom();
		
		System.out.println("tab 6:");
		System.out.println(Arrays.toString(tab6));
		System.out.println("etter radixsortering:");
		Sortering.sorteringVedUtvalg(tab6);
		System.out.println(Arrays.toString(tab6));
		
		lagMellomrom();
		

	}

	public static void lagMellomrom() {
		for(int i = 0; i < 3; i++) {
			System.out.println("///////////////////////////////////////////////");
		}
	}
}
