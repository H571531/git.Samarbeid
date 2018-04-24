package no.hvl.dat102;

public interface HaugADT <T extends Comparable<? super T>> {
 
 /**
  * 
  * @param el Elementet som skal legges til haugen
  */
    void leggTilElement(T el);
    
 
 /** 
  * Fjerner det minste elementet fra haugen
  * @return Elementet med lavest verdi eller null hvsi haugen er tom  
  */ 
  T fjernMinste();
    
    
    /**
  * Finner det minste elementet i haugen
  * @return Elementet med lavest verdi eller null hvis haugen er tom
  */
    T finnMinste();
    
    
    /**
     * Avgjør om haugen er tom
     * @return true hvis haugen er tom, false ellers
     */
  boolean erTom();

}
