package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.Jobb;
import no.hvl.dat102.JobbSamling;
import no.hvl.dat102.ordnetListe.KjedetOrdnetListe;
import no.hvl.dat102.sirkulaerKoe.SirkulaerKoeMedUnntak;

public class Kjoereplan3 {

	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		JobbSamling js = new JobbSamling();
		
		KjedetOrdnetListe<Jobb> klarOrdnetListe = new KjedetOrdnetListe<Jobb>();
		SirkulaerKoeMedUnntak<Jobb> klarKoe = new SirkulaerKoeMedUnntak<Jobb>();
		
		Jobb jobb = null;
		int klokke = 0;
		int tidskrav = 0;
		int antall = 0;
		
		/////////////////////
		int tidssegmentA = 80;
		int tidssegmentB = 0;
		
		//Lese fra fil
		System.out.println("Oppgi datafil: ");
		String filnavn = inn.next();
		System.out.println("Datafil: " + filnavn);
		
		inn.close();
		js.lesFraFil(filnavn);
		
		antall=js.getAntall();
		
		System.out.println("Antall: " + antall);
		JobbSamling ferdige = new JobbSamling(antall);
		
		while(ferdige.getAntall() < antall) {
			
			do {
				jobb = js.hentAnkommenJobb(klokke);
				if(jobb != null) {
					//Hvis noen jobber er klare, legg til Kø A(OrdnetListe)
					klarOrdnetListe.leggTil(jobb);
				} 
			} while(jobb != null);
			
			
			
			if(klarOrdnetListe.antall() > 0) {
				//Sjekke om det er noen jobber klare i Kø A(OrdnetListe)
				jobb = klarOrdnetListe.fjernFoerste();
				
				//Setter tidskrav til resttid i stedet for kjøretid
				tidskrav = jobb.getResttid();
				
				//Sjekke om jobb kan utføres i løpet av tidssegmentA
				if(tidskrav <= tidssegmentA) {
					//Jobb kan utføres ferdig
					klokke += tidskrav;
					jobb.setFerdigTid(klokke);
					ferdige.leggTil(jobb);
				} else {
					//Jobb kan ikke utføres ferdig - utfører jobben i tidssegmentA, før jobb legges til først i Kø B
					klokke += tidssegmentA;
					jobb.setResttid(tidskrav-tidssegmentA);
					klarKoe.innKoe(jobb);
					
				}
			} else if(klarKoe.antall() > 0) {
				//Hvis Kø A(Ordnet Liste) er tom, sjekk om det er noen jobber i Kø B som ikke er ferdige
				jobb = klarKoe.utKoe();
				tidskrav = jobb.getResttid();
				
				if(tidskrav <= tidssegmentB) {
					//Jobb kan gjøres ferdig i løpet av tidssegmentB
					klokke += tidskrav;
					jobb.setFerdigTid(klokke);
					ferdige.leggTil(jobb);
				} else {
					//Jobb kan ikke gjøres ferdig - utfører jobben i tidssegmentB, før jobb på nytt legges til først i Kø B
					klokke += tidssegmentA;
					jobb.setResttid(tidskrav-tidssegmentB);
					klarKoe.innKoe(jobb);
				}
				
			} else {
				//Ingen jobber klare til kjøring
				klokke++;
			}
			
			
		} 
		ferdige.visJobber();
		
	}
}
