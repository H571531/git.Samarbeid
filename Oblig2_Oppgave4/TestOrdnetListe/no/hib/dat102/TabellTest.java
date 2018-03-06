package no.hib.dat102;

import no.hib.dat102.tabell.TabellOrdnetListe;

public class TabellTest extends ListeADTTest {
	@Override
	public void setup() {
		liste = new TabellOrdnetListe<Integer>();
	}
}
