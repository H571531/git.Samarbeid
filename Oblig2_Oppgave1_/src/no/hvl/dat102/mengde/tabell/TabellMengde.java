package no.hvl.dat102.mengde.tabell;

import no.hvl.dat102.mengde.adt.*;


import java.util.Iterator;
import java.util.Random;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) {
		// Søker etter og fjerner element.Returnerer null ved ikke-funn
		
		boolean funnet = false;
		T svar = null;
		
		if(!erTom()) {
			int i = 0;
			while(i < antall && !funnet) {
				if(tab[i].equals(element)) {
					svar = tab[i];
					funnet = true;
					
					antall--;
					tab[i] = tab[antall];
				} else {
					i++;
				}
			}
		}
		/*
		 * Fyll ut
		 */
		return svar;
	}
/* Lite effektiv!
	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		TabellMengde<T> begge = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			begge.leggTil(tab[i]);
		}
		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		return (MengdeADT<T>)begge;
	}
	*/
	
	//Oppgave 1b)i)
	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new TabellMengde<T>(this.antall() + m2.antall());
		T element = null;		
		/*
		 * Fyll ut
		 * 	
		 */	
		
		//Først sett inn alt fra m1 til begge uten å sjekke om begge allerede inneholder aktuelle elementet
		for(int i = 0; i< antall; i++) {
			((TabellMengde<T>)begge).settInn(tab[i]);
		}
		
		Iterator<T> iterator = m2.oppramser();
		//Trenger bare å sjekke om element finnes i m1, ikke i begge, som vil bli større og større
		while(iterator.hasNext()) {
			element = iterator.next();
			if(!this.inneholder(element)) {
				((TabellMengde<T>)begge).settInn(element);
			}
		}
		return begge;
	}//
	
	

	//Oppgave 1)b)ii)
	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
		T element= null;
		/*
		 * Fyll ut
		 */
		
		//Gå gjennom alle element i m2 - hvis det også finnes i this, settInn i snittM
		Iterator<T> iterator = m2.oppramser();
		while(iterator.hasNext()) {
			element = iterator.next();
			if(this.inneholder(element)) {
				((TabellMengde<T>)snittM).settInn(element);
			}
		}
		
		return snittM;
	}

	
	//Oppgave 1b)iii)
	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();
		T element;
		/*
		 * Fyll ut
		 
			if (!m2.inneholder(element))
				 ((TabellMengde<T>) differensM).settInn(element);
		*/
		
		Iterator<T> iterator = oppramser();
		while(iterator.hasNext()) {
			element = iterator.next();
			if(!m2.inneholder(element)) {
				((TabellMengde<T>)differensM).settInn(element);
			}
		}
		
		return differensM;
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		boolean likeMengder = true;
		T element;
		
		if(this.antall == m2.antall()) {
			Iterator<T> iterator = oppramser();
			
			while(iterator.hasNext() && likeMengder) {
				element = (T)iterator.next();
				if(!m2.inneholder(element)) {
					likeMengder = false;
				}
			}
		} else {
			likeMengder = false;
		}

		
		return likeMengder;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}
	

	//Oppgave 1b)iv)
	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		//Fyll ut
		T element = null;
		if(antall() >= m2.antall()) {
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

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}
	
	public String toString() {
		String ut = "";
		for(int i = 0; i < antall;i++) {
			ut += tab[i] + "\t";
			if((i+1)%10 == 0) {
				ut += "\n";
			}
		}
		return ut;
	}


}// class
