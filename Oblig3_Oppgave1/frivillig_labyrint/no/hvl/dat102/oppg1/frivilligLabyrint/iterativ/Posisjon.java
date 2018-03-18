package no.hvl.dat102.oppg1.frivilligLabyrint.iterativ;

/***************************************************************/
/****************************************************************/
/*
 * Representerer en posisjon i en labyrint
 */

public class Posisjon {
	/** x koordinat */
	private int x;
	/** y koordinat */
	private int y;
	
	//Frivillig oppgave: legger til peker til Posisjonen som førte til denne posisjonen
	private Posisjon forrige;

	/*
	 * Konstrukt�r
	 */
	Posisjon() {
		x = 0;
		y = 0;
	}

	/**
	 * @return x, x-koordinat
	 */
	public int getX() {
		return x;
	}
	
	
	/**
	 * @param x , x-koordinat	 
	 */
	 	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return y, y-koordinat
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y, y-koordinat
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
	public Posisjon getForrige() {
		return forrige;
	}
	
	public void setForrige(Posisjon forrige) {
		this.forrige = forrige;
	}

	
	

}// class
