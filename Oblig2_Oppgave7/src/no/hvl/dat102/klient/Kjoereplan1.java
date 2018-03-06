package no.hvl.dat102.klient;

// M� ha k�-klasse tilgjengelig i prosjektet

//---------------------------------------------------------------------------
import java.util.Scanner;

import no.hvl.dat102.Jobb;
import no.hvl.dat102.JobbSamling;
import no.hvl.dat102.sirkulaerKoe.SirkulaerKoeMedUnntak;
public class Kjoereplan1{
	
    public static void main(String[] args){
    	//Fyll ut
        Scanner tastatur = new Scanner(System.in);
        JobbSamling js = new JobbSamling();
        SirkulaerKoeMedUnntak<Jobb> klarKoe = new SirkulaerKoeMedUnntak<Jobb>();
        
        Jobb jobb = null;
        int klokke = 0;
        int tidskrav = 0;
        int antall = 0;

        //Leser fra fil
        System.out.print("Oppgi datafil:");
        String filnavn = tastatur.nextLine();
        System.out.println("Datafil: " + filnavn);
        
        //Lagt til:
        tastatur.close();
        ///
        js.lesFraFil(filnavn);
        
        //antall = js.hentAntall();
        //Forandrer til js.getAntall();
        antall = js.getAntall();
        
        System.out.println("antall " + antall);
        JobbSamling ferdige = new JobbSamling(antall);

        while(ferdige.getAntall() < antall){//Ytre l�kke
            
            //Henter eventuelle jobber til klark�en
            do{
                jobb = js.hentAnkommenJobb(klokke);
                if(jobb != null){
                    klarKoe.innKoe(jobb);
                }
                
            }while(jobb != null);

            //Ta eventuelt ut jobb fra k� A til CPU
            if(klarKoe.antall() > 0){
                jobb = (Jobb)klarKoe.utKoe();
                tidskrav = jobb.getKjoeretid();
                klokke = klokke + tidskrav;
                jobb.setFerdigTid(klokke);
                ferdige.leggTil(jobb);
             }else  // Ingen jobber klar til kj�ring
                   klokke = klokke + 1;
         }//while       
                       
       
        ferdige.visJobber();                  
    }//main
}//class