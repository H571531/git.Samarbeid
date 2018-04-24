package no.hvl.dat102.oppgd;

public class Oppg6d {

	public static void main(String[] args) {
		Student a = new Student(10, "Ole");
		Student b = new Student(10, "Ole");
		Student c = new Student(10, "Ola");
		System.out.println("hashCode for student a: " + a.hashCode());
		System.out.println("hashCode for student b: " + b.hashCode());
		System.out.println("hashCode for student c: " + c.hashCode());
	}

}
