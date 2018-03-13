package no.hvl.dat102.sirkulaerKoe;

import no.hvl.dat102.adt.EmptyCollectionException;
import no.hvl.dat102.adt.KoeADT;

public class SirkulaerKoeMedUnntak<T> implements KoeADT<T>{
	
	private final static int DEFAULT_PLASS = 100;
	private int foran;
	private int bak;
	private int antall;
	
	private T[] ko;
	
	public SirkulaerKoeMedUnntak(int startKapasitet){
		ko = (T[])(new Object[startKapasitet]);
		antall = 0;
		foran = 0;
		bak = 0;
	}
	
	public SirkulaerKoeMedUnntak() {
		this(DEFAULT_PLASS);
	}
	
	public void innKoe(T element) {
		if(antall == ko.length) {
			utvid();
		}
		ko[bak] = element;
		bak = (bak+1) % ko.length;
		antall++;
	}
	
	public T utKoe() throws EmptyCollectionException{
		if(erTom()) {
			throw new EmptyCollectionException("Kø");
		}
		
		T ut = ko[foran];
		ko[foran] = null;
		foran = (foran+1) % ko.length;
		
		antall--;
		return ut;
		
	}
	
	private void utvid() {
		T[] ny = (T[])(new Object[(int)(ko.length * 2)]);
		
		for(int i = 0; i < antall; i++) {
			ny[i] = ko[foran];
			foran = (foran+1)%ko.length;
		}
		foran = 0;
		bak = antall;
		ko = ny;
		
	}

	public boolean erTom() {
		return antall == 0;
	}
	
	public T foerste() throws EmptyCollectionException {
		if(erTom()) {
			throw new EmptyCollectionException("Kø");
		}
		return ko[foran];
	}
	
	public int antall() {
		return antall;
	}
	
}
