import static javax.swing.JOptionPane.*;
class Øving1Oppg2 {
    public static void main (String[] args){
        //Leser av timer, minutter og sekunder
        String timerLest = showInputDialog("Skriv inn antall timer: ");
        String minutterLest = showInputDialog("Skriv inn antall minutter: ");
        String sekunderLest = showInputDialog("Skriv inn antall sekunder: ");
        //Konverterer til double
        double timer = Double.parseDouble(timerLest);
        double minutter = Double.parseDouble(minutterLest);
        double sekunder = Double.parseDouble(sekunderLest);
        //Gjør om til sekunder og legger sammen
        timer = timer * 3600;
        minutter = minutter * 60;
        double total = timer + minutter + sekunder;
        //Printer
        System.out.println(timerLest + " timer, " + minutterLest + " minutter og " + sekunderLest + " sekunder er totalt " + total + " sekunder.");
    }
}