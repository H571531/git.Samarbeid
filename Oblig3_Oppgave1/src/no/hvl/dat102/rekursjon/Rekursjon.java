package no.hvl.dat102.rekursjon;

public class Rekursjon {
	public static int aritmetiskRekkeSum(int n) {
		if(n==1) {
			return 1;
		}else {
			return aritmetiskRekkeSum(n-1)+n;
		}
	}
	
	//b
	public static int AritmetiskElement(int n) {
		if(n==0) {
			return 2;
		}else if(n==1) {
			return 5;
		}else {
			return 5*AritmetiskElement(n-1)-6*AritmetiskElement(n-2)+2;
		}
	}
	
	
}
