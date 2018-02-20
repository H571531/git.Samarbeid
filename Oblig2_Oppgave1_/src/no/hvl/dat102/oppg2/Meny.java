package no.hvl.dat102.oppg2;

import java.util.Scanner;

public class Meny {
	
	private Scanner inn = new Scanner(System.in);
	private Datakontakt arkiv;
	
	public Meny() {
///////////
		//TESTDATA
		//////////
		Hobby sport = new Hobby("Sport");
		Hobby tv = new Hobby("TV");
		Hobby brettspill = new Hobby("Brettspill");
		Hobby data = new Hobby("Data");
		
		Medlem ola = new Medlem("Ola");
		Medlem kari = new Medlem("Kari");
		Medlem jan = new Medlem("Jan");
		Medlem anne = new Medlem("Anne");
		
		ola.leggTilHobby(sport);
		ola.leggTilHobby(tv);
		
		kari.leggTilHobby(sport);
		kari.leggTilHobby(tv);
		
		jan.leggTilHobby(sport);
		jan.leggTilHobby(tv);
		
		anne.leggTilHobby(sport);
		anne.leggTilHobby(data);
		
		arkiv = new Datakontakt();
		arkiv.leggTilMedlem(ola);
		arkiv.leggTilMedlem(kari);
		arkiv.leggTilMedlem(jan);
		arkiv.leggTilMedlem(anne);
		arkiv.finnPartnerFor("Ola");
		arkiv.finnPartnerFor("Jan");
		
		/////////////////////
		/////////////////////
		/////////////////////
	}
	
	public void start() {
		
		//oppsett();
		int valg = -1;
		
		do {
			
		
			System.out.println("Velkommen til medlemsadministrasjon!");
			System.out.println("1. Vis alle medlemmer");
			System.out.println("2. Vis alle medlemspar");
			System.out.println("3. Legg til medlem");
			System.out.println("4. Vis informasjon om et bestemt medlem");
			System.out.println("5. Finn match til et bestemt medlem");
			
			valg = inn.nextInt();
			
			switch(valg) {
			case 1:
				System.out.println("Viser alle medlemmer: ");
				System.out.println(arkiv.toString());
				break;
			case 2:
				Tekstgrensesnitt.skrivParListe(arkiv);
				break;
			case 3:
				arkiv.leggTilMedlem(Tekstgrensesnitt.lesMedlem(inn));
				break;
			case 4:
				Tekstgrensesnitt.visMedlemsInfo(arkiv, inn);
				break;
			case 5:
				Tekstgrensesnitt.finnMatch(arkiv, inn);
			}
		} while(valg != 0);
		inn.close();
	}
	
	private void oppsett() {
		
	}
	
	

}
