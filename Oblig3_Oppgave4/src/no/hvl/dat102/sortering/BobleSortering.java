package no.hvl.dat102.sortering;

public class BobleSortering {
	public static <T extends Comparable<? super T>>void bobleSort (T[] data){
		int p, søk;
		T temp;
		for (p = data.length - 1; p >= 0; p--){
			for (søk = 0; søk <= p - 1; søk++){
				if (data[søk].compareTo(data[søk+1]) > 0){
	/** Bytt verdiene */
					temp = data[søk];
					data[søk] = data[søk + 1];
					data[søk + 1] = temp;
				}
			}//indre løkke
		}//ytre løkke
	}//metode
}
