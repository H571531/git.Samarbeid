package no.hvl.dat102;

import org.junit.Before;

import no.hvl.dat102.mengde.tabell.TabellMengde;

public class TabellMengdeTest extends MengdeADTTest{
	
	@Before
	@Override
	public void setup() {
		mengde = new TabellMengde<Integer>();
		mengde2 = new TabellMengde<Integer>();
		test = new TabellMengde<Integer>();
	}


	
}
