package no.hvl.dat102;
import no.hvl.dat102.adt.CDArkivADT;
import java.util.Scanner;


public class Tekstgrensesnitt {
	
	
	public static CD lesCD() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Skriv inn CD-Nummer");
		String nummerInn = sc.nextLine();
		System.out.println("Skriv inn artist-navn eller gruppe");
		String navnInn = sc.nextLine();
		System.out.println("Skriv inn tittel");
		String tittelInn = sc.nextLine();
		System.out.println("Skriv inn utgivelsesår (int)");
		int utAar = sc.nextInt();
		System.out.println("Skriv inn sjanger");
		Sjanger sjanger = Sjanger.finnSjanger(sc.nextLine());
		sc.close();
		//hei
	}
	
	public void visCD(CD cd) {
		
	}
	
	public void skrivUtCdDelstrengITittel(CDArkivADT cda, String delstreng) {
		
	}
	
	public void skrivUtCdArtist(CDArkivADT cda, String delstreng) {
		
	}
	
	public void skrivUtStatistikk(CDArkivADT cda) {
		
	}
}
