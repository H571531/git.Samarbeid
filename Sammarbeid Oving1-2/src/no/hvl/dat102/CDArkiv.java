package no.hvl.dat102;
import no.hvl.dat102.adt.CDArkivADT;

public class CDarkiv implements CDArkivADT {
	
	private final static int STANDARD_KAPASITET = 100;
	
	private CD[] arkiv;
	
	public CDarkiv() {
		this(STANDARD_KAPASITET);
	}
	public CDarkiv(int storrelse) {
		this.arkiv = new CD[storrelse];
	}
	
}