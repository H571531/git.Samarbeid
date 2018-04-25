package no.hvl.dat102.dobbelkjedetordnetlistem;

import no.hvl.dat102.adt.DobbelKjedetOrdnetListeMADT;

//********************************************************************
//  
//  Representerer en dobbeltkjedet ordnet liste med midtpeker.
//********************************************************************
;

public class DobbelKjedetOrdnetListeM<T extends Comparable<T>> implements DobbelKjedetOrdnetListeMADT<T> {
//M for midtpeker
	private DobbelNode<T> foerste;
	private DobbelNode<T> midten;
	private DobbelNode<T> siste;
	private int antall;

	/******************************************************************
	 * Oppretter en tom liste.
	 ******************************************************************/
	// Konstrukt�r

	public DobbelKjedetOrdnetListeM(T minVerdi, T maksVerdi) {

		// F�rste node
		DobbelNode<T> nyNode1 = new DobbelNode<T>(minVerdi);
		foerste = nyNode1;
		midten = foerste;

		// Siste node
		DobbelNode<T> nyNode2 = new DobbelNode<T>();
		nyNode2.setElement(maksVerdi);
		nyNode1.setNeste(nyNode2);
		nyNode2.setForrige(nyNode1);
		siste = nyNode2;

		antall = 0;
	}

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************

	@Override
	public void leggTil(T el) {

		// Setter inn ordnet f�r den noden p peker p�
		DobbelNode<T> p;

		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier

			antall++;

			if (el.compareTo(midten.getElement()) >= 0) {// Finn plass i siste
															// halvdel
				p = midten.getNeste();
			} else { // Finn plass i f�rste halvdel
				p = foerste.getNeste();
			}

			while (el.compareTo(p.getElement()) >= 0) {
				p = p.getNeste();
			} // while

			// Setter inn:
			// Innsett foran noden som p peker p�

			DobbelNode<T> nyNode = new DobbelNode<T>(el);
	
			// Fyll ut med noen f� setninger
			nyNode.setNeste(p);
			nyNode.setForrige(p.getForrige());
			p.getForrige().setNeste(nyNode);
			p.setForrige(nyNode);
			
			// Oppdaterer ny midten
			//nyMidten();
			nyMidten(el.compareTo(midten.getElement()));
			
		} // else lovlige

	}//

	// **********************************************************************************
	// Hjelpemetode til � finne ny midten.
	// Mindre effektiv fordi vi m� gjennomg� ca halve listen, men greit nok,
	// ellers kan en teste p� om antall er partall er oddetall ved oppdatering
	// av midtpeker
	// *********************************************************************************
	
	/*
	private void nyMidten() {
		// Er O(n) fordi man g�r gjennom hele listen
		// Kan gj�res om til 0(1) ved � bare sjekke om midten < h�yre side og midten > venstre siden
		// Hvis en av sjekkene over er false s� flytter du midten til venstre eller h�yre
		int midtNR = antall / 2;
		DobbelNode<T> p = foerste.getNeste();
		for (int i = 1; i <= midtNR; i++) {
			p = p.getNeste();
		}
		midten = p;
	}//
	*/
	
	private void nyMidten(int sammenligning) {
		// Medlemsvariabelen antall har blitt oppdatert av fjern- eller
		// legg-til-metodene
		/*
		 * Seks situasjoner hvor man må flytte: Hvis antall er partall: Det er lagt til
		 * noe som er < midten Det er fjernet noe som er > midten Midten er fjernet I
		 * alle tilfeller må midten flyttes ett hakk "til venstre" Hvis antall er
		 * oddetall: Det er lagt til noe som er > midten Det er fjernet noe som er <
		 * midten Midten er fjernet I alle tilfeller må midten flyttes ett hakk
		 * "til høyre"
		 * 
		 * Hvis kall på nyMidten kommer fra leggTil sendes
		 * el.compareTo(midten.getElement()) Hvis kall på nyMidten kommer fra fjern
		 * sendes -(el.compareTo(midten.getElement()) (Kunne vel vært
		 * midten.getElement().compareTo(el))
		 */

		if (antall % 2 == 0) {
			if (sammenligning <= 0) {
				midten = midten.getForrige();
			}

		} else {

			if (sammenligning >= 0) {
				midten = midten.getNeste();
			}

		}
	}

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************
	@Override
	public boolean fins(T el) {
		boolean funnet = false;
		DobbelNode<T> p = null;
		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier
			if (el.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
				p = midten; // Midten defineres � tilh�re siste del
			} else { // Let i f�rste halvdel
				p = foerste.getNeste();
			}

			while (el.compareTo(p.getElement()) > 0) {
				p = p.getNeste();
			} // while

			// Test p� funnet
			if (el.compareTo(p.getElement()) == 0) {
				funnet = true;
			}
		} // else
		return funnet;
	}//

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************
    // Omskrive til � bruke finn-metoden
	@Override
	public T fjern(T el) {
		T resultat = null;
		DobbelNode<T> p = finn(el);
		
		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else {
		
			if (p != null) {
				// Tar ut 
				antall = antall - 1;
				// Fyll ut med noen f� setninger.
				p.getForrige().setNeste(p.getNeste());
				p.getNeste().setForrige(p.getForrige());
				// Oppadtere midten
				//nyMidten();
				nyMidten(-(el.compareTo(midten.getElement())));

				resultat = p.getElement();

			} // funnet

		// lovlige
		}
		return resultat;
	}//

	/* Alternativ kan fjern-metoden bruke finn-metoden */
	
	public T gammelFjern(T el) {
		T resultat = null;
		DobbelNode<T> p = null;
		boolean funnet = false;

		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) { // Ugyldig.
																									// Alternativt kan
																									// vi ha det som et
																									// forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier

			if (el.compareTo(midten.getElement()) >= 0) {
				p = midten;
			} else {
				p = foerste.getNeste();
			}

			while (el.compareTo(p.getElement()) > 0) {
				p = p.getNeste();
			} // while

			if (el.compareTo(p.getElement()) == 0) {
				funnet = true;
			}

			if (funnet) { // Tar ut antall = antall - 1; // Fyll ut med noen f� setninger.

				p.getForrige().setNeste(p.getNeste());
				p.getNeste().setForrige(p.getForrige());

				// Oppdatere midten nyMidten();

				resultat = p.getElement();

			} // funnet

		} // lovlige
		return resultat;
	}//

	private DobbelNode<T> finn(T el) {
		DobbelNode<T> node = null;
		DobbelNode<T> p = null;

		// Kun lovlige verdier
		if (el.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
			p = midten; // Midten defineres � tilh�re siste del
		} else { // Let i f�rste halvdel
			p = foerste.getNeste();
		}
		while (el.compareTo(p.getElement()) > 0) {
			p = p.getNeste();
		} // while

		// Test p� funnet
		if (el.compareTo(p.getElement()) == 0) {
			node = p;
		}
		return node;
	}

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************

	public void skrivListe() {
		DobbelNode<T> p = foerste;

		while (p != null) {
			System.out.print(p.getElement() + " ");
			p = p.getNeste();
		}

		System.out.println(
				"Foerste:" + foerste.getElement() + " Midten:" + midten.getElement() + " Siste:" + siste.getElement());
		System.out.println();

	}//

}// class
