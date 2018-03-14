package no.hvl.dat102.sortering;

import no.hvl.dat102.kjedetKoe.KjedetKoe;

public class RadixSortering {

	public static void Radix(Integer[] liste) {
		String temp;
		Integer tallObj;
		int siffer, tall;
		KjedetKoe<Integer>[] sifferKoer = (KjedetKoe<Integer>[]) (new KjedetKoe[10]);
		// Sirkulærkoe er mer effektiv ved uttak
		for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++)
			sifferKoer[sifferVerdi] = new KjedetKoe<Integer>();
		/** sorterer liste */
		for (int posisjon = 0; posisjon <= 3; posisjon++) {// ytre løkke
			for (int i = 0; i < liste.length; i++) {// indre løkke
				temp = String.valueOf(liste[i]);
				siffer = Character.digit(temp.charAt(3 - posisjon), 10);
				sifferKoer[siffer].innKoe(new Integer(liste[i]));
			} // indre løkke
			/* legger sorterte tall ut i liste */
			tall = 0;
			for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
				while (!(sifferKoer[sifferVerdi].erTom())) {
					tallObj = sifferKoer[sifferVerdi].utKoe();
					liste[tall] = tallObj.intValue();
					tall++;
				} // while
			} // for
		} // ytre løkke
		/** skriver ut sortert listet */
		for (int i = 0; i < liste.length; i++) {
			System.out.print(liste[i]+", ");
		}
			System.out.println();

	}

}
