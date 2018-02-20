package no.hvl.dat102.oppg2;

public class Testing {
	
	
	public static void main(String[] args) {
		
		Hobby tv = new Hobby("Tv");
		Hobby hobby2 = new Hobby("Hobby 2");
		Hobby hobby3 = new Hobby("Hobby 3");
		
		Medlem medlem1 = new Medlem("Medlem 1");
		Medlem medlem2 = new Medlem("Medlem 2");
		Medlem medlem3 = new Medlem("Medlem 3");
		
		medlem1.leggTilHobby(tv);
		medlem1.leggTilHobby(hobby2);
		medlem2.leggTilHobby(tv);
		medlem2.leggTilHobby(hobby2);
		medlem3.leggTilHobby(tv);
		
		System.out.println(medlem1);
		System.out.println(medlem1.passerTil(medlem2));	//true
		System.out.println(medlem1.passerTil(medlem3));	//false
		
		Hobby sport = new Hobby("Sport");
		//Hobby tv = new Hobby("TV");
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
		
		Datakontakt arkiv = new Datakontakt();
		arkiv.leggTilMedlem(ola);
		arkiv.leggTilMedlem(kari);
		arkiv.leggTilMedlem(jan);
		arkiv.leggTilMedlem(anne);
		System.out.println(arkiv.finnPartnerFor("Ola"));
		System.out.println(arkiv.finnPartnerFor("Jan"));
		Tekstgrensesnitt.skrivParListe(arkiv);
		
	}
	

}
