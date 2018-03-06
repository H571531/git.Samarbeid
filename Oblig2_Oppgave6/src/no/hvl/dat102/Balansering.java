package no.hvl.dat102;

import java.io.*;
import no.hvl.dat102.adt.*;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.kjedetStabel.*;
//-----------------------------------------
//
//Balansering av uttrykk med parenteser {},(),[]
//} ] ) kalles lukkete symboler (høyre)
// { [ ( kalles for åpne symboler (venstre)
//...{... [...(...)...]...}... lovlig (balansert) utrykk
//...{...(...[...)...]...}... ulovlig (ikke balansert) uttrykk
//algoritme balansering
// Lag en tom stabel 
// så lenge( ikke-slutt på strengen og fortsatt balansert){
// hvis symbolet er åpent
// stable det på
// ellers hvis symbolet er lukket
// hvis stabelen er tom
// sett fortsatt = usann, feilmelding
// ellers
// stable av symbol (åpent symbol)
// hvis det åpne symbolet ikke svarer til det sist leste
// lukkete symbolet
// sett fortsatt = usann, feilmelding
// }
// hvis stabelen er ikke-tom så feilmelding */
//
//-----------------------------------------

public class Balansering {
	// Her opphever du kommentarsetning når du har fått lagt inn
	// nødvendig kode
	// SirkulaerStabel<Parentesinfo>stabel = new
	// SirkulaerStabel<Parentesinfo>();
private StabelADT<Parentesinfo> ApneSymboler=new KjedetStabel<Parentesinfo>();
	private boolean passer(char apent, char lukket) {
		switch (apent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {

		int lengde = innDataStreng.length();

        char Tegn;
        for(int i = 0; i < lengde; i++) {
            Tegn = innDataStreng.charAt(i);
            if(Tegn == '(' || Tegn == '[' || Tegn =='{') {
            	ApneSymboler.push(new Parentesinfo(linjenr, i,Tegn));
            } else if(Tegn == ')' || Tegn == ']' || Tegn == '}') {
                try {
                    Parentesinfo apen = ApneSymboler.pop();
                    if(!(passer(apen.hentVenstreparentes(), Tegn))) {
                        System.out.println("Lukketegnet " + Tegn + "på linje " + linjenr +" passer ikke åpne tegnet:  " + apen.hentVenstreparentes() +"På linje: "+ apen.hentLinjenr() );
                    }//if
                } catch(EmptyCollectionException e) {
                    System.out.println("Symbolet " + Tegn + " på linje nr " + linjenr + " mangler åpnesymbol");
                }//Catch
            }//if
        }//for

	}//

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ike filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 0;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				linjenr++;
				foretaBalansering(linje,linjenr);
				// Fyll ut
				linje = tekstLeser.readLine();
				
				
			} // while
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}
        if(!ApneSymboler.erTom()) {
            while(!ApneSymboler.erTom()) {
                Parentesinfo ingenlukk = ApneSymboler.pop();
                System.out.println("Åpnesymbol " + ingenlukk.hentVenstreparentes() + " på linje " + ingenlukk.hentLinjenr() + " har ingen lukkesymbol.");
            }//while
        }//if

	}// metode

}// class
