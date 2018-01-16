package no.hvl.dat102;

public class CD {
	private int cdNummer;
	private String cdArtist;
	private String cdTittel;
	private int cdLansering;
	private Sjanger cdSjanger;
	
	public CD() {
		this(0,null,null,0,null);
		}

	public CD(int cdNummer,String cdArtist, String cdTittel,int cdLansering, Sjanger cdSjanger) {
		this.cdNummer=cdNummer;
		this.cdArtist=cdArtist;
		this.cdTittel=cdTittel;
		this.cdLansering=cdLansering;
		this.cdSjanger=cdSjanger;	
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
		return "CD [cdNummer=" + cdNummer + ", cdArtist=" + cdArtist + ", cdTittel=" + cdTittel + ", cdLansering="
				+ cdLansering + ", cdSjanger=" + cdSjanger + "]";
	}
	
}
