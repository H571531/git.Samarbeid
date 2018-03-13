package no.hvl.dat102.sortering;

public class UtvalgsSortering {
	
	public static <T extends Comparable<? super T>> void utvalgsSortering (T[] data){
	int minste;
	T temp;
	for(int neste = 0; neste < data.length-1; neste++){
		minste = neste;
			for(int s�k = neste+1; s�k < data.length; s�k++){
				if(data[s�k].compareTo(data[minste]) < 0){
					minste = s�k;
				}
			}//indre
			
	/** Bytt verdiene */
			
			temp = data[minste];
		data[minste] = data[neste];
		data[neste] = temp;
		}//ytre
	}//metode
}
