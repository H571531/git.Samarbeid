package no.hvl.dat102.kjedetKoe;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.kjedetKoe.EmptyCollectionException;

public class KjedetKoe<T> implements KoeADT<T> {
	
	private int antall;
	private LinearNode<T> foran;
	private LinearNode<T> bak;
	
	public KjedetKoe() {
		antall = 0;
		foran = null;
		bak = null;
	}

	@Override
	public void innKoe(T element) {

		LinearNode<T> nyNode = new LinearNode<T>(element);
		if(erTom()) {
			foran = nyNode;
			
		} else {
			bak.setNeste(nyNode);
		}
		
		bak = nyNode;
		antall++;
		
	}

	@Override
	public T utKoe() throws EmptyCollectionException {

		T resultat = null;
		if(erTom()) {
			throw new EmptyCollectionException("Kø");
		} else {
			resultat = foran.getElement();
			foran = foran.getNeste();
			antall--;
			
			if(erTom()) {
				bak = null;
			}
		}
		return resultat;
	}

	@Override
	public T foerste() throws EmptyCollectionException {
		T resultat = null;
		if(erTom()) {
			throw new EmptyCollectionException("Kø");
		} else {
			resultat = foran.getElement();
		}
		
		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return antall;
	}

}
