package no.hvl.dat102.mengde.kjedet;

import no.hvl.dat102.mengde.adt.*;
//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (!erTom()) {
			int valg = rand.nextInt(antall) + 1;
			if (valg == 1) {
				resultat = start.getElement();
				start = start.getNeste();
			} else {
				forgjenger = start;
				for (int nr = 2; nr < valg; nr++) {
					forgjenger = forgjenger.getNeste();
				}
				aktuell = forgjenger.getNeste();
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste());
			}
			antall--;
		} // if
		return resultat;
	}//

	@Override
	public T fjern(T element) {
		boolean funnet = false;
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		/* Fyll ut
		 * 
		 */
		
		if(!erTom()) {
			aktuell = start;
			
			//Hvis første i mengden skal fjernes
			if(aktuell.getElement().equals(element)) {
				funnet = true;
				resultat = aktuell.getElement();
				start = start.getNeste();
				antall--;
			} else {
				forgjenger = start;
				while(aktuell != null && !funnet) {
					if(aktuell.getElement().equals(element)) {
						resultat = aktuell.getElement();
						forgjenger.setNeste(aktuell.getNeste());
						antall--;
						funnet = true;
					} else {
						forgjenger = aktuell;
						aktuell = aktuell.getNeste();
					}
				}
				
			}
			
			
		}
		return resultat;
	}//

	

	//Oppgave 1b)i)
	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		T element = null;

		/*
		 * Fyll ut
		 */
		//Først sett inn alt fra m1 til begge uten å sjekke om begge allerede inneholder aktuelle elementet
		while(aktuell != null) {
			((KjedetMengde<T>)begge).settInn(aktuell.getElement());
			aktuell = aktuell.getNeste();
		}
		
		//Trenger bare å sjekke om element finnes i m1, ikke i begge, som vil bli større og større
		Iterator<T> iterator = m2.oppramser();
		while(iterator.hasNext()) {
			element = iterator.next();
			if(!this.inneholder(element)) {
				((KjedetMengde<T>)begge).settInn(element);
			}
		}
		return begge;
	}//

	
	//Oppgave 1b)ii)
	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new KjedetMengde<T>();
		T element;
		/* Fyll ut...
		 * 
			if (this.inneholder(element))		 
				((KjedetMengde<T>) snittM).settInn(element);
		*/
		
		//Gå gjennom hvert element i m2, hvis det også finnes i this -> legg inn i snittM
		Iterator<T> iterator = m2.oppramser();
		while(iterator.hasNext()) {
			element = iterator.next();
			if(this.inneholder(element)) {
				((KjedetMengde<T>)snittM).settInn(element);
			}
		}
		
		return snittM;
	}

	

	//Oppgave 1b)iii)
	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new KjedetMengde<T>();
		T element;
		/*Fyll ut
		 * 
		 */
		Iterator<T> iterator = oppramser();
		while(iterator.hasNext()) {
			element = iterator.next();
			if(!m2.inneholder(element)) {
				((KjedetMengde<T>)differensM).settInn(element);
			}
		}
		
		return differensM;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	
	//Oppgave 1a)
	@Override
	public boolean equals(MengdeADT<T> m2) {
		boolean likeMengder = true;
		T element = null;
		//Fyll ut
		
		if(antall == m2.antall()){
			Iterator<T> iterator = oppramser();
			while(iterator.hasNext() && likeMengder) {
				element = (T)iterator.next();
				if(!m2.inneholder(element)) {
					likeMengder = false;
				}
			}
			
			
		} else {
			//Hvis ulikt antall elementer, return false
			likeMengder = false;
		}
		return likeMengder;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}
	
	//Oppgave 1b)iv)
	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		//Fyll ut
		T element = null;
		//Kan først sjekke om m2 er større enn m1, som vil bety at m2 ikke kan være delmengde av m1
		if(antall() >= m2.antall() ) {
			Iterator<T> iterator = m2.oppramser();
			while(erUnderMengde && iterator.hasNext()) {
				element = iterator.next();
				if(!this.inneholder(element)) {
					erUnderMengde = false;
				}
			}
		} else {
			erUnderMengde = false;
		}
		
		return erUnderMengde;
	}
	
	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}
	
	public String toString() {
		String ut = "";
		LinearNode<T> denne = start;
		
		while(denne != null) {
			if(denne.getNeste() == null) {
				//Hvis siste element, ikke legg til \t
				ut += denne.getElement();
			} else {
				ut += denne.getElement() + "\t";
			}
			
			denne = denne.getNeste();
		}
		return ut;
	}

}// class
