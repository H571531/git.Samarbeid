package no.hvl.dat102.oppg2;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {

	private String navn;
	private KjedetMengde<Hobby> hobbyer;
	private int statusIndeks;
	
	public Medlem() {
		this(null);
	}
	
	public Medlem(String navn) {
		this(navn, new KjedetMengde<Hobby>());
	}
	
	public Medlem(String navn, KjedetMengde<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		statusIndeks = -1;
	}
	
	public void leggTilHobby(Hobby hobby) {
		hobbyer.leggTil(hobby);
	}

	/**
	 * Avgjør om et medlem passer til et annet medlem, basert på om de har nøyaktig samme hobbyer
	 * @param medlem2 Et annet medlem hvis hobbyer skal sammenlignes med
	 * @return true hvis medlem2 har like hobbyer
	 */
	public boolean passerTil(Medlem medlem2) {
		return hobbyer.equals(medlem2.hobbyer);
	}
	
	public int getAntallHobbyer() {
		return hobbyer.antall();
	}
	
	public String visHobbyer() {
		return "<" + hobbyer + ">";
		
	}
	public String toString() {
		String ut = navn + "\n" + "Hobbyer: " + visHobbyer();
		return ut;
	}
	
	public int getStatusIndeks() {
		return statusIndeks;
	}
	
	public void setStatusIndeks(int nyIndeks) {
		statusIndeks = nyIndeks;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public KjedetMengde<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(KjedetMengde<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}
}
