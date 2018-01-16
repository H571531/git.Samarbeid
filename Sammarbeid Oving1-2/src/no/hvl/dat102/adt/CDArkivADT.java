package no.hvl.dat102.adt;

import no.hvl.dat102.CD;
import no.hvl.dat102.Sjanger;

public interface CDArkivADT {
	
	/**
	 * Returnere tabell med CDer
	 * @return tabell med CDer
	 */
	 CD[] getCDTabell();
	 
	 /**
	  * Legger til en ny CD
	  * @param nyCd Ny CD som skal legges til tabell
	  */
	 void leggTilCD(CD nyCd);
	 
	 /**
	  * Slett CD hvis den finnes i tabell
	  * @param CDNummer CDnummer på CD som skal slettes
	  * @return true hvis sletting ble gjennomført
	  */
	 boolean slettCD(int CDNummer);
	 
	 
	 /**
	  * Søker og henter CD med gitt tittel
	  * @param delAvTittel String som søkes etter
	  * @return tabell med CDer som inneholder gitt String
	  */
	 CD[] sokTittel(String delAvTittel);
	 
	 /**
	  * Søker etter CDer med gitt artist
	  * @param artist artist som søkes etter
	  * @return tabell med CDer av gitt artist
	  */
	 CD[] sokArtist(String artist);
	 
	 // Henter antall CD-er
	 /**
	  * Antall CDer i tabell
	  * @return antall CDer i tabell
	  */
	 int getAntall();
	 
	 // Henter antall CD-er for en gitt sjanger
	 /**
	  * Antall CDer med en gitt Sjanger
	  * @param sjanger Sjanger som søkes etter
	  * @return antall CDer med gitt Sjanger
	  */
	 int getAntall(Sjanger sjanger);
	


}
