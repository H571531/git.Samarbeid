package no.hvl.dat102.sortering;

public class QuickSort {
	public static <T extends Comparable<T>> void kvikkSort (T[] data, int min, int maks){
		int posPartisjon;
		if (min < maks){ // minst to element
			/** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikkSort(data, min, posPartisjon-1);
			/** Sorterer høyre side */
			kvikkSort(data, posPartisjon+1, maks);
			}
		}// metode
	
	public static <T extends Comparable<T>> void kvikkSort (T[] data){
	// kall av metoden på forrige slide
		kvikkSort(data, 0, data.length-1);
	}//metode

	private static <T extends Comparable<T>> int finnPartisjon (T[] data, int min, int maks) {
		int venstre, hoyre;
		T temp, pivot;
		//pivot som første element. Boka bruker midterste
		pivot = data[min];
		venstre = min;
		hoyre = maks;
		while (venstre < hoyre){//ytre løkke
			/**Søker et element som er > enn pivot
			OBS! må ha venstre < hoyre for ellers går vi utover
			tabellområdet når elementene allerede er sorterte */
			while (venstre < hoyre && data[venstre].compareTo(pivot) <= 0 ){
				venstre++;
			}
			/** søker et element som er <= enn pivot */
			while (data[hoyre].compareTo(pivot) > 0){
				hoyre--;
			}
			/** bytter elementene */
			if (venstre < hoyre) {
				temp = data[venstre];
				data[venstre] = data[hoyre];
				data[hoyre] = temp;
				}//if
			}//while – ytre løkke
			/** flytter pivot til riktig og sin endelige plass */
			temp = data[min];
			data[min] = data[hoyre];
			data[hoyre] = temp;
			return hoyre;
			}// metode
}//Class


