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
	public void leggTilCD(CD cd) {
		if(antall == arkiv.length){
			utvid();
		}
		arkiv[antall] = cd;
		antall++;
	}

	private void utvid() {
		CD[] hjelpetabell = new CD[(int)Math.ceil(1.1 * arkiv.length)];
		for(int i=0; i<arkiv.length; i++) {
			hjelpetabell[i]=arkiv[i];
		}
		arkiv=hjelpetabell;
	}
	
	@Override
	public int getAntall() {
		return antall;
	}
	@Override
	public int getAntall(Sjanger sj) {
		int teller=0;
		for(int i=0; i<antall; i++) {
			if(arkiv[i].getCdSjanger().equals(sj)) {
				teller++;
			}
		}
		return teller;
	}
	
	
	
	
}