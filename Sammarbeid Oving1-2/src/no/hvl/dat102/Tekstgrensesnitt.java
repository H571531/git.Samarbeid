package no.hvl.dat102;
import no.hvl.dat102.adt.CDArkivADT;
import java.util.Scanner;


public class Tekstgrensesnitt {
	
	public static CD lesCD() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Skriv inn CD-Nummer");
		int nummerInn = Integer.parseInt(sc.nextLine());
		System.out.println("Skriv inn artist-navn eller gruppe");
		String navnInn = sc.nextLine();
		System.out.println("Skriv inn tittel");
		String tittelInn = sc.nextLine();
		System.out.println("Skriv inn utgivelsesår (int)");
		int utAar = sc.nextInt();
		System.out.println("Skriv inn sjanger");
		Sjanger sjanger = Sjanger.finnSjanger(sc.nextLine());
		System.out.println("Skriv inn plateselskap");
		String selskapInn = sc.nextLine();
		CD ny = new CD(nummerInn, navnInn, tittelInn, utAar, sjanger, selskapInn);
		sc.close();
		return ny;
	}
	
	public void visCD(CD cd) {
		
	}
	
	public void skrivUtCdDelstrengITittel(CDArkivADT cda, String delstreng) {
		
	}
	
	public void skrivUtCdArtist(CDArkivADT cda, String delstreng) {
		
	}
	
	public void skrivUtStatistikk(CDArkivADT cda) {
		int antall = cda.getAntall();
		System.out.println("Statistikk :");
		System.out.println("Det er totalt " + antall + " CD'er i arkivet");
		for(Sjanger sjanger : Sjanger.values()) {
			System.out.println(String.format("%-10s: %d", sjanger.toString(), cda.getAntall(sjanger)));
		}
	}
}
