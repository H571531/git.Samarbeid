package no.hvl.dat102.klient;
import java.util.Scanner;
import no.hvl.dat102.*;
import no.hvl.dat102.adt.*;
import no.hvl.dat102.kjedetKoe.*;

public class Klient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner innData = new Scanner(System.in);
		 KoeADT <Person> PersonKoe = new  KjedetKoe<Person>();
		 for(int i=0; i<6; i++) {
			System.out.println("Fødselsår");
			int fodselsar = innData.nextInt();
			innData.nextLine();
			System.out.println("Skriv inn fornavn");
			String Fornavn = innData.nextLine();
			System.out.println("Skriv inn etternavn");
			String Etternavn = innData.nextLine();
			
			PersonKoe.innKoe(new Person(Fornavn, Etternavn, fodselsar));
		 }
	innData.close();
	
	while(!PersonKoe.erTom())
		System.out.println(PersonKoe.utKoe().toString());
	}
}
