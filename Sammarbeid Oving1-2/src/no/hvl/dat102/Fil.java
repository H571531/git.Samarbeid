package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat102.adt.*;

/**
 * Les inn CDArkiv fra .txt-fil, eller lagre et CDArkiv til en .txt-fil
 * 
 */
public class Fil {

 private static String SKILLE = "#";

 /**
  * @param filnavn
  * @return Referansen til CD-arkivet
  * @throws java.io.IOException
  */
 public static CDArkivADT lesFraFil(String filnavn)  {

  CDArkivADT cda = null;

  try {
   // // 1 - FileReader
   FileReader ansFil = new FileReader(filnavn);

   // 2 - BufferedReader
   BufferedReader innfil = new BufferedReader(ansFil);

   // 3 - Leser den f�rste posten som er antall info-poster
   String linje = innfil.readLine();
   int n = Integer.parseInt(linje);

   // Oppretter CDarkiv
   cda = new CDArkiv(n);

   // 4 - Les postene, en hel post om gangen
    for (int i = 0; i < n; i++) {
    String post = innfil.readLine();
    String[] felt = post.split(SKILLE);
    int nr = Integer.parseInt(felt[0]);
    String artist = felt[1];
    String tittel = felt[2];
    int aar = Integer.parseInt(felt[3]);
    Sjanger sjanger = Sjanger.finnSjanger(felt[4]);
    String plselskap = felt[5];
    
    CD cd = new CD(nr, artist, tittel, aar, sjanger, plselskap);
    cda.leggTilCD(cd);    
   }

   // 4 - Lukk filen
   innfil.close();

  } 
  catch (FileNotFoundException unntak) {//arver fra IOException m� st� f�rst
                                        // hvis ikke vil unntaket for IOException skygge
   System.out.println("Finner ikke filen " + filnavn);
   System.exit(1);
  } 
  catch (IOException e) {
   System.out.println("Feil ved lesing av fil: " + e);
   System.exit(2);
  }
  
  return cda;
 }

 public static void skrivTilFil(CDArkivADT cdarkiv, String filnavn){
	 try {
         // 1 - FileWriter
         FileWriter ansFil = new FileWriter(filnavn, false);
         
         // 2 - PrintWriter
         PrintWriter utfil = new PrintWriter(ansFil);
         
         //3 - Skriver f�rst ut antall ansatt-info-er p� den f�rste linjen            
         utfil.println(cdarkiv.getAntall());
         
         // Hvis vi tar imot en tabell av ansatte, ville vi her lage en l�kke der
         // vi for hver ansatt henter ut feltvariable og skriver de ut p� samme linje
         
         // 3 - Skriv postene, felt for felt
         CD[] tabell=cdarkiv.getCDTabell();
         //(nr, artist, tittel, aar, sjanger, plselskap);
         for(int i=0; i<cdarkiv.getAntall();i++) {
        	 utfil.print(tabell[i].getCdNummer()); utfil.print(SKILLE);
        	 utfil.print(tabell[i].getCdArtist()); utfil.print(SKILLE);
        	 utfil.print(tabell[i].getCdTittel()); utfil.print(SKILLE);
        	 utfil.print(tabell[i].getCdLansering()); utfil.print(SKILLE);
        	 utfil.print(tabell[i].getCdSjanger()); utfil.print(SKILLE);
        	 utfil.print(tabell[i].getPlateselskap());
        	 utfil.println();
         }
         utfil.close();
	 }catch(Exception e) {
         System.out.println("Feil ved skriving til fil : " + e);
         System.exit(3);
	 }
 }

}// class
