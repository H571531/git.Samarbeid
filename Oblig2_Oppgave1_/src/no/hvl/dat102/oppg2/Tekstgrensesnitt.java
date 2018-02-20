package no.hvl.dat102.oppg2;

import java.util.Scanner;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Tekstgrensesnitt {
	// static Datakontakt medlemsliste = new Datakontakt();

	// leser opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem(Scanner inn) {
		// Tar inn scanner som parameter, slik at den kan lukkes i den kallende metoden,
		// og ikke i denne metoden
		// Scanner inn = new Scanner(System.in);
		
		KjedetMengde<Hobby> hobbyer = new KjedetMengde<Hobby>();
		System.out.println("Leser inn nytt medlem: ");
		System.out.println("Skriv medlemmets navn: ");
		String navn = inn.next();

		System.out.println("Leser inn hobbyer: ");
		String hobby = "";
		do {
			System.out.println("Skriv hobby som skal legges til (skriv 0 for å avslutte): ");
			hobby = inn.next();
			if (!hobby.equals("0")) {
				hobbyer.leggTil(new Hobby(hobby));
				System.out.println(hobby + " er lagt til.");
			} else {
				System.out.println("Avslutter innlesing av hobbyer...");
			}

		} while (!hobby.equals("0"));
		//inn.close();

		// legge til medlem?
		Medlem nyttMedlem = new Medlem(navn, hobbyer);
		// medlemsliste.leggTilMedlem(nyttMedlem);
		return nyttMedlem;

	}

	// skriver ut hobbylisten for et medlem
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene til " + medlem.getNavn());
		System.out.println(medlem.getHobbyer().toString());
	}

	/*
	 * skriver ut på skjermen en oversikt over medlemmer som er koblet til hverandre
	 * i medlemstabellen til enhver tid. Et slikt par skal kun vises én gang på
	 * utskriftlisten. Metoden skriver også ut antall par som er funnet. Eksempel på
	 * utskrift: PARNAVN HOBBYER Erna og Jonas <ski, musikk, politikk> Eva og Adam
	 * <epleplukking, paradishopping> ……………………. Antall par funnet: 12
	 */
	public static void skrivParListe(Datakontakt arkiv) {
		int antallPar = 0;

		Medlem[] tab = arkiv.getMedlemsTab();

		for (int i = 0; i < arkiv.getAntallMedlemmer(); i++) {
			// Hvis tab[i] har en match, og statusIndeks er mindre enn i, altså medlemmet er
			// i et par som ikke har blitt skrevet ut allerede
			if ((tab[i].getStatusIndeks() != -1) && tab[i].getStatusIndeks() <= i) {
				System.out.print(tab[i].getNavn() + " og " + tab[tab[i].getStatusIndeks()].getNavn() + "\t"
						+ tab[i].visHobbyer());
				System.out.println();
				antallPar++;
			}
		}
		System.out.println("Antall par funnet: " + antallPar);

	}

	public static void visMedlemsInfo(Datakontakt arkiv, Scanner inn) {
		System.out.println("Viser info om et bestemt medlem. Skriv navn på medlem som skal vises: ");
		String medlemsnavn = inn.next();
		Medlem medlem = arkiv.getBestemtMedlem(medlemsnavn);
		if (medlem == null) {
			System.out.println("Finner ikke medlem med navnet: " + medlemsnavn);
		} else {
			System.out.println(medlem);
		}
	}

	public static void finnMatch(Datakontakt arkiv, Scanner inn) {
		System.out.println("Leter etter match! ");
		System.out.println("Skriv navn på medlem det skal søkes for: ");
		String medlemsnavn = "";
		Medlem medlem;

		do {
			medlemsnavn = inn.nextLine();
			medlem = arkiv.getBestemtMedlem(medlemsnavn);

			if (medlem == null) {
				System.out.println("Finner ikke medlem med navnet: " + medlemsnavn);
				System.out.println("Søker igjen. Skriv 0 for å avslutte søk.");
			} else {
				// funnet medlem
				int partnerIndeks = medlem.getStatusIndeks();
				if (partnerIndeks != -1) {
					// medlem har ikke allerede partner
					int funnet = arkiv.finnPartnerFor(medlemsnavn);
					if (funnet != -1) {
						System.out.println("Finner ingen match til " + medlem.getNavn() + " i medlemsregisteret.");
					} else {
						System.out.println("Fant match!");
						System.out
								.println(medlem.getNavn() + " ble matchet med " + arkiv.getMedlemsTab()[partnerIndeks]);
					}

				} else {
					// medlem har allerede partner
					System.out.println(
							medlem.getNavn() + " har allerede partner: " + arkiv.getMedlemsTab()[partnerIndeks]);
				}

			}

		} while (medlem == null || medlemsnavn == "0");

		arkiv.finnPartnerFor(medlemsnavn);
	}

}
