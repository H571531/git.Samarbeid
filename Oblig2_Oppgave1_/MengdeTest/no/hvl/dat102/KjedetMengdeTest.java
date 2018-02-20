package no.hvl.dat102;

import org.junit.Before;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class KjedetMengdeTest extends MengdeADTTest {
	
	@Before
	@Override
	public void setup() {
		mengde = new KjedetMengde<Integer>();
		mengde2 = new KjedetMengde<Integer>();
		test = new KjedetMengde<Integer>();
	}

}
