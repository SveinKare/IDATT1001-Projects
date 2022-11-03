package Oppg2;
import java.util.Arrays;
import java.util.ArrayList;
public class Tekstanalyse {
    int[] antallTegn = new int[30];
    ArrayList<String> alfabet = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "æ", "ø", "å", "Annet symbol"));

    //Konstruktør med tekst som argument. Fyller opp tabellen
    Tekstanalyse(String tekst){
        tekst = tekst.toLowerCase();
        //For løkke for å gå gjennom teksten
        for(int i = 0; i < tekst.length(); i++){
            //Gjør om "charAt" metoden til string
            String symbol = Character.toString(tekst.charAt(i));
            //Sjekker om symbolet er i "alfabet" listen
            if(alfabet.contains(symbol)){
                //Plusser på 1 til tilsvarende indeks
                int indeks = alfabet.indexOf(symbol);
                antallTegn[indeks] += 1;
            } else{
                //Symbolet er ikke i alfabetet, plusser på 1 til siste indeks
                antallTegn[29] += 1;
            }
        }
    }

    //Antall forskjellige bokstaver
    public int antUnikeBokstaver(){
        int count = 0;
        //Går gjennom array'et utenom den siste indeksen, og plusser på count for hvert tall ulikt 0
        for (int i = 0; i < antallTegn.length - 1; i++){
            if(antallTegn[i] != 0){
                count++;
            }
        }
        return count;
    }

    //Antall bokstaver
    public int antBokstaver(){
        int sum = 0;
        //Samme som før, bare at det plusses på tallet i indeksen
        for (int i = 0; i < antallTegn.length - 1; i++){
            if (antallTegn[i] != 0){
                sum += antallTegn[i];
            }
        }
        return sum;
    }

    //Regner hvor mange prosent av teksten som ikke er bokstaver i alfabetet
    public double prosentIkkeBokstaver(){
        //Finner total tekstlengde inkludert andre tegn
        double total = antBokstaver() + antallTegn[29];
        return (antallTegn[29]/total)*100;
    }

    //Metode for hvor mange av en bokstav er i teksten
    public int hvorMange(String inn){
        //Sjekker om symbolet er i "alfabet" listen
        if(alfabet.contains(inn)){
            //Returnerer tallet i indeks til bokstaven
            return antallTegn[alfabet.indexOf(inn)];
        } else{
            //Symbolet er ikke i alfabetet, returnerer siste indeks
            return antallTegn[29];
        }
    }

    //Funksjon for bokstav(ene) som det er flest av i teskten. Returnerer en arraylist bokstavene
    public ArrayList<String> oftest(){
        int maks = 0;
        ArrayList<String> bokstaver = new ArrayList<String>();
        for (int i = 0; i < antallTegn.length; i++){
            if (antallTegn[i] > maks){
                maks = antallTegn[i];
                bokstaver.clear();
                bokstaver.add(alfabet.get(i));
            } else if(antallTegn[i] == maks){
                bokstaver.add(alfabet.get(i));
            }
        }
        return bokstaver;

    }
}
