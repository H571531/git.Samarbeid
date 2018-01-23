package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.adt.CDArkivADT;

public class Meny {
	
	private Scanner inn = new Scanner(System.in);
	private CDArkivADT arkiv;
	
	public void start() {
		int valg = -1;
		
		do {
			
			System.out.println("Velkommen!");
			System.out.println("1. Les arkiv fra fil");
			System.out.println("2. Opprett nytt arkiv");
			System.out.println("0. Avslutt");
			valg = Integer.parseInt(inn.next());
			
			switch(valg) {
			case 1: 
				System.out.println("Leser inn fil");
				
				
				do {
					System.out.println("Skriv filnavn");
					
					
					String valgFil = inn.next();
					if(valgFil.equals("0")) {
						inn.close();
						return;
					}
					
					
					arkiv = Fil.lesFraFil(valgFil);
					
				} while(arkiv == null && valg != 0);
				
				break;
			case 2:
				arkiv = new CDArkiv();
				break;
			case 0:
				inn.close();
				return;
			}
			
			
			
			
			
			
			
		} while(valg != 0 && arkiv == null);
		
		//Valgt enten en fil eller å lage ny
		String sok = "";
		do {
			valg = -1;
			System.out.println("1. Legg til ny CD");
			System.out.println("2. Søk etter tittel");
			System.out.println("3. Søk etter artist");
			System.out.println("4. Vis statistikk");
			System.out.println("5. Vis arkiv");
			System.out.println("6. Lagre arkiv til fil");
			
			System.out.println("0. Avslutt");
			valg = inn.nextInt();
			
			switch(valg) {
			case 0:
				inn.close();
				return;
			case 1:
				arkiv.leggTilCD(Tekstgrensesnitt.lesCD());
				break;
			case 2:
				
				System.out.println("Søk etter tittel.");
				System.out.println("Skriv tittel som søkes etter: ");
				sok = inn.next();
				Tekstgrensesnitt.skrivUtCdDelstrengITittel(arkiv, sok);
				break;
			case 3:
				System.out.println("Søk etter artist");
				System.out.println("Skriv artist som søkes etter: ");
				sok = inn.next();
				Tekstgrensesnitt.skrivUtCdArtist(arkiv, sok);
				break;
			case 4:
				Tekstgrensesnitt.skrivUtStatistikk(arkiv);
				break;
			case 5:
				Tekstgrensesnitt.skrivUtArkiv(arkiv);
				break;
			case 6:
				System.out.println("Lagrer, skriv filnavn: ");
				Fil.skrivTilFil(arkiv, inn.next());
				break;
			}
		} while(valg != 0);
		
		
		inn.close();
	}

}
