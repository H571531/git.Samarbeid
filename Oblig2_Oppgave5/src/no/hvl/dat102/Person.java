package no.hvl.dat102;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int fodselsar;
	
	public Person(String fornavn, String etternavn, int fodselsar) {
		this.fornavn=fornavn;
		this.etternavn=etternavn;
		this.fodselsar=fodselsar;
	}//Method
	
@Override
	public int compareTo(Person denAndre) {
		int retur;
		if(this.fodselsar==denAndre.getFodselsar()) {
			if(etternavn.compareTo(denAndre.getEtternavn())==0) {
				retur= fornavn.compareTo(denAndre.getFornavn());
			}else {
				retur=(etternavn.compareTo(denAndre.getEtternavn()));
			}
		}else if(this.fodselsar>denAndre.getFodselsar()) {
			retur= 1;
		}else {
			retur= -1;
		}
		return retur;
	}//Method
	
	
	
	
	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public int getFodselsar() {
		return fodselsar;
	}

	public void setFodselsar(int fodselsar) {
		this.fodselsar = fodselsar;
	}

	@Override
	public String toString() {
		return fodselsar+" "+etternavn+" "+fornavn;
	}
}//Class
