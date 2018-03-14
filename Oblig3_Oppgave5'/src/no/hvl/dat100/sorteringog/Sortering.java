package no.hvl.dat100.sorteringog;

public class Sortering {
	
	public static <T extends Comparable<? super T>> void sorteringVedInnsetting(T[] tabell) {
		
		//Ytre: element 0 er "sortert", start pa element 1
		//Ga gjennom hele tabellen
		for(int i = 1; i < tabell.length ; i++) {
			T aktuell = tabell[i];
			int p = i;
			
			//indre loop - "indre tabell" - start på slutten av indre tabell
			//sa lenge elementet før aktuelt element er storre enn aktuelt element, flytt elementet foran ett hakk høyere
			while(p > 0 && tabell[p-1].compareTo(aktuell) > 0) {
				tabell[p] = tabell[p-1];
				p--;
			}
			//har na apnet riktig plass i den indre tabellen. sett inn aktuelt element
			tabell[p] = aktuell;
		}//Ytre
	}//Method
 public static <T extends Comparable<? super T>> int BinarySearch (T[] a, int low, int high, T key){
		int mid;

		if (low == high) {
			return low;
		}
		
		mid = low + ((high - low) / 2);

		if ( a[mid].compareTo(key)<=0) {
			return BinarySearch (a, mid + 1, high, key);
		} 	else if (a[mid].compareTo(key)>0) {
			return BinarySearch (a, low, mid, key);
		}
		return mid;
	}//method


	public static <T extends Comparable<? super T>> void BinaryInsertionSort (T[] tabell){
	    int ins, i, j;
	    T tmp;
	    int n=tabell.length;

	    for (i = 1; i < n; i++) {
	        ins = BinarySearch (tabell, 0, i, tabell[i]);
	        tmp = tabell[i];
	        for (j = i - 1; j >= ins; j--) {
	            tabell[j + 1] = tabell[j];
	        }//Indre
	        tabell[ins] = tmp;
	    }//Ytre
	}//Method
	
	


}
