package no.hvl.dat102;

import no.hvl.dat102.adt.CDArkivADT;

public class Tekstgrensesnitt {

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
	 * @param cda arkiv som søkes i
	 * @param delstreng del av tittel som søkes etter
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

	
}
