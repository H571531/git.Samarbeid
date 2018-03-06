package no.hvl.dat102.klient;
import java.util.Scanner;

import no.hvl.dat102.Person;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.kjedetKoe.KjedetKoe;
import no.hvl.dat102.sirkulaerKoe.SirkulaerKoMedUnntak;
import no.hvl.dat102.tabellOrdnetListe.TabellOrdnetListe;

public class Klient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner innData = new Scanner(System.in);
		 KoeADT <Person> PersonKoe = new  KjedetKoe<Person>();
		 KoeADT <Person> SirkulaerPersonKoe=new SirkulaerKoMedUnntak<Person>();
		 OrdnetListeADT <Person> OrdnetPersonListe=new KjedetOrdnetListe<Person>();
		 OrdnetListeADT<Person> OrdnetPersonTabellListe = new TabellOrdnetListe<Person>();
		 	
		/* for(int i=0; i<6; i++) {
			System.out.println("F�dsels�r");
			int fodselsar = innData.nextInt();
			innData.nextLine();
			System.out.println("Skriv inn fornavn");
			String Fornavn = innData.nextLine();
			System.out.println("Skriv inn etternavn");
			String Etternavn = innData.nextLine();
			
			PersonKoe.innKoe(new Person(Fornavn, Etternavn, fodselsar));
			SirkulaerPersonKoe.innKoe(new Person(Fornavn, Etternavn, fodselsar));
		 }//for */
		 
		 //<Debug> Lager personer rett i koden for kjappere tester. 
		 
		 Person Personen = new Person("Kristoffer","Nome",1984);
		 Person Personto = new Person("Ole","Olesen",1984);
		 Person Persontre = new Person("Kari","Karisen",1996);
		 Person Personfire = new Person("John","Johnsen",1995);
		 Person Personfem = new Person("Ice","T",1990);
		 Person Personseks = new Person("Adrian","Mortensen",1995);
		 
		 
		 PersonKoe.innKoe(Personen);
		 PersonKoe.innKoe(Personto);
		 PersonKoe.innKoe(Persontre);
		 PersonKoe.innKoe(Personfire);
		 PersonKoe.innKoe(Personfem);
		 PersonKoe.innKoe(Personseks);
		 
		 SirkulaerPersonKoe.innKoe(Personen);
		 SirkulaerPersonKoe.innKoe(Personto);
		 SirkulaerPersonKoe.innKoe(Persontre);
		 SirkulaerPersonKoe.innKoe(Personfire);
		 SirkulaerPersonKoe.innKoe(Personfem);
		 SirkulaerPersonKoe.innKoe(Personseks);
		 
		 OrdnetPersonListe.leggTil(Personen);
		 OrdnetPersonListe.leggTil(Personto);
		 OrdnetPersonListe.leggTil(Persontre);
		 OrdnetPersonListe.leggTil(Personfire);
		 OrdnetPersonListe.leggTil(Personfem);
		 OrdnetPersonListe.leggTil(Personseks);
		 
		 OrdnetPersonTabellListe.leggTil(Personen);
		 OrdnetPersonTabellListe.leggTil(Personto);
		 OrdnetPersonTabellListe.leggTil(Persontre);
		 OrdnetPersonTabellListe.leggTil(Personfire);
		 OrdnetPersonTabellListe.leggTil(Personfem);
		 OrdnetPersonTabellListe.leggTil(Personseks);
		 
		 
		 
		 
		 
		 //</Debug>
		 
		 innData.close();
		 System.out.println("Kjedet kø");
	while(!PersonKoe.erTom()) {
		System.out.println((PersonKoe.utKoe()).toString());
		}
	
		System.out.println("\n"+"Sirkulær kø");
	while(!SirkulaerPersonKoe.erTom()) {
		System.out.println((SirkulaerPersonKoe.utKoe()).toString());
	}
	
	System.out.println("\n"+"Ordnet kjedet liste");
	while(!(OrdnetPersonListe.erTom())) {
	System.out.println(OrdnetPersonListe.fjernFoerste().toString());
	}
	System.out.println("\nOrdnet tabell");
	while(!(OrdnetPersonTabellListe.erTom())) {
		System.out.println(OrdnetPersonTabellListe.fjernFoerste());
	}
	
	}
}
