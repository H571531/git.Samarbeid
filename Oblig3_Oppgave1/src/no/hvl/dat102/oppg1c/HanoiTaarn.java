package no.hvl.dat102.oppg1c;

import java.time.Duration;
import java.time.Instant;

public class HanoiTaarn {
	
	private int totalDisks;
	private long antallFlyttinger;
	
	//private Duration tid;
	private long tidSystem;
	
	public HanoiTaarn(int antallDisker) {
		totalDisks = antallDisker;
		antallFlyttinger = 0;
	}
	
	public void solve() {
		flyttTaarn(totalDisks, 1, 3, 2);
	}
	
	public void solveMedAntall() {
		//Instant tid1 = Instant.now();
		long nanoTid1 = System.nanoTime();
		
		flyttTaarn2(totalDisks, 1, 3, 2);
		long nanoTid2 = System.nanoTime();
		
		//Instant tid2 = Instant.now();
		//tid = Duration.between(tid1,  tid2);
		tidSystem = nanoTid2 - nanoTid1;
		
		System.out.println("Gjort " + antallFlyttinger + " flyttinger.");
		System.out.println("Formel: a_n = 2^n - 1 = " + (Math.pow(2, totalDisks)  -1));
		//System.out.println("Brukte " + tid.toNanos() + "nanosek.");
		System.out.println("Brukte " + tidSystem + " nanosek.");
	}
	
	
	
	private void flyttTaarn(int antallDisker, int start, int slutt, int temp) {
		if(antallDisker == 1) {
			flyttEnDisk(start, slutt);
		} else {
			flyttTaarn(antallDisker-1, start, temp, slutt);
			flyttEnDisk(start, slutt);
			flyttTaarn(antallDisker-1, temp, slutt, start);
		}
	}
	
	private void flyttEnDisk(int start, int slutt) {
		System.out.println("Flytter en disk fra " + start + " til " + slutt);
	}
	
	//Oppgave
	private void flyttTaarn2(int antallDisker, int start, int slutt,int temp) {
		if(antallDisker == 1) {
			antallFlyttinger++;
		} else {
			flyttTaarn2(antallDisker-1, start, temp, slutt);
			antallFlyttinger++;
			flyttTaarn2(antallDisker-1, temp, slutt, start);
		}
	}
	
	public long getTidNS() {
		return tidSystem;
	}

}
