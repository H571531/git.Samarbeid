package no.hvl.dat102.sortering;

public class UtvalgsSortering {
	
	public static <T extends Comparable<? super T>> void utvalgsSortering (T[] data){
	int minste;
	T temp;
	for(int neste = 0; neste < data.length-1; neste++){
		minste = neste;
			for(int søk = neste+1; søk < data.length; søk++){
				if(data[søk].compareTo(data[minste]) < 0){
					minste = søk;
				}
			}//indre
			
	/** Bytt verdiene */
			
			temp = data[minste];
		data[minste] = data[neste];
		data[neste] = temp;
		}//ytre
	}//metode
}
