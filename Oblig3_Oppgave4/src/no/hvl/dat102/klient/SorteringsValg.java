package no.hvl.dat102.klient;

public enum SorteringsValg {
	INNSETTING(1), UTVALG(2), BOBLE(3), QS(4), FLETTE(5), RADIX(6), QS2(7);
	private int nr;
	
	private SorteringsValg(int nr) {
		this.nr = nr;
	}
	
	public static SorteringsValg finnValg(int n) {
		SorteringsValg valg = null;
		for (SorteringsValg v : SorteringsValg.values()) {
			if (v.nr == n) {
				valg = v;
				break;
			}
		}
		
		return valg;
	}

}
