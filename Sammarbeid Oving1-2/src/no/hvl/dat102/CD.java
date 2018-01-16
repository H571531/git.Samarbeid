package no.hvl.dat102;

public class CD {
	private int cdNummer;
	private String cdArtist;
	private String cdTittel;
	private int cdLansering;
	private Sjanger cdSjanger;
	private String plateselskap;
	
	public CD() {
		this(0,null,null,0,null, null);
		}

	public CD(int cdNummer,String cdArtist, String cdTittel,int cdLansering, Sjanger cdSjanger, String plateselskap) {
		this.cdNummer=cdNummer;
		this.cdArtist=cdArtist;
		this.cdTittel=cdTittel;
		this.cdLansering=cdLansering;
		this.cdSjanger=cdSjanger;	
		this.plateselskap = plateselskap;
	}

	public int getCdNummer() {
		return cdNummer;
	}

	public void setCdNummer(int cdNummer) {
		this.cdNummer = cdNummer;
	}

	public String getCdArtist() {
		return cdArtist;
	}

	public void setCdArtist(String cdArtist) {
		this.cdArtist = cdArtist;
	}

	public String getCdTittel() {
		return cdTittel;
	}

	public void setCdTittel(String cdTittel) {
		this.cdTittel = cdTittel;
	}

	public int getCdLansering() {
		return cdLansering;
	}

	public void setCdLansering(int cdLansering) {
		this.cdLansering = cdLansering;
	}

	public Sjanger getCdSjanger() {
		return cdSjanger;
	}

	public void setCdSjanger(Sjanger cdSjanger) {
		this.cdSjanger = cdSjanger;
	}

	@Override
	public String toString() {
		return String.format("%-12s: %d \n%-12s: %s \n%-12s: %s \n%-12s: %d \n%-12s: %s \n%-12s: %s\n", "CD-nummer", cdNummer, "Artist", cdArtist,
				"Tittel", cdTittel, "Utgitt", cdLansering, "Sjanger", cdSjanger.toString(), "Plateselskap", plateselskap);
	}
	//tester branch
	
}
