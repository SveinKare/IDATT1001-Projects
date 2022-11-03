package Oppg2;
import java.util.Arrays;
import java.util.ArrayList;
public class TekstBehandling {
    private String tekst;
    ArrayList<Character> alfabet = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'æ', 'ø', 'å', ' '));

    //Konstruktør
    TekstBehandling(String tekst){
        this.tekst = tekst;
    }

    //Finner antall ord.
    int antallOrd(){
        //Lager array med alle ordene, og returnerer lengden
        String[] temp = tekst.split(" ");
        return temp.length;
    }

    //Regner gjennomsnittlig ordlengde
    double gOrdLengde(){

        //Lager ny lowercase string av tekst
        String nyTekst = tekst.toLowerCase();
        //Lager array av alle symbolene
        char[] symboler = nyTekst.toCharArray();
        
        for (int i = 0; i < symboler.length; i++){
            //Fjerner symboler som ikke er i "alfabet"-listen 
            if(!(alfabet.contains(symboler[i]))){
                nyTekst = nyTekst.replace(Character.toString(symboler[i]), "");
            }
        }

        //Lager array av alle ordene i nyTekst
        String[] temp = nyTekst.split(" ");

        double totalLengde = 0;
        //Regner lengde for hvert ord og returnerer gjennomsnittet
        for (int i = 0; i < temp.length; i++){
            totalLengde += temp[i].length();
        }
        //Runder av til to desimaler
        return (double) Math.round((totalLengde/temp.length)*100)/100;
    }
    //Regner gjennomsnittlig ord per periode
    double ordPerPeriode(){
        String nyTekst = tekst;
        //Erstatter skilletegn med felles symbol
        nyTekst = nyTekst.replace(".", "%");
        nyTekst = nyTekst.replace(":", "%");
        nyTekst = nyTekst.replace("?", "%");
        nyTekst = nyTekst.replace("!", "%");
        //Lager "temp" som gir antall perioder, og "temp2" som gir antall ord. Returnerer snittet
        String[] temp = nyTekst.split("%");
        String[] temp2 = tekst.split(" ");
        double l1 = temp.length;
        double l2 = temp2.length;
        return l2/l1;
    }

    //Erstatter et ord med et annet
    String erstatt(String gammeltOrd, String nyttOrd){
        String nyTekst = tekst;
        //Bruker mellomrom for å kun bytte ut hele ord
        gammeltOrd = " " + gammeltOrd + " ";
        nyttOrd = " " + nyttOrd + " ";
        return nyTekst.replaceAll(gammeltOrd, nyttOrd);
    }

    //Get metode for teksten
    String getTekst(){
        return tekst;
    }

    String getSTekst(){
        return tekst.toUpperCase();
    }
}
