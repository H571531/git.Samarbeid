package no.hvl.dat102;

import no.hvl.dat102.adt.CDArkivADT;

public class CDArkiv2 implements CDArkivADT {
	
	private int antall;
	private LinearNode<CD> start;
	
	public CDArkiv2() {
		antall = 0;
		start = null;
	}

	@Override
	public CD[] getCDTabell() {
		CD[] CDTabell=new CD[antall];
		LinearNode<CD> denne = start;
		for(int i=0;denne!=null && i<antall; i++){
			CDTabell[i]=denne.getElement();
			denne=denne.getNeste();
		}
		return CDTabell;
	}

	@Override
	public void leggTilCD(CD nyCd) {
		LinearNode<CD> nyCD = new LinearNode<CD>(nyCd);
		nyCD.setNeste(start);
		start = nyCD;
		antall++;
	}

	@Override
	public boolean slettCD(int CDNummer) {
		
		//return false hvis arkivet er tomt
		if(antall == 0) {
			return false;
		}
		boolean slettet = false;
		
		LinearNode<CD> forrige = null;
		LinearNode<CD> denne = start;
		
		
		//Spesielt tilfelle hvis første skal slettes
		if(denne.getElement().getCdNummer() == CDNummer) {
			start = start.getNeste();
			antall--;
			slettet = true;
		} else {
			denne = denne.getNeste();
			forrige = start;
			
			while(!slettet && denne != null) {
				if(denne.getElement().getCdNummer() == CDNummer) {
					//Hvis match, sett forriges neste-referanse til dennes neste-referanse
					forrige.setNeste(denne.getNeste());
					antall--;
					slettet = true;
				} else {
					//Hvis ikke match, oppdater forrige og denne
					forrige = denne;
					denne = denne.getNeste();
				}
			}
			
		}
		return slettet;
		
		
	}

	//Samme private TrimTab() som i CDArkiv
	private CD[] trimTab(CD[] tab, int n) {
		CD[] cdtab2 = new CD[n];
		int i = 0;
		while (i < n) {
			cdtab2[i] = tab[i];
			i++;
		}
		return cdtab2;
		
	}
	
	@Override
	public CD[] sokTittel(String delAvTittel) {
		CD[] ut = new CD[antall];
		int antallFunnet = 0;
		LinearNode<CD> denne = start;
		
		while(denne != null) {
			if(denne.getElement().getCdTittel().contains(delAvTittel)) {
				ut[antallFunnet] = denne.getElement();
				antallFunnet++;
				denne = denne.getNeste();
			} else {
				denne = denne.getNeste();
			}
		}
		
		//return null hvis det ikke er funnet noen
		if(antallFunnet == 0) {
			return null;
		}
		
		return trimTab(ut, antallFunnet);
		
	}

	@Override
	public CD[] sokArtist(String artist) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public int getAntall() {

		return antall;
	}

	@Override
	public int getAntall(Sjanger sjanger) {
		
		int antallFunnet = 0;
		LinearNode<CD> denne = start;
		
		while(denne != null) {
			if(denne.getElement().getCdSjanger().equals(sjanger)) {
				antallFunnet++;
				denne = denne.getNeste();
			} else {
				denne = denne.getNeste();
			}
		}
		
		return antallFunnet;
	}

}
