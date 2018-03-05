package no.hvl.dat102.oppg2;

import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Tekstgrensesnitt {

	/**
	 * Leser inn opplysninger om et nytt medlem fra tastatur
	 * @param inn Scanner
	 * @return Et nyopprettet medlem
	 */
	public static Medlem lesMedlem(Scanner inn) {
		// Tar inn scanner som parameter, slik at den kan lukkes i den kallende metoden,
		// og ikke i denne metoden
		
		KjedetMengde<Hobby> hobbyer = new KjedetMengde<Hobby>();
		System.out.println("Leser inn nytt medlem. ");
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

		return new Medlem(navn, hobbyer);

	}

	/**
	 * Viser alle hobbyene til et gitt medlem
	 * @param medlem Navn på medlem som skal vises
	 */
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene til " + medlem.getNavn());
		System.out.println(medlem.getHobbyer().toString());
	}

	/* OPPGAVETEKST:
	 * skriver ut på skjermen en oversikt over medlemmer som er koblet til hverandre
	 * i medlemstabellen til enhver tid. Et slikt par skal kun vises én gang på
	 * utskriftlisten. Metoden skriver også ut antall par som er funnet. Eksempel på
	 * utskrift: PARNAVN HOBBYER Erna og Jonas <ski, musikk, politikk> Eva og Adam
	 * <epleplukking, paradishopping> ……………………. Antall par funnet: 12
	 */
	
	/**
	 * Skriver en liste over alle medlemmer som er koblet til hverandre, deres felles hobbyer,
	 * og total antall par i medlemssamlingen
	 * @param arkiv Medlemsarkivet det vises fra
	 */
	public static void skrivParListe(Datakontakt arkiv) {
		int antallPar = 0;

		Medlem[] tab = arkiv.getMedlemsTab();

		for (int i = 0; i < arkiv.getAntallMedlemmer(); i++) {
			// Hvis tab[i] har en match, og statusIndeks er mindre enn i, altså medlemmet er
			// i et par som ikke har blitt skrevet ut allerede
			if ((tab[i].getStatusIndeks() != -1) && tab[i].getStatusIndeks() <= i) {
				System.out.print(tab[i].getNavn() + " og " + tab[tab[i].getStatusIndeks()].getNavn() + "  " + tab[i].visHobbyer());
				System.out.println();
				antallPar++;
			}
		}
		System.out.println("Antall par funnet: " + antallPar);

	}

	/**
	 * Finner et bestemt medlem og skriver dette medlemmets navn og hobbyer
	 * @param arkiv Medlemsarkivet det søkes i
	 * @param inn Scanner
	 */
	public static void visMedlemsInfo(Datakontakt arkiv, Scanner inn) {
		System.out.println("Viser info om et bestemt medlem. Skriv navn på medlem som skal vises: ");
		Medlem medlem = finnMedlemTilBruk(arkiv, inn);
		if(medlem != null) {
			System.out.println(medlem);
		}
	}
	
	//Finner et medlem gjennom søking etter navn fra tastatur
	private static Medlem finnMedlemTilBruk(Datakontakt arkiv, Scanner inn) {
		//inn.nextLine();
		String medlemsnavn = "";
		
		Medlem medlem;
		
		do {
			medlemsnavn = inn.nextLine();
			medlem = arkiv.getBestemtMedlem(medlemsnavn);
			
			if(medlem == null && !medlemsnavn.equals("0")) {
				System.out.println("Finner ikke medlem med navnet: " + medlemsnavn);
				System.out.print("Søker igjen. Skriv 0 for å avslutte søk.\n:");
			} else if(medlemsnavn.equals("0")) {
				System.out.println("Avslutter søk");
			} 
			
		} while (medlem == null && !medlemsnavn.equals("0"));
		
		return medlem;
	}

	/**
	 * Finner et medlem i medlemsarkivet, søker etter en partner.
	 * Medlem og partner matches, og deres statusIndeks settes til den andres indeks i medlemsarkivet
	 * @param arkiv Medlemsarkivet det søkes i
	 * @param inn Tastatur
	 */
	public static void finnMatch(Datakontakt arkiv, Scanner inn) {
		System.out.println("Leter etter match! ");
		System.out.println("Skriv navn på medlem det skal søkes for: ");
		Medlem medlem = finnMedlemTilBruk(arkiv, inn);
		
		if(medlem != null) {
			//Funnet medlem
			int partnerIndeks = medlem.getStatusIndeks();
			if (partnerIndeks == -1) {
				// medlem har ikke allerede partner
				int funnet = arkiv.finnPartnerFor(medlem.getNavn());
				if (funnet == -1) {
					System.out.println("Finner ingen match til " + medlem.getNavn() + " i medlemsregisteret.");
				} else {
					System.out.println("Fant match!");
					System.out
							.println(medlem.getNavn() + " ble matchet med " + arkiv.getMedlemsTab()[funnet]);
				}

			} else {
				// medlem har allerede partner
				System.out.println(medlem.getNavn() + " har allerede partner: " + arkiv.getMedlemsTab()[partnerIndeks].getNavn());
			}

		}
		
	}
	
	/**
	 * Finner et medlem vha søking fra tastatur,
	 * hvis medlem er koblet til et annet, koble disse fra hverandre
	 * @param arkiv Medlemsarkiv det søkes i
	 * @param inn Tastatur
	 */
	public static void kobleFra(Datakontakt arkiv, Scanner inn) {
		System.out.println("Kobler to medlemmer fra hverandre");
		System.out.println("Skriv navn på ett av medlemmene:");
		
		Medlem m1 = finnMedlemTilBruk(arkiv, inn);
		
		if(m1 != null) {
			if(m1.getStatusIndeks() == -1) {
				System.out.println(m1.getNavn() + " er ikke koblet til et annet medlem!");
			} else {
				String m2Navn = arkiv.getMedlemsTab()[m1.getStatusIndeks()].getNavn();
				System.out.println(m1.getNavn() + " er koblet til " + m2Navn);
				System.out.println("Er du sikker på disse medlemmene skal kobles fra hverandre? (j/n): ");
				String bekreft = inn.nextLine();
				if(bekreft.equalsIgnoreCase("j")) {
					arkiv.tilbakestillStatusIndeks(m1.getNavn());
					System.out.println(m1.getNavn() + " og " + m2Navn + " er nå frakoblet.");
				} else {
					System.out.println("Avbryter frakobling...");
				}
			}
		}
	}
	
	/**
	 * Viser union av to medlemmers hobbyer
	 * @param arkiv Medlemsarkiv det søkes i
	 * @param inn Tastatur
	 */
	public static void finnUnion(Datakontakt arkiv, Scanner inn) {
		System.out.println("Visning av hobby-union");
		System.out.println("Skriv navn på første medlem det søkes etter: ");
		Medlem m1 = finnMedlemTilBruk(arkiv, inn);
		if(m1 != null) {
			System.out.println("Skriv navn på andre medlem det søkes etter: ");
			Medlem m2 = finnMedlemTilBruk(arkiv, inn);
			if(m2 != null) {
				System.out.print("Finner union av hobbyer mellom " + m1.getNavn() + " og " + m2.getNavn() + ":\n<");
				
				MengdeADT<Hobby> union = m1.getHobbyer().union(m2.getHobbyer());
				System.out.println(union + ">");
			}
		}
		
		
	}
	
	/**
	 * Viser snitt av to medlemmers hobbyer
	 * @param arkiv Medlemsarkiv det søkes i
	 * @param inn Tastatur
	 */
	public static void finnSnitt(Datakontakt arkiv, Scanner inn) {
		System.out.println("Visning av hobby-snitt");
		System.out.println("Skriv navn på første medlem det søkes etter: ");
		Medlem m1 = finnMedlemTilBruk(arkiv, inn);
		if(m1 != null) {
			System.out.println("Skriv navn på andre medlem det søkes etter: ");
			Medlem m2 = finnMedlemTilBruk(arkiv, inn);
			if(m2 != null) {
				System.out.print("Finner snitt av hobbyer mellom " + m1.getNavn() + " og " + m2.getNavn() + ":\n<");
				
				MengdeADT<Hobby> snitt = m1.getHobbyer().snitt(m2.getHobbyer());
				System.out.println(snitt + ">");
			}
		}
		
	}
	
	/**
	 * Viser differens av to medlemmers hobbyer
	 * @param arkiv Medlemsarkiv det søkes i
	 * @param inn Tastatur
	 */
	public static void visDifferens(Datakontakt arkiv, Scanner inn) {
		System.out.println("Visning av hobby-differens");
		System.out.println("Skriv navn på første medlem det søkes etter: ");
		Medlem m1 = finnMedlemTilBruk(arkiv, inn);
		if(m1 != null) {
			System.out.println("Skriv navn på andre medlem det søkes etter: ");
			Medlem m2 = finnMedlemTilBruk(arkiv, inn);
			if(m2 != null) {
				System.out.print("Finner " + m1.getNavn() + " sine hobbyer minus " + m2.getNavn() +" sine hobbyer:\n<");
				
				MengdeADT<Hobby> differens = m1.getHobbyer().differens(m2.getHobbyer());
				System.out.println(differens + ">");
			}
		}
		
		
	}
	
	
	/**
	 * Viser om et medlems hobbyer er undermengde av et annet medlems undermengde
	 * @param arkiv Arkiv det søkes i
	 * @param inn Tastatur
	 */
	public static void visUnderMengde(Datakontakt arkiv, Scanner inn) {
		System.out.println("Visning av undermengde");
		System.out.println("SKriv navn på første medlem det søkes etter: ");
		Medlem m1 = finnMedlemTilBruk(arkiv, inn);
		if(m1 != null) {
			System.out.println("Skriv navn på andre medlem det søkes etter: ");
			Medlem m2 = finnMedlemTilBruk(arkiv, inn);
			if(m2 != null) {
				System.out.println(m1.getNavn() + " sine hobbyer:" + m1.visHobbyer());
				System.out.println(m2.getNavn() + " sine hobbyer: " + m2.visHobbyer());
				 
				if(m1.getHobbyer().undermengde(m2.getHobbyer())) {
					System.out.println(m2.getNavn() + " sine hobbyer er en undermengde av " + m1.getNavn() + " sine hobbyer");
				} else {
					System.out.println(m2.getNavn() + " sine hobbyer er ikke en undermengde av " + m1.getNavn() + " sine hobbyer");

				}
			}
		}
		
	}

}
