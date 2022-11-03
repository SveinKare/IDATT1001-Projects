package Oppg2;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class Client {
    public static void main(String[] args) {
        while(true){
            String tekst = JOptionPane.showInputDialog(null, "Skriv inn en tekst, eller skriv \"exit\" for å avslutte.");
            //Sjekker om brukeren vil avslutte
            if (tekst.equalsIgnoreCase("exit")){
                break;
            }

            //Kaller alle metodene
            Tekstanalyse objekt = new Tekstanalyse(tekst);
            int unikeBokstaver = objekt.antUnikeBokstaver();
            int antBokstaver = objekt.antBokstaver();
            double prosent = objekt.prosentIkkeBokstaver();
            int hvorMange = objekt.hvorMange("a");
            ArrayList<String> oftest = objekt.oftest();

            //Printer resultater
            System.out.println("Teksten inneholder " + unikeBokstaver + " forskjellige bokstaver.");
            System.out.println("Teksten har totalt " + antBokstaver + " bokstaver.");
            System.out.println(prosent + "% av teksten er ikke bokstaver.");
            System.out.println("Bokstaven a forekommer " + hvorMange + " ganger.");
            System.out.println("Bokstav(ene) " + oftest + " forekommer oftest i teksten.");
        }
    }   
}
