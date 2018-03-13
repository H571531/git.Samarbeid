package no.hvl.dat102.rekursjon;

public class Rekursjon {
	//Oppgave A
	public static int aritmetiskRekkeSum(int n) {
		if(n==1) { //BasisSteg
			return 1;
		}else { //RekursivtSteg
			return aritmetiskRekkeSum(n-1)+n; //F�lger formel: Sn=Sn-1+n, for n�r S1=1
		}//if
	}//Method
	
	//Oppgave B
	public static int AritmetiskElement(int n) {
		if(n==0) {//BasisTilfelle n=0
			return 2;
		}else if(n==1) {//BasisTilfelle n=1
			return 5;
		}else {//RekursivtSteg
			return 5*AritmetiskElement(n-1)-6*AritmetiskElement(n-2)+2; //F�lger formelen An=5A_(n-1)-6A_(n-2)+2 
		}//if
	}//method
}//Class
