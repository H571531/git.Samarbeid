package no.hvl.dat102.oppg1.frivilligLabyrint.rekursiv;

public class LabyrintSpill {
	private Labyrint labyrint;
	
	public LabyrintSpill(Labyrint labyrint){
		this.labyrint = labyrint;
	}
	
	/**
	 * Fors�ke � gjennomg� labrinten
	 */
	public boolean gjennomgaa(int rekke, int kolonne){
		boolean ferdig = false;
		if(labyrint.gyldigPosisjon(rekke, kolonne)){
			labyrint.forsoekPosisjon(rekke, kolonne);
			if(rekke == labyrint.getRekker()-1 && kolonne == labyrint.getKolonner()-1){
				ferdig = true;
			}
			else{
				ferdig = gjennomgaa(rekke+1, kolonne);     // ned
				if(!ferdig){
					ferdig = gjennomgaa(rekke,kolonne+1);  // hoyre
				}
				if(!ferdig){
					ferdig = gjennomgaa(rekke-1,kolonne);  // opp
				}
				if(!ferdig){
					ferdig = gjennomgaa(rekke, kolonne-1);  // venstre
				}
			}
			if(ferdig){ // lokasjonen er en del av stien
				labyrint.markerSti(rekke, kolonne);	
			}
		
		}
		return ferdig;
   }

}
