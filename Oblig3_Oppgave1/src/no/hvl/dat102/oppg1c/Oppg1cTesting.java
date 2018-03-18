package no.hvl.dat102.oppg1c;

import java.time.Duration;
import java.time.Instant;

public class Oppg1cTesting {
	
	public static void main(String[] args) {
		//HanoiTaarn taarn = new HanoiTaarn(4);
		//taarn.solve();
		/*
		System.out.println("\n\n");
		
		
		HanoiTaarn taarn2 = new HanoiTaarn(4);
		taarn2.solveMedAntall();
		
		System.out.println("\n\n");
		
		long nanotid1 = System.nanoTime();
		Instant tid1 = Instant.now();
		HanoiTaarn taarn3 = new HanoiTaarn(16);
		taarn3.solveMedAntall();
		long nanotid2 = System.nanoTime();
		Instant tid2 = Instant.now();
		
		
		
		Duration varighet = Duration.between(tid1, tid2);
		System.out.println("Med Instant.now() og Duration.toMillis(): Tok " + varighet.toMillis() + "ms." );
		System.out.println("Med System.nanoTime: Tok " + (nanotid2-nanotid1) + " nanosek");
		
	*/
		
		for(int i = 0; i < 5; i++) {
			
		
		System.out.println("//////////////////////////");
		
		HanoiTaarn taarn3 = new HanoiTaarn(32);
		HanoiTaarn taarn4 = new HanoiTaarn(16);
		
		taarn3.solveMedAntall();
		taarn4.solveMedAntall();
		
		long tid3 = taarn3.getTidNS();
		long tid4 = taarn4.getTidNS();
		
		System.out.println("///////////////////");
		
		System.out.println("Tid32 / Tid16 = " + tid3 + " / " + tid4);
		System.out.println(" = " + (double) (tid3 / tid4));
		
		
		}
		System.out.println("\n");
		double antall1 = Math.pow(2, 32);
		double antall2 = Math.pow(2, 16);
		double sammenligning =  (antall1  / antall2);
		System.out.println("(2^32 - 1) / (2^16 - 1) = " + antall1 + " / " + antall2 + " = " + sammenligning);
		
	}

}
