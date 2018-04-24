package no.hvl.dat102.oppgE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class OppgaveE {

	public static void main(String[] args) {
		
		final int ANT_ELEMENT = 100000;
		final int ANT_FORSOK = 1000;
		
		HashSet<Integer> hash = new HashSet<Integer>();
		int[] tabell = new int[ANT_ELEMENT];
		
		
		Random random = new Random();
		
		
		//Fyll tabell og hashset
		int tall = 376;
		for(int i = 0; i < ANT_ELEMENT; i++) {
			hash.add(tall);
			tabell[i] = tall;
			tall = (tall+45713)%1000000;
		}
		//System.out.println(tabell[99999]);
		//System.out.println(hash.size());
		
		Arrays.sort(tabell);
		
		int antFunnetITabell = 0;
		int antFunnetISet = 0;
		
		
		//Opprett tabell med tall som skal søkes etter
		int[] sokeTabell = new int[10000];
		for(int i = 0;i < 10000; i++) {
			//random.nextInt(int bound) - ikke inklusiv øvre grense
			sokeTabell[i] = random.nextInt(1000000);
		}
		
		////////HashSet søking
		
		ArrayList<Long> tiderSet = new ArrayList<Long>();
		
		for(int i = 0; i < ANT_FORSOK; i++) {
			long tidFoerHash = System.nanoTime();
			for(int j = 0; j < 10000; j++) {
				
				if(hash.contains(sokeTabell[j])) {
					antFunnetISet++;
				}
			}
			tiderSet.add( System.nanoTime() - tidFoerHash);
		}
		//Gjennomsnittstid
		long totalSetTid = 0;
		for(Long tid:tiderSet) {
			totalSetTid += tid;
		}
		long gjennomsnittSetTid = totalSetTid/ANT_FORSOK;
		int gjennomsnittAntallFunnetSet = antFunnetISet/ANT_FORSOK;
		
		
		/////////Tabell - Binærsøk
		ArrayList<Long> tiderTabell = new ArrayList<Long>();
		for(int i = 0; i < ANT_FORSOK; i++) {
			
			long tidFoerTabell = System.nanoTime();
			for(int j = 0; j < 10000; j++) {
				
				
				if(Arrays.binarySearch(tabell, sokeTabell[j]) >= 0) {
					antFunnetITabell++;
				}
			}
			tiderTabell.add(System.nanoTime() - tidFoerTabell);
			
		}
		
		long totalTabellTid = 0;
		for(Long tid: tiderTabell) {
			totalTabellTid+=tid;
		}
		long gjennomsnittTabellTid = totalTabellTid/ANT_FORSOK;
		int gjennomsnittAntallFunnetTabell = antFunnetITabell/ANT_FORSOK;
		
		
		System.out.println("Gjennomsnittlig tid brukt for binærsøk i tabell: " + gjennomsnittTabellTid + "ns = " + ((gjennomsnittTabellTid/Math.pow(10, 6))) + "ms. " + " - Gjennomsnittlig antall funnet: " + gjennomsnittAntallFunnetTabell);
		System.out.println("Gjennomsnittlig tid brukt for søk i HashSet: " + gjennomsnittSetTid + "ns = " + ((gjennomsnittSetTid/Math.pow(10, 6))) + "ms. " + " - Gjennomsnittlig antall funnet: " + gjennomsnittAntallFunnetSet);
	}
	
}
