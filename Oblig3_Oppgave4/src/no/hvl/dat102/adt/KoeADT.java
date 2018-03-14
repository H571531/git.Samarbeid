package no.hvl.dat102.adt;

public interface KoeADT<T> {
	
	/**
	 * Legger til et nytt element bakerst i køen
	 * @param element Elementet som skal legges til
	 */
	void innKoe(T element);
	
	/**
	 * Fjerner og returnerer elementet som er fremst i køen
	 * @return Elementet som er fremst i køen
	 */
	T utKoe() throws EmptyCollectionException;
	
	/**
	 * Returnerer elementet som er fremst i køen, uten å fjerne det fra køen
	 * @return Elementet som er fremst i køen
	 */
	T foerste() throws EmptyCollectionException;
	
	
	/**
	 * Returnerer true hvis køen er tom
	 * @return true hvis køen er tom, false hvis det er minst ett element i køen
	 */
	boolean erTom();
	
	/**
	 * Returnerer antall elementer i køen
	 * @return Antall elementer i køen
	 */
	int antall();

}
