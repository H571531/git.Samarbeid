package no.hvl.dat102;

public class OppgaveE {
	
	public static void main(String[] args) {
		System.out.println("\n\n////////////////////////////////////////////\nOPPGAVE 2) e)\n");
		KjedetBinaerSokeTre<Integer> tre2 = KjedetBinaerSokeTre.lagRandomTre(50, 1000);
		System.out.println("Vanlig inorder:");
		tre2.visInorden();
		System.out.println("\nskrivVerdier(20, 500): ");
		tre2.skrivVerdier(20, 500);
		System.out.println("\nskrivVerdier2(20, 500): ");
		tre2.skrivVerdier2(20,  500);
	}

}
