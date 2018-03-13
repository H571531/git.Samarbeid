package no.hvl.dat102.rekursjon;

public class Rekursjon {
	
	public static int aritmetiskRekkeSum(int n) {
		if(n==1) {
			return 1;
		}else {
			return aritmetiskRekkeSum(n-1)+n;
		}
	}
	
	
}
