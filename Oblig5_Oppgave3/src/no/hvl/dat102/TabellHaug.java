package no.hvl.dat102;

//import no.hvl.dat102.adt.HaugADT;

public class TabellHaug<T extends Comparable<? super T>> implements HaugADT<T> {
	// Lager en minimumshaug

	private T[] data;
	private int antall;

	private static final int STDK = 100;

	public TabellHaug() {
		data = (T[]) new Comparable[STDK];
		antall = 0;
	}

	public void leggTilElement(T el) {
		if (antall == data.length)
			utvidTabell();
		data[antall] = el; // Plasser den nye helt sist
		antall++;
		if (antall > 1)
			reparerOpp(); // Bytt om oppover hvis nødvendig
	}

	private void utvidTabell() {
		// Dobler tabellen ved behov for utviding
		int lengde = data.length;
		T[] ny = (T[]) new Comparable[2 * lengde];
		for (int i = 0; i < antall; i++)
			ny[i] = data[i];
		data = ny;
	}

	////////////////////////////
	////////// Oppgave 3g

	private void reparerOpp() {
		// flytte siste opp til rett plass
		
		//Lage referanse til siste element i haugen
		int index = antall-1;
		T temp = data[index];
		
		//Finne siste element sin forelder
		int forelder = (index-1)/2;
		
		
		while (temp.compareTo(data[forelder]) < 0 && index > 0) {
			//Så lenge temp er mindre enn sin forelder OG så lenge index > 0, altså så lenge index ikke refererer til rot
			//Flytt forelder ett steg ned i treet, til der det mindre elementet er
			data[index] = data[forelder];
			
			//flytt index-referansen til der forelder har vært, og finn ny forelder
			index = forelder;
			forelder = (index-1)/2;
			
		}
		
		//Trenger ikke faktisk flytte temp oppover for hvert steg, så lenge forelder flyttes ned
		//Sett temp inn på rett plass - det som har vært der har eventuelt blitt flyttet ned et hakk
		data[index] = temp;
		// ... fyll ut
	}

	public T fjernMinste() {
		T svar = null;
		if (antall > 0) {
			svar = data[0];
			data[0] = data[antall - 1];
			reparerNed(); // Bytter om nedover hvis nødvendig
			antall--;
		}
		return svar;
	}

	public T finnMinste() {
		T svar = null;
		if (antall > 0) {
			svar = data[0];
		}
		return svar;
	}

	private void reparerNed() {
		T hjelp;
		boolean ferdig = false;
		int forelder = 0; // Start i roten og sml med neste nivå
		int minbarn;
		int vbarn = forelder * 2 + 1;
		int hbarn = vbarn + 1;
		while ((vbarn < antall) && !ferdig) { // Har flere noder lenger nede
			minbarn = vbarn;

			if ((hbarn < antall) && ((data[hbarn]).compareTo(data[vbarn]) < 0))
				minbarn = hbarn;
			// Har funnet det "minste" av barna. Sml med forelder

			if ((data[forelder]).compareTo(data[minbarn]) <= 0)
				ferdig = true;
			else { // Bytt om og gå videre nedover hvis forelder er for stor
				hjelp = data[minbarn];
				data[minbarn] = data[forelder];
				data[forelder] = hjelp;
				forelder = minbarn;
				vbarn = forelder * 2 + 1;
				hbarn = vbarn + 1;
			}
		}
	}

	public boolean erTom() {
		return antall == 0;
	}

	public void skrivTab() {
		// Hjelpemetode til test
		for (int i = 0; i < antall; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}
}