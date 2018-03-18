package no.hvl.dat102.oppg1.frivilligLabyrint.iterativ;

import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.stabel.EmptyCollectionException;
import no.hvl.dat102.stabel.KjedetStabel;

public class LabyrintSpill {
	private Labyrint labyrint;

	public LabyrintSpill(Labyrint labyrint) {
		this.labyrint = labyrint;
	}

	/**
	 * Fors�ke � gjennomg� labyrinten
	 */

	public boolean gjennomgaa() {
		boolean ferdig = false;
		Posisjon pos = new Posisjon();
		StabelADT<Posisjon> stabel = new KjedetStabel<Posisjon>();
		stabel.push(pos);
		try {
			while (!stabel.erTom() && !(ferdig)) {
				pos = stabel.pop();
				labyrint.forsoekPosisjon(pos.getX(), pos.getY());
				if (pos.getX() == labyrint.getRekker() - 1 && pos.getY() == labyrint.getKolonner() - 1) {
					ferdig = true; // labyrinten er gjennomg�tt

				} else {
					// Frivillig oppgave: Legger til pos som parameter i push_ny_pos
					push_ny_pos(pos.getX(), pos.getY() - 1, stabel, pos);
					push_ny_pos(pos.getX(), pos.getY() + 1, stabel, pos);
					push_ny_pos(pos.getX() - 1, pos.getY(), stabel, pos);
					push_ny_pos(pos.getX() + 1, pos.getY(), stabel, pos);
				}
			} // while
		} catch (EmptyCollectionException ex) {
			System.out.println(ex.getMessage());
		}

		// Frivillig oppgave: Hvis det er sti gjennom labyrinten, marker siste pos som
		// sti, og gå bakover langs alle posisjonene som ble gjennomgått
		if (ferdig) {

			while (pos != null) {
				labyrint.markerSti(pos.getX(), pos.getY());
				pos = pos.getForrige();
			}

		}

		return ferdig;
	}

	private void push_ny_pos(int x, int y, StabelADT<Posisjon> stabel, Posisjon forrige) {
		Posisjon nypos = new Posisjon();
		nypos.setX(x);
		nypos.setY(y);
		nypos.setForrige(forrige);
		if (labyrint.gyldigPosisjon(x, y)) {
			stabel.push(nypos);
		}
	}
}// class
