package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.Jobb;
import no.hvl.dat102.JobbSamling;
import no.hvl.dat102.ordnetListe.KjedetOrdnetListe;

public class Kjoereplan2 {
	
	public static void main(String[] args) {
		
		Scanner inn = new Scanner(System.in);
		JobbSamling js = new JobbSamling();
		
		KjedetOrdnetListe<Jobb> klarOrdnetListe = new KjedetOrdnetListe<Jobb>();
		
		Jobb jobb = null;
		int klokke = 0;
		int tidskrav = 0;
		int antall = 0;
		
		//Lese inn fra fil
		System.out.println("Oppgi datafil: ");
		String filnavn = inn.nextLine();
		System.out.println("Datfil: " + filnavn);
		
		inn.close();
		js.lesFraFil(filnavn);
		antall = js.getAntall();
		
		System.out.println("Antall: " + antall);
		
		JobbSamling ferdige = new JobbSamling(antall);
		
		while(ferdige.getAntall() < antall) {
			
			//Hente eventuelle jobber til klar-listen
			do {
				jobb = js.hentAnkommenJobb(klokke);
				if(jobb != null) {
					klarOrdnetListe.leggTil(jobb);
				}
			} while(jobb != null);
			
			//Ta eventuelt ut jobb fra liste til CPU
			if(klarOrdnetListe.antall() > 0) {
				jobb = klarOrdnetListe.fjernFoerste();
				tidskrav = jobb.getKjoeretid();
				klokke = klokke + tidskrav;
				jobb.setFerdigTid(klokke);
				ferdige.leggTil(jobb);
			} else {
				klokke++;
			}
		}
		ferdige.visJobber();
	}

}
