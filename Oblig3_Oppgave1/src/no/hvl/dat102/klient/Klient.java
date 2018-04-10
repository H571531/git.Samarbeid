package no.hvl.dat102.klient;

import no.hvl.dat102.rekursjon.Rekursjon;

public class Klient {

	public static void main(String[] args) {
		System.out.println("Sum av de 100 forste tallene: "+Rekursjon.aritmetiskRekkeSum(100));

		for(int i=1; i<=10; i++) {
			System.out.print("a"+i+"\t");	
		}//for
		System.out.println();
		for(int i=1;i<=10;i++) {
			System.out.print(Rekursjon.AritmetiskElement(i)+"\t");
		}//for
		System.out.println();
	}//Main
}//Class
