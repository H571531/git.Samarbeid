package no.hvl.dat102.oppgd;

public class Student {
	private int snr;
	private String namn;

	public Student(int snr, String namn) {
		this.snr = snr;
		this.namn = namn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((namn == null) ? 0 : namn.hashCode());
		result = prime * result + snr;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (namn == null) {
			if (other.namn != null)
				return false;
		} else if (!namn.equals(other.namn))
			return false;
		if (snr != other.snr)
			return false;
		return true;
	}
}