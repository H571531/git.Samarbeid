package no.hvl.dat102.sortering;

public class BobleSortering {
	public static <T extends Comparable<? super T>>void bobleSort (T[] data){
		int p, s�k;
		T temp;
		for (p = data.length - 1; p >= 0; p--){
			for (s�k = 0; s�k <= p - 1; s�k++){
				if (data[s�k].compareTo(data[s�k+1]) > 0){
	/** Bytt verdiene */
					temp = data[s�k];
					data[s�k] = data[s�k + 1];
					data[s�k + 1] = temp;
				}
			}//indre l�kke
		}//ytre l�kke
	}//metode
}
