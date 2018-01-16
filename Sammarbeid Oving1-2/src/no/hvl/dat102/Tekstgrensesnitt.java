
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
				CD[] funnet = new CD[cda.getAntall()];
				funnet=cda.sokArtist(delstreng);
				
				for(int i=0; i<funnet.length; i++) {
					System.out.println(funnet[i].toString());
				}
	}
	
	public void skrivUtStatistikk(CDArkivADT cda) {
		int antall = cda.getAntall();
		System.out.println("Statistikk :");
		System.out.println("Det er totalt " + antall + " CD'er i arkivet");
		for(Sjanger sjanger : Sjanger.values()) {
			System.out.println(String.format("%-10s: %d", sjanger.toString(), cda.getAntall(sjanger)));
		}
	}
  
  /**
	 * Skriver ut en gitt CD til konsoll
	 * @param cd
	 */
	public static void visCD(CD cd) {
		System.out.println("Viser CD:");
		System.out.println(cd);
	}
	
	
	/**
	 * Skriver ut alle CDer i cda med String delstreng i tittel
	 * @param cda arkiv som sÃ¸kes i
	 * @param delstreng del av tittel som sÃ¸kes etter
	 */
	public static void skrivUtCdDelstrengITittel(CDArkivADT cda, String delstreng) {
		CD[] funnet = cda.sokTittel(delstreng);
		
		if(funnet == null) {
			System.out.println("Finner ingen CDer med " + delstreng + " i tittelen");
		} else {
			System.out.println("Viser CD(er) med " + delstreng + " i tittelen:");
			for(CD cd : funnet) {
				visCD(cd);
				System.out.println("---------");
			}
		}

}
