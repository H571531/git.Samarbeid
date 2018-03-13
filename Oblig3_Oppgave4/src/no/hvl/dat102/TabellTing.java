package no.hvl.dat102;

import java.util.Random;

public class TabellTing {
	
	public static Integer[] tilfeldigTabell(int storrelse) {
		Random random = new Random();
		Integer[] ut = new Integer[storrelse];
		for(int i = 0; i < storrelse; i++) {
			ut[i] = random.nextInt(10000);
		}
		
		return ut;
	}
	
	public static Integer[] tilfeldigTabellSamme(int storrelse) {
		Random random = new Random(12345);
		Integer[] ut = new Integer[storrelse];
		for(int i = 0; i < storrelse; i++) {
			ut[i] = random.nextInt(10000);
		}
		return ut;
	}
	
	public static Integer[] tilfeldigTabellFireSifre(int storrelse) {
		Random random = new Random();
		Integer[] ut = new Integer[storrelse];
		for(int i = 0; i < storrelse; i++) {
			ut[i] = random.nextInt(9000) + 1000;
		}
		return ut;
	}
	
	public static Integer[] tilfeldigTabellFireSifreSamme(int storrelse) {
		Random random = new Random(12345);
		Integer[] ut = new Integer[storrelse];
		for(int i = 0; i < storrelse; i++) {
			ut[i] = random.nextInt(9000) + 1000;
		}
		return ut;
	}

}
