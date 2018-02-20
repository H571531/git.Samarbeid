package no.hvl.dat102.oppg2;

public class Hobby {
	private String hobbyNavn;

	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}

	public String toString(){
	//returnerer hobbynavnet med ”<” foran og ”>” bak
	//som en String (Eksempel: <tegne, male> )
		return hobbyNavn;
	}

	public boolean equals(Object hobby2) { //
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}
	
	public String getHobbyNavn() {
		return hobbyNavn;
	}

}
