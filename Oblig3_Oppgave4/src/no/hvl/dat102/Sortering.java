package no.hvl.dat102;

import java.util.LinkedList;
import java.util.Queue;

import no.hvl.dat102.sirkulaerKoe.SirkulaerKoeMedUnntak;

public class Sortering {
	
	/*
	 * <T extends Comparable<? super T>
	 * Hvis <T extends Comparable<T>> kan en ikke benytte seg av polymorfi
	 *  derfor <T extends Comparable<? super T> - kan da sammenligne eventuelle barn av T
	 */
	
	public static <T extends Comparable<? super T>> void sorteringVedInnsetting(T[] tabell) {
		
		//Ytre: element 0 er "sortert", start på element 1
		//Gå gjennom hele tabellen
		for(int i = 1; i < tabell.length ; i++) {
			T aktuell = tabell[i];
			int p = i;
			
			//indre loop - "indre tabell" - start på slutten av indre tabell
			//så lenge elementet før aktuelt element er større enn aktuelt element, flytt elementet foran ett hakk høyere
			while(p > 0 && tabell[p-1].compareTo(aktuell) > 0) {
				tabell[p] = tabell[p-1];
				p--;
			}
			//har nå åpnet riktig plass i den indre tabellen. sett inn aktuelt element
			tabell[p] = aktuell;
		}
		
	}
	
	
	public static <T extends Comparable<? super T>> void sorteringVedUtvalg(T[] tabell) {
		int minsteIndeks = 0;
		for(int i = 0; i < tabell.length-1; i++) {
			minsteIndeks = i;
			for(int j = i+1; j < tabell.length; j++) {
				//Hvis tabell[j] er mindre enn tabell[minsteIndeks], sett minsteIndeks til j
				if(tabell[j].compareTo(tabell[minsteIndeks]) < 0) {
					minsteIndeks = j;
				}
			}
			//Flytt det minste usorterte elementet til første usorterte plass i tabellen
			byttPlass(tabell, i, minsteIndeks);
		}
		
	}
	
	public static <T extends Comparable<? super T>> void bobleSortering(T[] tabell) {
		for(int i = tabell.length-1; i >= 0; i--) {
			//j < i-1 siden trenger aldri gå gjennom tabellen for det siste elementet, som på det tidspunktet allerede vil være sortert
			for(int j = 0; j <= i-1; j++) {
				//Hvis tabell[j] er større enn tabell[j+1], flytt det større elementet mot høyre
				if(tabell[j].compareTo(tabell[j+1]) > 0) {
					byttPlass(tabell, j, j+1);
				}
			}
		}
	}
	
	public static <T extends Comparable<? super T>> void kvikkSortering(T[] tabell) {
		kvikkSortering(tabell, 0, tabell.length-1);
	}
	
	private static <T extends Comparable<? super T>> void kvikkSortering(T[] tabell, int start, int slutt) {
		//Sjekke at tabellen har lengde større enn 0
		if(start<slutt) {
			
			//Del tabellen i to med midterste element sortert
			int partisjonsIndeks = lagPartisjon(tabell, start, slutt);
			
			//Sorter venstre tabell
			kvikkSortering(tabell, start, partisjonsIndeks-1);
			//Sorter høyre tabell
			kvikkSortering(tabell, partisjonsIndeks+1, slutt);
		}
		
	}

	private static <T extends Comparable<? super T>> int lagPartisjon(T[] tabell, int start, int slutt) {
		
		int venstre;
		int hoyre;
		T pivot;
		
		pivot = tabell[start];
		venstre = start;
		hoyre = slutt;
		
		while(venstre < hoyre) {
			while(venstre < hoyre && tabell[venstre].compareTo(pivot) <= 0) {
				//Må ha while venstre<høyre også i indre loop - hvis ikke vil venstre øke forbi tabell.length ved sortert tabell
				//Øk venstre så lenge tabell[venstre] er mindre enn pivot
				venstre++;
			}
			while(tabell[hoyre].compareTo(pivot) > 0) {
				//Minsk hoyre så lenge tabell[hoyre] er større enn pivot
				hoyre--;
			}
			//Har funnet element på venstre side som er > pivot, og element på høyre side som er < pivot => bytt plass
			if(venstre < hoyre) {
				byttPlass(tabell, venstre, hoyre);
			}
		}
		//Venstre >= høyre: Ingen flere elementer på feil plass i forhold til pivotelement
		//= ingen flere elementer på venstre side som er > pivot, ingen flere på høyre side som er < pivot
		//= hoyre er nå plass hvor det siste elementet <= pivot ligger, bytt dette og pivot
		byttPlass(tabell, start, hoyre);
		return hoyre;
		
	}
	
	public static <T extends Comparable<? super T>> void fletteSortering(T[] tabell){
		fletteSortering(tabell, 0, tabell.length-1);
	}
	
	private static <T extends Comparable<? super T>> void fletteSortering(T[] tabell, int start, int slutt) {
		if(start < slutt) {
			int midten = (start+slutt) / 2;
			
			fletteSortering(tabell, start, midten);
			fletteSortering(tabell, midten+1, slutt);
			flette(tabell, start, midten, slutt);
		}
	}
	
	private static <T extends Comparable<? super T>> void flette(T[] tabell, int start, int midten, int slutt) {
		
		int stor = slutt - start +1;
		//T[] temp = (T[]) (new Comparable[tabell.length]);
		T[] temp = (T[]) (new Comparable[stor]);
		int forste1 = start;
		int siste1 = midten;
		
		int forste2 = midten+1;
		int siste2 = slutt;
		
		//int indeks = forste1;
		int indeks = 0;
		
		while(forste1 <= siste1 && forste2 <= siste2) {
			if(tabell[forste1].compareTo(tabell[forste2]) <= 0) {
				temp[indeks] = tabell[forste1];
				forste1++;
			} else {
				temp[indeks] = tabell[forste2];
				forste2++;
			}
			indeks++;
		}
		
		while(forste1 <= siste1) {
			temp[indeks] = tabell[forste1];
			forste1++;
			indeks++;
		}
		
		while(forste2 <= siste2) {
			temp[indeks] = tabell[forste2];
			forste2++;
			indeks++;
		}
		
		int h = 0;
		for(int i = start; i <= slutt; i++) {
			tabell[i] = temp[h++];
		}
	}
	
	public static void radixSortering(Integer[] tabell) {
		
		String temp;
		Integer tallObjekt;
		int siffer;
		int tall;
		
		//KoeADT<Integer> koe = new SirkulaerKoeMedUnntak<Integer>();
		SirkulaerKoeMedUnntak<Integer>[] sifferKoer = (SirkulaerKoeMedUnntak<Integer>[])(new SirkulaerKoeMedUnntak[10]);
		//WTFWTFWTF
		
		for(int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
			sifferKoer[sifferVerdi] = new SirkulaerKoeMedUnntak<Integer>();
		}
		
		for(int posisjon = 0; posisjon <= 3; posisjon++) {
			for(int i = 0; i < tabell.length; i++) {
				temp = String.valueOf(tabell[i]);
				//System.out.println(temp);
				siffer = Character.digit(temp.charAt(3-posisjon), 10);
				sifferKoer[siffer].innKoe(new Integer(tabell[i]));
			}
			
			tall = 0;
			for(int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
				while(!(sifferKoer[sifferVerdi]).erTom()) {
					tallObjekt = sifferKoer[sifferVerdi].utKoe();
					tabell[tall] = tallObjekt.intValue();
					tall++;
				}
			}
		}
		
	}
	
	public static void radixSorteringBok(Integer[] tabell) {
		String temp;
		Integer tallObjekt;
		int digit;
		int num;
		
		Queue<Integer>[] digitQueues = (LinkedList<Integer>[])(new LinkedList[10]);
		for(int digitVal = 0; digitVal <= 9; digitVal++) {
			digitQueues[digitVal] = (Queue<Integer>)(new LinkedList<Integer>());
		}
		
		for(int position = 0; position <= 3; position++) {
			for(int scan = 0; scan < tabell.length; scan++) {
				temp = String.valueOf(tabell[scan]);
				digit = Character.digit(temp.charAt(3-position), 10);
				digitQueues[digit].add(new Integer(tabell[scan]));
			}
			
			num = 0;
			for(int digitVal = 0; digitVal <= 9; digitVal++) {
				while(!(digitQueues[digitVal].isEmpty())) {
					tallObjekt = digitQueues[digitVal].remove();
					tabell[num] = tallObjekt.intValue();
					num++;
				}
			}
		}
	}
	
	
	private static <T extends Comparable<? super T>> void byttPlass(T[] tabell, int indeks1, int indeks2) {
		T temp = tabell[indeks1];
		tabell[indeks1] = tabell[indeks2];
		tabell[indeks2] = temp;
	}

}
