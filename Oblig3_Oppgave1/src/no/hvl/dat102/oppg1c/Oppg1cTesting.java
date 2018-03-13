package no.hvl.dat102.oppg1c;

public class Oppg1cTesting {
	
	public static void main(String[] args) {
		//HanoiTaarn taarn = new HanoiTaarn(4);
		//taarn.solve();
		
		/*
		HanoiTaarn taarn2 = new HanoiTaarn(4);
		taarn2.solveMedAntall();
		
		long nanotid1 = System.nanoTime();
		Instant tid1 = Instant.now();
		HanoiTaarn taarn3 = new HanoiTaarn(30);
		taarn3.solveMedAntall();
		long nanotid2 = System.nanoTime();
		Instant tid2 = Instant.now();
		//tid1-tid2 var 2153 med 30
		
		
		Duration varighet = Duration.between(tid1, tid2);
		System.out.println("Tok " + varighet.toNanos() + "ms." );
		System.out.println("Med System.nanoTime: " + (nanotid2-nanotid1));
		
		*/
		
		System.out.println("//////////////////////////");
		
		HanoiTaarn taarn3 = new HanoiTaarn(64);
		HanoiTaarn taarn4 = new HanoiTaarn(32);
		
		taarn3.solveMedAntall();
		taarn4.solveMedAntall();
		
		long tid3 = taarn3.getTidNS();
		long tid4 = taarn4.getTidNS();
		
		System.out.println("///////////////////");
		
		System.out.println("Tid64 / Tid32 = " + tid3 + " / " + tid4);
		System.out.println(" = " + (double) (tid3 / tid4));
		
		System.out.println("\n\n\n");
		double antall1 = Math.pow(2, 64);
		double antall2 = Math.pow(2, 32);
		double sammenligning =  (antall1  / antall2);
		System.out.println("(2^64 - 1) / (2^32 - 1) = " + antall1 + " / " + antall2 + " = " + sammenligning);
	}

}
