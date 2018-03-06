package no.hvl.dat102.ordnetListe;
import no.hvl.dat102.adt.*;
/**
 * 
 * @param <T>
 *            elementtypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		T svar = null;
		//...Fyll ut
		
		if(!erTom()) {
			svar = foerste.getElement();
			foerste = foerste.getNeste();
			antall--;
		}
		
		//Sjekke om listen nå er tom
		//Hvis det bare var ett element er foerste nå satt til null, mens siste fremdeles refererer til node som skal fjernes
		if(erTom()) {
			siste = null;
		}
		return svar;
	}

	@Override
	public T fjernSiste() {
		T svar = null;

		if(!erTom()) {
			
			svar = siste.getElement();
			antall--;
			
			if(antall == 0) {
				foerste = null;
				siste = null;
			} else {
				//Må uansett oppdatere referansen til siste elementet, settes til nest siste element
				siste = foerste;
				for(int i = 1; i < antall; i++) {
					siste = siste.getNeste();
				}
				siste.setNeste(null);
			}
		}
		
		return svar;
	}

	@Override
	public T foerste() {
		T svar = null;
		if (!erTom()) {
			svar = foerste.getElement();
		}
		return svar;
	}

	@Override
	public T siste() {
		T svar = null;
		if (!erTom()) {
			svar = siste.getElement();
		}
		return svar;
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
	public void leggTil(T element) {
		LinearNode<T> aktuell = foerste;
		LinearNode<T> forrige = null;
		LinearNode<T> nyNode = new LinearNode<T>(element);
		
		while(aktuell != null && element.compareTo(aktuell.getElement()) > 0) {
			forrige = aktuell;
			aktuell = aktuell.getNeste();
		}
		
		if(forrige == null) {
			//Hvis forrige == null har forrige aldri blitt oppdatert -> nyNode skal settes inn først
			nyNode.setNeste(foerste);
			foerste = nyNode;
		} else {
			//Sette inn midt i eller til slutt
			nyNode.setNeste(aktuell);
			forrige.setNeste(nyNode);
		}
		
		if(aktuell == null) {
			//Hvis man kom helt gjennom listen må referansen til siste oppdateres
			siste = nyNode;
		}
		
		antall++;

		//...Fyll ut
	}


	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) {     // Første element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class