package no.hvl.dat102.oppg2;

import java.util.Scanner;

public class Meny {

	private Scanner inn = new Scanner(System.in);
	private Datakontakt arkiv;

	public Meny() {
		///////////
		// TESTDATA
		//////////
		Hobby sport = new Hobby("Sport");
		Hobby tv = new Hobby("TV");
		Hobby brettspill = new Hobby("Brettspill");
		Hobby data = new Hobby("Data");

		Medlem ola = new Medlem("Ola");
		Medlem kari = new Medlem("Kari");
		Medlem jan = new Medlem("Jan");
		Medlem anne = new Medlem("Anne");
		Medlem petter = new Medlem("Petter");

		ola.leggTilHobby(sport);
		ola.leggTilHobby(tv);

		kari.leggTilHobby(sport);
		kari.leggTilHobby(tv);

		jan.leggTilHobby(sport);
		jan.leggTilHobby(tv);

		anne.leggTilHobby(sport);
		anne.leggTilHobby(data);

		petter.leggTilHobby(data);
		petter.leggTilHobby(brettspill);

		arkiv = new Datakontakt();
		arkiv.leggTilMedlem(ola);
		arkiv.leggTilMedlem(kari);
		arkiv.leggTilMedlem(jan);
		arkiv.leggTilMedlem(anne);
		arkiv.leggTilMedlem(petter);
		arkiv.finnPartnerFor("Ola");
		arkiv.finnPartnerFor("Jan");

		/////////////////////
		/////////////////////
		/////////////////////
	}

	public void start() {

		int valg = -1;

		do {
			System.out.println("//////////////////////////////////");
			System.out.println("Velkommen til medlemsadministrasjon!");
			System.out.println("1. Vis alle medlemmer");
			System.out.println("2. Vis alle medlemspar");
			System.out.println("3. Legg til medlem");
			System.out.println("4. Vis informasjon om et bestemt medlem");
			System.out.println("5. Finn match til et bestemt medlem");
			System.out.println("6. Mengde-operasjoner");
			System.out.println("7. Koble to medlemmer fra hverandre");
			System.out.println("\n0. Avslutt");

			valg = inn.nextInt();
			inn.nextLine();

			switch (valg) {
			case 1:
				System.out.println("Viser alle medlemmer: ");
				System.out.println(arkiv.toString());
				break;
			case 2:
				Tekstgrensesnitt.skrivParListe(arkiv);
				System.out.println();
				break;
			case 3:
				arkiv.leggTilMedlem(Tekstgrensesnitt.lesMedlem(inn));
				System.out.println();
				break;
			case 4:
				Tekstgrensesnitt.visMedlemsInfo(arkiv, inn);
				System.out.println();
				break;
			case 5:
				Tekstgrensesnitt.finnMatch(arkiv, inn);
				System.out.println();
				break;
			case 6:
				mengder();
				System.out.println();
				break;
			case 7:
				Tekstgrensesnitt.kobleFra(arkiv, inn);
				System.out.println();
				break;
			case 0:
				System.out.println("Avslutter...");
				break;
			}
		} while (valg != 0);
		inn.close();
	}

	public void mengder() {

		int valg = -1;

		do {
			System.out.println("Mengde-operasjoner");
			System.out.println("1. Vis union av to medlemmer sine hobbyer");
			System.out.println("2. Vis snitt av to medlemmer sine hobbyer");
			System.out.println("3. Vis differens av to medlemmer sine hobbyer");
			System.out.println("4. Vis om et medlems hobbyer er en undermengde av et annet medlems hobbyer");
			System.out.println("\n0. Tilbake til hoved-meny");
			
			valg = inn.nextInt();
			inn.nextLine();
			
			switch (valg) {
			case 1:
				Tekstgrensesnitt.finnUnion(arkiv, inn);
				System.out.println();
				break;
			case 2:
				Tekstgrensesnitt.finnSnitt(arkiv, inn);
				System.out.println();
				break;
			case 3:
				Tekstgrensesnitt.visDifferens(arkiv, inn);
				System.out.println();
				break;
			case 4:
				Tekstgrensesnitt.visUnderMengde(arkiv, inn);
				System.out.println();
				break;
			}
		} while (valg != 0);

	}

}
