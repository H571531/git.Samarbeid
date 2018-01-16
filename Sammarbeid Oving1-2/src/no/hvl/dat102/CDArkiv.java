package no.hvl.dat102;
import no.hvl.dat102.adt.CDArkivADT;

public class CDarkiv implements CDArkivADT {
	
	private final static int STANDARD_KAPASITET = 100;
	
	private CD[] arkiv;
	int antall;
	
	public CDarkiv() {
		this(STANDARD_KAPASITET);
	}
	public CDarkiv(int storrelse) {
		this.arkiv = new CD[storrelse];
		antall = 0;
	}
	
	@Override
	public CD[] getCDTabell() {
		return this.arkiv;
	}
	
	@Override
	public void leggTilCD(CD cd) {
		if(antall == arkiv.length){
			utvid();
		}
		arkiv[antall] = cd;
		antall++;
	}
	
	@Override
	public CD[] sokTittel(String delnavn) {
		CD[] funnet = new CD[this.antall];
		int antFunnet = 0;
		for(int i = 0; i < this.antall; i++) {
			if(this.arkiv[i].getCdTittel().contains(delnavn)) {
				funnet[antFunnet] = this.arkiv[i];
				antFunnet++;
			}
		}
		funnet = trimTab(funnet, antFunnet);
		return funnet;
	}
	
	private CD[] trimTab(CD[] tab, int n) {
		CD[] cdtab2 = new CD[n];
		int i = 0;
		while (i < n) {
			cdtab2[i] = tab[i];
			i++;
		}
		return cdtab2;
		// Kristoffer er kul og rebell
	}
}