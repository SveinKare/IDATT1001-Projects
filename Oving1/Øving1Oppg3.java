import static javax.swing.JOptionPane.*;
class Øving1Oppg3 {
    public static void main (String[] args){
        //Leser av antall sekunder
        String sekunderLest = showInputDialog("Skriv inn antall sekunder: ");
        int sekunder = Integer.parseInt(sekunderLest);
        //Finner antall hele timer og trekker disse fra totalen. Lagrer i en variabel
        int timer = sekunder / 3600;
        sekunder = sekunder - (timer * 3600);
        //Gjør det samme med minutter
        int minutter = sekunder/60;
        sekunder = sekunder - (minutter*60);
        //Printer resultatet
        System.out.println(sekunderLest + " sekunder er " + timer + " timer, " + minutter + " minutter og " + sekunder + " sekunder.");
    }
}