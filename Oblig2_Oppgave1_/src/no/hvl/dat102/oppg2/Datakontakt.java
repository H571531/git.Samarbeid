package no.hvl.dat102.oppg2;


public class Datakontakt {
	private Medlem[] medlemsTab;
	private int antallMedlemmer;
	
	private final int DEFAULT_STORRELSE = 10;
	
	public Datakontakt() {
		medlemsTab = new Medlem[DEFAULT_STORRELSE];
		antallMedlemmer = 0;
	}
	
	/**
	 * Legger et gitt medlem til samlingen
	 * @param person Medlem som skal legges til
	 */
	public void leggTilMedlem(Medlem person) {
		if(antallMedlemmer == medlemsTab.length) {
			utvid();
		}
		medlemsTab[antallMedlemmer] = person;
		antallMedlemmer++;
	}
	
	private void utvid() {
		Medlem[] nyTab = new Medlem[medlemsTab.length *2];
		
		for(int i = 0; i < antallMedlemmer; i++) {
			nyTab[i] = medlemsTab[i];
		}
		medlemsTab = nyTab;
	}
	
	//Finner tabellindeks til et gitt medlem
	private int finnMedlemsIndeks(String medlemsnavn) {
		int funnetIndeks = -1;
		int i = 0;
		
		while(funnetIndeks < 0 && i < antallMedlemmer) {
			if(medlemsnavn.equals(medlemsTab[i].getNavn().toString())) {
				funnetIndeks = i;
			} else {
				i++;
			}
		}
		return funnetIndeks;
	}
	
	/**
	 * Leter etter match for gitt medlem, i forhold til matchende hobbyer.
	 * Setter statusIndeks til gitt medlem til eventuell match sin tabellindeks, og statusIndeks til eventuell match, til gitt medlems indeks
	 * @param medlemsnavn Navn på medlem det skal prøves å finne partner for
	 * @return indeks i medlemstabell for funnet partner
	 */
	public int finnPartnerFor(String medlemsnavn) {
		//Opprette en referanse til medlem som har medlemsnavn gitt som parameter
		int indeks = finnMedlemsIndeks(medlemsnavn);
		
		int funnetIndeks = -1;
		
		if(indeks != -1) {
			//Har funnet gitt medlem
			Medlem skalFinneFor = medlemsTab[indeks];
			boolean funnet = false;
			int i = 0;
			while(!funnet && i < antallMedlemmer) {
				if(skalFinneFor.equals(medlemsTab[i])) {
					//Hoppe over seg selv
					i++;
				} else if((skalFinneFor.passerTil(medlemsTab[i]) && medlemsTab[i].getStatusIndeks() == -1)) {
					//Hvis aktuelt medlem passer til gitt medlem, og aktuelt medlem ikke allerede er matchet:
					//sett gitt medlems statusindeks til i, sett aktuelt medlems statusindeks til gitt medlems indeks
					skalFinneFor.setStatusIndeks(i);
					medlemsTab[i].setStatusIndeks(indeks);
					funnetIndeks = i;
					funnet = true;
				} else {
					//Sjekkes ikke opp mot seg selv, og passet ikke med aktuelt medlem
					i++;
				}
				
			}
			
		} else {
			//Ikke funnet medlem som har medlemsnavn gitt som parameter
		}
		
		//funnetIndeks vil være -1 hvis ingen match funnet
		//Hvis ikke funnet - Legge til tabellen som et nytt medlem?
		return funnetIndeks;
		
	}
	
	/**
	 * Kobler medlemmer som er koblet fra hverandre, setter statusIndeks for begge til -1
	 * @param medlemsnavn Ett av medlemmene som skal frakobles
	 */
	public void tilbakestillStatusIndeks(String medlemsnavn) {
		//Finn tabellindeks til gitt medlem
		Medlem skalTilbakestilles = medlemsTab[finnMedlemsIndeks(medlemsnavn)];
		
		if(skalTilbakestilles != null) {
			//Sett statusindeks på koblet medlem til -1
			medlemsTab[skalTilbakestilles.getStatusIndeks()].setStatusIndeks(-1);
			
			//Sett statusindeks på gitt medlem til -1
			skalTilbakestilles.setStatusIndeks(-1);
		}
		
		
		
	}
	
	public Medlem getBestemtMedlem(String medlemsnavn) {
		Medlem ut = null;
		int indeks = finnMedlemsIndeks(medlemsnavn);
		if(indeks >= 0) {
			ut = medlemsTab[indeks];
		}
		
		return ut;
		
	}
	
	public String toString() {
		String ut = "";
		for(int i = 0; i < antallMedlemmer; i++) {
			ut += medlemsTab[i] + "\n";
		}
		return ut;
	}
	
	public Medlem[] getMedlemsTab() {
		return medlemsTab;
	}
	
	public int getAntallMedlemmer() {
		return antallMedlemmer;
	}

}
