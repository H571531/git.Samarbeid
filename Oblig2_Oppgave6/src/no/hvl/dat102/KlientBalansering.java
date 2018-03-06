package no.hvl.dat102;
public class KlientBalansering{
     public static void main(String[] args){
        //final String filnavn = "TestHelloWorldIkkeFungerende.java";
        final String filnavn = System.getProperty("user.dir") + "\\src\\no\\hvl\\dat102\\Balansering.java";
    	 //Leser inn en tekst fra fil
        Balansering balansering = new Balansering();
        balansering.lesFraFil(filnavn);
 }//main

}//class
