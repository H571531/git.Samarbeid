package no.hvl.dat102;

import no.hvl.dat102.adt.CDArkivADT;
import java.util.Scanner;


public class Tekstgrensesnitt {
	
	public static CD lesCD(Scanner inn) {
		//Tar inn et Scanner-objekt som parameter, slik at det ikke må skapes et nytt objekt som aldri lukkes,
		System.out.println("Skriv inn CD-Nummer");
		int nummerInn = Integer.parseInt(inn.next());
		System.out.println("Skriv inn artist-navn eller gruppe");
		String navnInn = inn.next();
		System.out.println("Skriv inn tittel");
		String tittelInn = inn.next();
		
		int utAar = 0;
		do {
			//CDer ble lansert i 1982
			System.out.println("Skriv inn utgivelsesår (int)");
			utAar = inn.nextInt();
			
			if(utAar < 1982) {
				System.out.println("Kan ikke være utgitt før 1982");
			}
		} while(utAar < 1982);
		
		System.out.println("Skriv inn sjanger");
		Sjanger sjanger = Sjanger.finnSjanger(inn.next());
		System.out.println("Skriv inn plateselskap");
		String selskapInn = inn.next();
		CD ny = new CD(nummerInn, navnInn, tittelInn, utAar, sjanger, selskapInn);
		return ny;
	}
	
	
	
	public static void skrivUtCdArtist(CDArkivADT cda, String delstreng) {
				CD[] funnet = new CD[cda.getAntall()];
				funnet=cda.sokArtist(delstreng);
				
				for(int i=0; i<funnet.length; i++) {
					System.out.println(funnet[i].toString());
				}
	}
	
	public static void skrivUtStatistikk(CDArkivADT cda) {
		int antall = cda.getAntall();
		System.out.println("Statistikk :");
		System.out.println("Det er totalt " + antall + " CD'er i arkivet");
		for(Sjanger sjanger : Sjanger.values()) {
			System.out.println(String.format("%-10s: %d", sjanger.toString(), cda.getAntall(sjanger)));
		}
	}
  
  /**
	 * Skriver ut en gitt CD til konsoll
	 * @param cd
	 */
	public static void visCD(CD cd) {
		System.out.println("Viser CD:");
		System.out.println(cd);
	}
	
	
	/**
	 * Skriver ut alle CDer i cda med String delstreng i tittel
	 * @param cda arkiv som sÃ¸kes i
	 * @param delstreng del av tittel som sÃ¸kes etter
	 */
	public static void skrivUtCdDelstrengITittel(CDArkivADT cda, String delstreng) {
		CD[] funnet = cda.sokTittel(delstreng);
		
		if(funnet == null) {
			System.out.println("Finner ingen CDer med " + delstreng + " i tittelen");
		} else {
			System.out.println("Viser CD(er) med " + delstreng + " i tittelen:");
			for(CD cd : funnet) {
				visCD(cd);
				System.out.println("---------");
			}
		}
	}
	
	public static void skrivUtArkiv(CDArkivADT arkiv) {
		System.out.println("Viser arkiv:");
		System.out.println(arkiv);
	}
	
	public static void slettCD(CDArkivADT arkiv, int cdNummer) {
		boolean slettet = arkiv.slettCD(cdNummer);
		if(!slettet) {
			System.out.println("Finner ikke CD med CD-nummer: " + cdNummer);
		} else {
			System.out.println("Slettet CD med CD-Nummer: " + cdNummer);
		}
	}
}
