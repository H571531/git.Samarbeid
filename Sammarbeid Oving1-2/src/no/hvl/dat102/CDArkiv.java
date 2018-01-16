package no.hvl.dat102;
import no.hvl.dat102.adt.CDArkivADT;

public class CDarkiv implements CDArkivADT {
	
	private CD[] arkiv;
	
	public CDarkiv() {
		this(0);
	}
	public CDarkiv(int storrelse) {
		this.arkiv = new CD[storrelse];
	}
	
}